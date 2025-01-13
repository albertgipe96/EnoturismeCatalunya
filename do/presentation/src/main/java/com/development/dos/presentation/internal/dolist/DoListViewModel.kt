package com.development.dos.presentation.internal.dolist

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.development.dos.presentation.internal.model.DoListItem
import com.development.dos.presentation.internal.usecases.GetDoListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

internal data class DoListState(
    val doList: List<DoListItem> = emptyList()
)

@HiltViewModel
internal class DoListViewModel @Inject constructor(
    private val getDoListUseCase: GetDoListUseCase
) : ViewModel() {

    private val _state = mutableStateOf(DoListState())
    val state: State<DoListState> get() = _state

    init {
        viewModelScope.launch {
            getDoListUseCase()
                .onSuccess {
                    _state.value = state.value.copy(doList = it)
                }
                .onFailure {
                    Log.e("getDoListUseCase", "Error: $it")
                }
        }
    }

}