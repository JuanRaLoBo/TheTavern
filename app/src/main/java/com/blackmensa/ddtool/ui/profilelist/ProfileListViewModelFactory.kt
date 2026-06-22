package com.blackmensa.ddtool.ui.profilelist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.blackmensa.ddtool.data.repository.CharacterRepository

class ProfileListViewModelFactory(
    private val repository: CharacterRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProfileListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ProfileListViewModel(repository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}