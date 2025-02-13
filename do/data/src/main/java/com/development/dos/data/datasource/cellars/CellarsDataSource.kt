package com.development.dos.data.datasource.cellars

import com.development.dos.data.model.CellarDataModel

interface CellarsDataSource {
    suspend fun getCellarsByDo(id: Int): Result<List<CellarDataModel>>
    suspend fun getCellar(cellarId: Int): Result<CellarDataModel>
}
