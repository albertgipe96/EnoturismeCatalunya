package com.development.dos.domain

import com.development.dos.domain.model.Cellar

interface CellarRepository {
    suspend fun getCellarListByDo(id: Int): Result<List<Cellar>>
    suspend fun getCellarById(id: Int): Result<Cellar>
}
