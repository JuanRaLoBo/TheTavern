package com.blackmensa.ddtool.ui.profilelist

import androidx.lifecycle.ViewModel
import com.blackmensa.ddtool.data.repository.CharacterRepository
import com.blackmensa.ddtool.domain.model.CharacterProfile

class ProfileListViewModel(
    private val repository: CharacterRepository
) : ViewModel() {

    fun loadProfiles(email: String?): List<CharacterProfile> {
        return repository.getProfilesForUser(email)
    }
}