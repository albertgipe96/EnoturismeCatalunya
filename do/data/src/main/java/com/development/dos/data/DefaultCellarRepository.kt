package com.development.dos.data

import com.development.core.data.di.IO
import com.development.dos.data.datasource.cellars.CellarsDataSource
import com.development.dos.domain.CellarRepository
import com.development.dos.domain.model.Cellar
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class DefaultCellarRepository @Inject constructor(
    private val cellarsDataSource: CellarsDataSource,
    @IO private val dispatcherIO: CoroutineDispatcher
) : CellarRepository {

    override suspend fun getCellarListByDo(id: Int): Result<List<Cellar>> {
        return with(dispatcherIO) {
            cellarsDataSource.getCellarsByDo(id).map { it.map { cellar -> cellar.toCellar() } }
        }
    }

    override suspend fun getCellarById(id: Int): Result<Cellar> {
        return with(dispatcherIO) {
            cellarsDataSource.getCellar(id).map { cellar -> cellar.toCellar() }
        }
    }
}
