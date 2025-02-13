package com.development.dos.data.datasource.denoms

import android.content.Context
import com.development.dos.data.model.DoDataModel
import com.development.dos.data.model.DoListDataModel
import com.development.dos.domain.model.Do
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.serialization.json.Json
import javax.inject.Inject
import kotlin.coroutines.cancellation.CancellationException

class LocalDenomsDataSource @Inject constructor(
    @ApplicationContext private val context: Context
) : DenomsDataSource {
    override suspend fun getDoList(): Result<List<DoDataModel>> {
        return try {
            val data = readFromJson().data
            Result.success(data)
        } catch (e: Exception) {
            if (e is CancellationException) throw e
            Result.failure(Exception("Couldn't get data from json"))
        }
    }

    override suspend fun getDoById(id: Int): Result<DoDataModel> {
        return try {
            val data = readFromJson().data
                .first { it.id == id }
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
