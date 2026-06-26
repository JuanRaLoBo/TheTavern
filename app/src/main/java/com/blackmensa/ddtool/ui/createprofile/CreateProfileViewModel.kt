package com.blackmensa.ddtool.ui.createprofile

import androidx.lifecycle.ViewModel
import com.blackmensa.ddtool.data.repository.CharacterRepository
import com.blackmensa.ddtool.domain.model.CharacterProfile


class CreateProfileViewModel(private val repository: CharacterRepository) : ViewModel() {

    fun canSave(character: CharacterProfile?, ownerEmail: String?): Boolean {
        return character != null &&
                !ownerEmail.isNullOrBlank() &&
                character.name.isNotBlank() &&
                character.level > 0
    }
    fun saveCharacter(character: CharacterProfile, ownerEmail: String?): Boolean {
        if (ownerEmail.isNullOrBlank()) {
            return false
        }

        return repository.addCharacterProfile(character, ownerEmail)
    }
}
