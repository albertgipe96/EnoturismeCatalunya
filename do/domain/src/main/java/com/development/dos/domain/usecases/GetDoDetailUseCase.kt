package com.development.dos.domain.usecases

import com.development.dos.domain.DoRepository
import com.development.dos.domain.model.Do
import javax.inject.Inject

class GetDoDetailUseCase @Inject constructor(
    private val doRepository: DoRepository
) {
    suspend operator fun invoke(id: Int): Result<Do> {
        return doRepository.getDoById(id)
    }
}
