package com.development.dos.data.model

import com.development.dos.domain.model.Do
import kotlinx.serialization.Serializable

@Serializable
data class DoListDataModel(
    val data: List<DoDataModel>
)

@Serializable
data class DoDataModel(
    val id: Int,
    val name: String,
    val description: String,
    val logoUrl: String,
    val imageUrl: String,
    val email: String,
    val phone: String,
    val website: String
) {
    fun toDo(): Do {
        return Do(id, name, description, logoUrl, imageUrl, email, phone, website)
    }
}
