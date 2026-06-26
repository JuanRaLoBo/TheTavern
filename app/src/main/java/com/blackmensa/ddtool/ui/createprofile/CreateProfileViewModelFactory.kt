package com.blackmensa.ddtool.ui.createprofile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.blackmensa.ddtool.data.repository.CharacterRepository

class CreateProfileViewModelFactory(
    private val repository: CharacterRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CreateProfileViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CreateProfileViewModel(repository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}