@file:OptIn(ExperimentalMaterial3Api::class)

package com.development.dos.presentation.internal.dodetail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import com.development.dos.domain.model.Do

@Composable
internal fun DoDetailInternal(
    viewModel: DoDetailViewModel = hiltViewModel(),
    onBack: () -> Unit
) {
    val uiState = viewModel.state.value
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = when (uiState) {
                            DoDetailState.Loading -> ""
                            is DoDetailState.Loaded -> uiState.doDetail.name
                            is DoDetailState.Error -> ""
                        }
                    )
                },
                navigationIcon = {
                    Icon(
                        painter = rememberVectorPainter(Icons.AutoMirrored.Filled.ArrowBack),
                        contentDescription = null,
                        modifier = Modifier.clickable { onBack() }
                    )
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when (uiState) {
                is DoDetailState.Error -> Text(text = uiState.message)
                is DoDetailState.Loaded -> {
                    DoDetail(
                        doDetail = uiState.doDetail,
                        onPhoneClick = { viewModel.onEvent(DoDetailEvent.OpenDial(uiState.doDetail.phone)) },
                        onEmailClick = { viewModel.onEvent(DoDetailEvent.SendEmail(uiState.doDetail.email)) },
                        onWebsiteClick = { viewModel.onEvent(DoDetailEvent.VisitWebsite(uiState.doDetail.website)) }
                    )
                }
                DoDetailState.Loading -> CircularProgressIndicator()
            }
        }
    }
}

@Composable
private fun ColumnScope.DoDetail(
    doDetail: Do,
    onPhoneClick: () -> Unit,
    onEmailClick: () -> Unit,
    onWebsiteClick: () -> Unit
) {
    AsyncImage(
        model = doDetail.logoUrl,
        contentDescription = null
    )
    Spacer(Modifier.height(8.dp))
    Text(
        text = doDetail.name
    )
    Spacer(Modifier.height(16.dp))
    Text(
        text = doDetail.description
    )
    Spacer(Modifier.height(16.dp))
    AsyncImage(
        model = doDetail.imageUrl,
        contentDescription = null
    )
    Spacer(Modifier.height(16.dp))
    Text(
        text = doDetail.phone,
        modifier = Modifier.clickable { onPhoneClick() }
    )
    Spacer(Modifier.height(8.dp))
    Text(
        text = doDetail.email,
        modifier = Modifier.clickable { onEmailClick() }
    )
    Spacer(Modifier.height(8.dp))
    Text(
        text = doDetail.website,
        modifier = Modifier.clickable { onWebsiteClick() }
    )
}