package com.blackmensa.ddtool.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")
data class CharacterEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val ownerEmail: String,
    val name: String,
    val charClass: String,
    val level: Int,
    val hitPoints: Int,
    val currentGold: Int,
    val strength: Int,
    val dexterity: Int,
    val constitution: Int,
    val intelligence: Int,
    val wisdom: Int,
    val charisma: Int,
    val strengthSave: Boolean,
    val dexteritySave: Boolean,
    val constitutionSave: Boolean,
    val intelligenceSave: Boolean,
    val wisdomSave: Boolean,
    val charismaSave: Boolean,
    val acrobatics: Boolean,
    val animalHandling: Boolean,
    val arcana: Boolean,
    val athletics: Boolean,
    val deception: Boolean,
    val history: Boolean,
    val insight: Boolean,
    val intimidation: Boolean,
    val investigation: Boolean,
    val medicine: Boolean,
    val nature: Boolean,
    val perception: Boolean,
    val performance: Boolean,
    val persuasion: Boolean,
    val religion: Boolean,
    val sleightOfHand: Boolean,
    val stealth: Boolean,
    val survival: Boolean
)