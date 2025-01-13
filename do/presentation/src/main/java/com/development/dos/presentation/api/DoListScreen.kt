package com.development.dos.presentation.api

import androidx.compose.runtime.Composable
import com.development.dos.presentation.internal.dolist.DoListInternal

@Composable
fun DoListScreen(
    onDoSelected: (Int) -> Unit
) {
    DoListInternal(
        onDoSelected = onDoSelected
    )
}