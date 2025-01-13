package com.development.dos.presentation.internal.usecases

import com.development.dos.domain.DoRepository
import com.development.dos.domain.model.Do
import javax.inject.Inject

internal class GetDoDetailUseCase @Inject constructor(
    private val doRepository: DoRepository
) {
    suspend operator fun invoke(id: Int): Result<Do> {
        return doRepository.getDoById(id)
    }
}