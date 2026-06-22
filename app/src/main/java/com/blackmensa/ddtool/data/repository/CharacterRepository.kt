package com.blackmensa.ddtool.data.repository

import com.blackmensa.ddtool.core.DataBaseManager
import com.blackmensa.ddtool.domain.model.CharacterProfile

class CharacterRepository(
    private val dataBaseManager: DataBaseManager
) {
    fun getProfilesForUser(email: String?): List<CharacterProfile> {
        // De momento la BD no tiene implementada la consulta de perfiles.
        // Lo dejamos preparado para MVVM.
        return emptyList()
    }
}