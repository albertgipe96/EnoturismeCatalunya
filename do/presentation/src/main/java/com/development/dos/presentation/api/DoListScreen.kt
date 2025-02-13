package com.development.dos.presentation.api

import androidx.compose.runtime.Composable
import com.development.core.designsystem.components.scaffold.ScaffoldState
import com.development.dos.presentation.internal.dolist.DoListInternal

@Composable
fun DoListScreen(
    scaffoldState: ScaffoldState,
    onDoSelected: (Int) -> Unit
) {
    DoListInternal(
        scaffoldState = scaffoldState,
        onDoSelected = onDoSelected
    )
}
