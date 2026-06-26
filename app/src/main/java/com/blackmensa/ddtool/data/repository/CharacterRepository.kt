package com.blackmensa.ddtool.data.repository

import com.blackmensa.ddtool.data.local.dao.CharacterDao
import com.blackmensa.ddtool.data.local.mapper.toDomain
import com.blackmensa.ddtool.data.local.mapper.toEntity
import com.blackmensa.ddtool.domain.model.CharacterProfile

class CharacterRepository(
    private val characterDao: CharacterDao
) {
    fun addCharacterProfile(
        profile: CharacterProfile,
        ownerEmail: String?
    ): Boolean {
        if (ownerEmail.isNullOrBlank()) return false

        val result = characterDao.insertCharacter(
            profile.toEntity(ownerEmail)
        )

        return result != -1L
    }

    fun getCharacterById(id: Int): CharacterProfile? {
        return characterDao
            .getCharacterById(id)
            ?.toDomain()
    }

    fun getProfilesForUser(email: String?): List<CharacterProfile> {
        if (email.isNullOrBlank()) return emptyList()

        return characterDao
            .getCharactersForUser(email)
            .map { it.toDomain() }
    }
}