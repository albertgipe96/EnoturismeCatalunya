package com.development.dos.presentation.api

import androidx.compose.runtime.Composable
import com.development.core.designsystem.components.scaffold.ScaffoldState
import com.development.dos.presentation.internal.dodetail.DoDetailInternal

@Composable
fun DoDetailScreen(
    scaffoldState: ScaffoldState,
    onBack: () -> Unit,
    onCellarClick: (Int) -> Unit
) {
    DoDetailInternal(
        scaffoldState = scaffoldState,
        onBack = onBack,
        onCellarClick = onCellarClick
    )
}
