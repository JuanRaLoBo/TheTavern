package com.blackmensa.ddtool.ui.dice

import androidx.lifecycle.ViewModel
import com.blackmensa.ddtool.data.repository.CharacterRepository
import com.blackmensa.ddtool.domain.model.CharacterProfile

class DiceViewModel(
    private val repository: CharacterRepository
) : ViewModel() {

    fun getSelectedCharacter(id: Int): CharacterProfile? {
        return repository.getCharacterById(id)
    }
}