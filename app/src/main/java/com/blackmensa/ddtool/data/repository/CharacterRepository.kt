package com.blackmensa.ddtool.data.repository

import com.blackmensa.ddtool.core.DataBaseManager
import com.blackmensa.ddtool.domain.model.CharacterProfile

class CharacterRepository(
    private val dataBaseManager: DataBaseManager
) {
    fun getProfilesForUser(email: String?): List<CharacterProfile> {
        if (email == null) {
            return emptyList()
        }

        return dataBaseManager.getCharacterProfiles(email)
    }
}