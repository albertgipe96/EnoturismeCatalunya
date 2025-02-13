package com.development.dos.data.model

import com.development.core.domain.model.LatLng
import com.development.dos.domain.model.Cellar
import kotlinx.serialization.Serializable

@Serializable
data class CellarListDataModel(
    val data: List<CellarDataModel>
)

@Serializable
data class CellarDataModel(
    val id: Int,
    val name: String,
    val description: String,
    val imageUrls: List<String>,
    val email: String,
    val phone: String,
    val website: String,
    val location: CellarLocation
) {
    fun toCellar(): Cellar {
        return Cellar(
            id, name, description, imageUrls, email, phone, website,
            location = LatLng(location.latitude, location.longitude)
        )
    }
}

@Serializable
data class CellarLocation(
    val latitude: Double,
    val longitude: Double
)
