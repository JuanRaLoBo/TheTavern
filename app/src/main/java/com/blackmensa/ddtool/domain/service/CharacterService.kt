package com.blackmensa.ddtool.domain.service

class CharacterService {
    fun proficiency(level: Int): Int {
        return when (level) {
            in 1..4 -> 2
            in 5..8 -> 3
            in 9..12 -> 4
            in 13..16 -> 5
            in 17..20 -> 6
            else -> throw IllegalArgumentException("Level must be between 1 and 20")
        }
    }

    fun abilityModifier(score: Int): Int {
        return kotlin.math.floor((score - 10) / 2.0).toInt()
    }

    fun formatModifier(score: Int): String {
        val modifier = abilityModifier(score)
        return if (modifier >= 0) "+$modifier" else "$modifier"
    }
}