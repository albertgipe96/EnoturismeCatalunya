package com.development.dos.domain.model

data class Do(
    val id: Int,
    val name: String,
    val description: String,
    val logoUrl: String,
    val imageUrl: String,
    val email: String,
    val phone: String,
    val website: String
)