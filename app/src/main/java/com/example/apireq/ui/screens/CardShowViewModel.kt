package com.example.apireq.ui.screens

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apireq.data.Animal
import com.example.apireq.remote.repository.AppRepo
import com.example.apireq.resource.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class CardShowUiState(
    val isLoading: Boolean = false,
    val animals: List<Animal> = emptyList(),
    val error: String? = null
)



@HiltViewModel
class CardShowViewModel @Inject constructor(
    private val appRepo: AppRepo
) : ViewModel() {

    private val _uiState = MutableStateFlow(CardShowUiState())
    val uiState: StateFlow<CardShowUiState> = _uiState.asStateFlow()

    init {
        getAllAnimals()
    }

    private fun getAllAnimals() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }

            Log.d("CardShowViewModel", "getAllAnimals: Loading...")
            Log.d("CardShowViewModel", "getAllAnimals: ${appRepo.getAllAnimals().toString()}")
            when (val result = appRepo.getAllAnimals()) {
                is Response.Loading -> {
                    // Optional if you want to handle loading differently
                    _uiState.update { it.copy(isLoading = true) }
                }
                is Response.Success -> {
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            animals = result.data,
                            error = null
                        )
                    }
                }
                is Response.Error -> {
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            error = result.message
                        )
                    }
                }
            }
        }
    }
}
