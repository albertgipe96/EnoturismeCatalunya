package com.development.dos.domain.usecases

import com.development.dos.domain.CellarRepository
import com.development.dos.domain.model.Cellar
import javax.inject.Inject

class GetDoCellarsUseCase @Inject constructor(
    private val cellarRepository: CellarRepository
) {
    suspend operator fun invoke(id: Int): Result<List<Cellar>> {
        return cellarRepository.getCellarListByDo(id)
    }
}
