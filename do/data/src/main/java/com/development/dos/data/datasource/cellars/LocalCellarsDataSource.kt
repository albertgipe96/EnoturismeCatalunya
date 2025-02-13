package com.development.dos.data.datasource.cellars

import android.content.Context
import com.development.dos.data.model.CellarDataModel
import com.development.dos.data.model.CellarListDataModel
import com.development.dos.data.model.DoListDataModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.serialization.json.Json
import javax.inject.Inject
import kotlin.coroutines.cancellation.CancellationException

class LocalCellarsDataSource @Inject constructor(
    @ApplicationContext private val context: Context
) : CellarsDataSource {

    override suspend fun getCellarsByDo(id: Int): Result<List<CellarDataModel>> {
        return try {
            val data = readFromJson(id).data
            Result.success(data)
        } catch (e: Exception) {
            if (e is CancellationException) throw e
            Result.failure(Exception("Couldn't get data from json"))
        }
    }

    override suspend fun getCellar(cellarId: Int): Result<CellarDataModel> {
        return Result.failure(Exception("Not implemented yet"))
    }

    private fun readFromJson(id: Int): CellarListDataModel {
        val jsonFile = when (id) {
            1 -> "do_alella.json"
            2 -> ""
            3 -> ""
            4 -> ""
            5 -> ""
            6 -> ""
            7 -> ""
            8 -> ""
            9 -> ""
            10 -> ""
            11 -> ""
            else -> throw Exception()
        }
        val jsonString = context.assets.open(jsonFile)
            .bufferedReader()
            .use { it.readText() }
        return Json.decodeFromString<CellarListDataModel>(jsonString)
    }

}
