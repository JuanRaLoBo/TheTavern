package com.blackmensa.ddtool.core

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.blackmensa.ddtool.domain.model.CharacterProfile

class Session(context: Context) {

    private val preferencesSession: SharedPreferences =
        context.getSharedPreferences("The Tavern", Context.MODE_PRIVATE)

    var currentUser: String?
    get() = preferencesSession.getString("currentUser", null)
    set(value) {
        preferencesSession.edit {
            putString("currentUser", value)
        }
    }

    var selectedCharacter: CharacterProfile? = null

    fun setLoggedState(logged: Boolean) {
        preferencesSession.edit {
            putBoolean("loggedIn", logged)
        }
    }

    fun loggedIn(): Boolean {
        return preferencesSession.getBoolean("loggedIn", false)
    }

    fun setCurrentCharacter(profile: CharacterProfile) {
        selectedCharacter = profile
    }

    fun getCurrentCharacter(): CharacterProfile? {
        return selectedCharacter
    }
}