package com.development.dos.data

import android.content.Context
import com.development.dos.data.model.DoListDataModel
import com.development.dos.domain.DoRepository
import com.development.dos.domain.model.Do
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.serialization.json.Json
import javax.inject.Inject
import kotlin.coroutines.cancellation.CancellationException

class LocalDoRepository @Inject constructor(
    @ApplicationContext private val context: Context
) : DoRepository {
    override suspend fun getDoList(): Result<List<Do>> {
        return try {
            val data = readFromJson().data.map { it.toDo() }
            Result.success(data)
        } catch (e: Exception) {
            if (e is CancellationException) throw e
            Result.failure(Exception("Couldn't get data from json"))
        }
    }

    override suspend fun getDoById(id: Int): Result<Do> {
        return try {
            val data = readFromJson().data
                .first { it.id == id }
                .toDo()
            Result.success(data)
        } catch (e: Exception) {
            if (e is CancellationException) throw e
            Result.failure(Exception("Couldn't get data from json"))
        }
    }

    private fun readFromJson(): DoListDataModel {
        val jsonString = context.assets.open(DENOMINACIONS_JSON)
            .bufferedReader()
            .use { it.readText() }
        return Json.decodeFromString<DoListDataModel>(jsonString)
    }
}

private const val DENOMINACIONS_JSON = "denominacions.json"