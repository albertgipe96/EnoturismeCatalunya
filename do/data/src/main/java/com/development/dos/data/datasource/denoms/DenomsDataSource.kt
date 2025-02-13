package com.development.dos.data.datasource.denoms

import com.development.dos.data.model.DoDataModel

interface DenomsDataSource {
    suspend fun getDoList(): Result<List<DoDataModel>>
    suspend fun getDoById(id: Int): Result<DoDataModel>
}
