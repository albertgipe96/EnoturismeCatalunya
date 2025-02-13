package com.development.dos.presentation.api

import kotlinx.serialization.Serializable

sealed interface NavRoute {
    @Serializable data object DoList : NavRoute
    @Serializable data class DoDetail(val id: Int) : NavRoute
    @Serializable data class CellarDetail(val cellarId: Int) : NavRoute
}
