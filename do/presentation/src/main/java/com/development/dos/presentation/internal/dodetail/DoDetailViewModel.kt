package com.development.dos.presentation.internal.dodetail

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.development.core.domain.usecases.OpenDialUseCase
import com.development.core.domain.usecases.SendEmailUseCase
import com.development.dos.domain.model.Cellar
import com.development.dos.domain.model.Do
import com.development.dos.domain.usecases.GetDoCellarsUseCase
import com.development.dos.presentation.api.NavRoute
import com.development.dos.domain.usecases.GetDoDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed interface DoDetailState {
    data object Loading : DoDetailState
    data class Loaded(val doDetail: Do, val cellars: List<Cellar>) : DoDetailState
    data class Error(val message: String) : DoDetailState
}

internal sealed interface DoDetailEvent {
    data class SendEmail(val email: String) : DoDetailEvent
    data class OpenDial(val phone: String) : DoDetailEvent
    data class VisitWebsite(val website: String) : DoDetailEvent
}

@HiltViewModel
internal class DoDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getDoDetailUseCase: GetDoDetailUseCase,
    private val getDoCellarsUseCase: GetDoCellarsUseCase,
    private val openDialUseCase: OpenDialUseCase,
    private val sendEmailUseCase: SendEmailUseCase
) : ViewModel() {

    private val id: Int = savedStateHandle.toRoute<NavRoute.DoDetail>().id

    private val _state = mutableStateOf<DoDetailState>(DoDetailState.Loading)
    val state: State<DoDetailState> get() = _state

    init {
        viewModelScope.launch {
            getDoDetailUseCase(id)
                .onSuccess { doDetail ->
                    getDoCellarsUseCase(id)
                        .onSuccess { cellars ->
                            _state.value = DoDetailState.Loaded(doDetail, cellars)
                        }
                        .onFailure {
                            Log.e("getDoCellarsUseCase", "Error: $it")
                            _state.value = DoDetailState.Loaded(doDetail, emptyList())
                        }
                }
                .onFailure {
                    Log.e("getDoDetailUseCase", "Error: $it")
                    _state.value = DoDetailState.Error("No s'ha pogut carregar el contingut")
                }
        }
    }

    fun onEvent(event: DoDetailEvent) {
        when (event) {
            is DoDetailEvent.OpenDial -> openDialUseCase(event.phone)
            is DoDetailEvent.SendEmail -> sendEmailUseCase(event.email)
            is DoDetailEvent.VisitWebsite -> {}
        }
    }

}
