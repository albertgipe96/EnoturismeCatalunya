package com.development.dos.data

import com.development.core.data.di.IO
import com.development.dos.data.datasource.denoms.DenomsDataSource
import com.development.dos.domain.DoRepository
import com.development.dos.domain.model.Do
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class DefaultDoRepository @Inject constructor(
    private val denomsDataSource: DenomsDataSource,
    @IO private val dispatcherIO: CoroutineDispatcher
) : DoRepository {

    override suspend fun getDoList(): Result<List<Do>> {
        return with(dispatcherIO) {
            denomsDataSource.getDoList().map { it.map { denom -> denom.toDo() } }
        }
    }

    override suspend fun getDoById(id: Int): Result<Do> {
        return with(dispatcherIO) {
            denomsDataSource.getDoById(id).map { denom -> denom.toDo() }
        }
    }
}
