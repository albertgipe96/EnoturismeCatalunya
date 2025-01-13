package com.development.dos.presentation.internal.dolist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.development.dos.presentation.internal.dolist.components.DoListItem

@Composable
internal fun DoListInternal(
    viewModel: DoListViewModel = hiltViewModel(),
    onDoSelected: (Int) -> Unit
) {
    val uiState = viewModel.state.value

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(paddingValues),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(uiState.doList) { denom ->
                DoListItem(
                    doListItem = denom,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .clickable { onDoSelected(denom.id) }
                )
            }
        }
    }
}