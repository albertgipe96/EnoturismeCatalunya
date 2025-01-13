package com.development.dos.presentation.api

import androidx.compose.runtime.Composable
import com.development.dos.presentation.internal.dodetail.DoDetailInternal

@Composable
fun DoDetailScreen(
    onBack: () -> Unit
) {
    DoDetailInternal(
        onBack = onBack
    )
}