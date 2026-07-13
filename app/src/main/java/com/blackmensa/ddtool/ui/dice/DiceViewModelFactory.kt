package com.blackmensa.ddtool.ui.dice

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.blackmensa.ddtool.data.repository.CharacterRepository

class DiceViewModelFactory(
    private val repository: CharacterRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DiceViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DiceViewModel(repository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}