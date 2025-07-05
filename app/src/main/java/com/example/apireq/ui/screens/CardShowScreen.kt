package com.example.apireq.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.apireq.ui.CustomCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardShowScreen(
    modifier: Modifier = Modifier,
    viewModel: CardShowViewModel = hiltViewModel()
){
    val uiState = viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Amphibians")
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
            )
        }
    ) { innerPadding ->
        LazyColumn (
            modifier = Modifier
                .padding(innerPadding)
        ){
            items(uiState.value.animals.size){ it ->
                CustomCard(
                    title = uiState.value.animals[it].name,
                    type = uiState.value.animals[it].type,
                    description = uiState.value.animals[it].description,
                    cardImg = uiState.value.animals[it].cardImg
                )
            }
        }
    }
}

@Preview
@Composable
fun CardShowScreenPreview(){
    CardShowScreen()
}