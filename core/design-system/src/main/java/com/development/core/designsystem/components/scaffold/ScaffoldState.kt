package com.development.core.designsystem.components.scaffold

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color

@Composable
fun rememberScaffoldState(
    topBar: @Composable () -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    containerColor: Color = MaterialTheme.colorScheme.background,
    contentColor: Color = contentColorFor(containerColor)
) : ScaffoldState =
    remember(topBar, bottomBar, containerColor, contentColor) {
        ScaffoldState(
            topBar = mutableStateOf(topBar),
            bottomBar = mutableStateOf(bottomBar),
            containerColor = mutableStateOf(containerColor),
            contentColor = mutableStateOf(contentColor)
        )
    }

class ScaffoldState(
    val topBar: MutableState<@Composable () -> Unit>,
    val bottomBar: MutableState<@Composable () -> Unit>,
    val containerColor: MutableState<Color>,
    val contentColor: MutableState<Color>
) {
    @Composable
    fun SetScaffold(
        topBar: @Composable () -> Unit = {},
        bottomBar: @Composable () -> Unit = {},
        containerColor: Color = MaterialTheme.colorScheme.background,
        contentColor: Color = contentColorFor(containerColor)
    ) {
        this.topBar.value = topBar
        this.bottomBar.value = bottomBar
        this.containerColor.value = containerColor
        this.contentColor.value = contentColor
    }
}
