package com.blackmensa.ddtool.core

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

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

    var loggedIn: Boolean
        get() = preferencesSession.getBoolean("loggedIn", false)
        set(value) {
            preferencesSession.edit {
                putBoolean("loggedIn", value)
            }
        }

    var selectedCharacterId: Int
        get() = preferencesSession.getInt("selectedCharacterId", -1)
        set(value) {
            preferencesSession.edit()
                .putInt("selectedCharacterId", value)
        }
}