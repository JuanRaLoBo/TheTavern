package com.blackmensa.ddtool.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.blackmensa.ddtool.data.local.entity.CharacterEntity

@Dao
interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCharacter(character: CharacterEntity): Long

    @Query("SELECT * FROM characters WHERE id = :id LIMIT 1")
    fun getCharacterById(id: Int): CharacterEntity?

    @Query("SELECT * FROM characters WHERE ownerEmail = :email ORDER BY name")
    fun getCharactersForUser(email: String): List<CharacterEntity>
}