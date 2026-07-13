package com.blackmensa.ddtool.ui.dice

import androidx.lifecycle.ViewModel
import com.blackmensa.ddtool.data.repository.CharacterRepository
import com.blackmensa.ddtool.domain.model.CharacterProfile

class DiceViewModel(
    private val repository: CharacterRepository
) : ViewModel() {

    fun getSelectedCharacter(characterId: Int): CharacterProfile? {
        if (characterId < 0) {
            return null
        }
        return repository.getCharacterById(characterId)
    }
}