package com.development.dos.domain

import com.development.dos.domain.model.Do

interface DoRepository {
    suspend fun getDoList(): Result<List<Do>>
    suspend fun getDoById(id: Int): Result<Do>
}