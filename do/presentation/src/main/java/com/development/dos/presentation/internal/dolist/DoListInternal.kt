@file:OptIn(ExperimentalMaterial3Api::class)

package com.development.dos.presentation.internal.dolist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.development.core.designsystem.components.scaffold.ScaffoldState
import com.development.dos.presentation.internal.dodetail.DoDetailState
import com.development.dos.presentation.internal.dolist.components.DoListItem

@Composable
internal fun DoListInternal(
    scaffoldState: ScaffoldState,
    viewModel: DoListViewModel = hiltViewModel(),
    onDoSelected: (Int) -> Unit
) {
    val uiState = viewModel.state.value

    scaffoldState.SetScaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Denominacions d'Origen")
                }
            )
        }
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
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
