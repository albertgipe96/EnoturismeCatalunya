package com.development.dos.presentation.internal.dolist

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.development.dos.presentation.internal.model.DoListItem
import com.development.dos.domain.usecases.GetDoListUseCase
import com.development.dos.presentation.internal.mappers.DoUiMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

internal data class DoListState(
    val doList: List<DoListItem> = emptyList()
)

@HiltViewModel
internal class DoListViewModel @Inject constructor(
    private val getDoListUseCase: GetDoListUseCase,
    private val mapper: DoUiMapper
) : ViewModel() {

    private val _state = mutableStateOf(DoListState())
    val state: State<DoListState> get() = _state

    init {
        viewModelScope.launch {
            getDoListUseCase()
                .onSuccess {
                    _state.value = with(mapper) { state.value.copy(doList = it.map { it.toDoListItem() }) }
                }
                .onFailure {
                    Log.e("getDoListUseCase", "Error: $it")
                }
        }
    }

}
