package com.development.dos.presentation.internal.usecases

import com.development.dos.domain.DoRepository
import com.development.dos.domain.model.Do
import com.development.dos.presentation.internal.model.DoListItem
import javax.inject.Inject

internal class GetDoListUseCase @Inject constructor(
    private val doRepository: DoRepository
) {
    suspend operator fun invoke(): Result<List<DoListItem>> {
        return doRepository.getDoList().map { it.map { it.toDoListItem() } }
    }

    private fun Do.toDoListItem(): DoListItem {
        return DoListItem(
            id = id, name = name, logoUrl = logoUrl
        )
    }
}