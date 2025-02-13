package com.development.core.designsystem.components.scaffold

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun EnoturismeCatalunyaScaffold(
    modifier: Modifier = Modifier,
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    content: @Composable (ScaffoldState) -> Unit
) {
    Scaffold(
        modifier = modifier,
        topBar = scaffoldState.topBar.value,
        bottomBar = scaffoldState.bottomBar.value,
        containerColor = scaffoldState.containerColor.value,
        contentColor = scaffoldState.contentColor.value,
        content = remember {
            { paddingValues ->
                Box(
                    modifier = Modifier.padding(paddingValues).fillMaxSize()
                ) {
                    content(scaffoldState)
                }
            }
        }
    )
}
