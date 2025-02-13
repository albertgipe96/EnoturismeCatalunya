package com.development.dos.domain.model

import com.development.core.domain.model.LatLng

data class Cellar(
    val id: Int,
    val name: String,
    val description: String,
    val imageUrls: List<String>,
    val email: String,
    val phone: String,
    val website: String,
    val location: LatLng
)
