package com.blackmensa.ddtool.core

import android.content.Context
import com.blackmensa.ddtool.data.local.database.AppDatabase
import com.blackmensa.ddtool.data.repository.CharacterRepository
import com.blackmensa.ddtool.data.repository.UserRepository

object ServiceLocator {

    // Provide the database instance
    fun provideDatabase(context: Context): AppDatabase {
        return AppDatabase.getDatabase(context)
    }

    // Provide the session instance
    fun provideSession(context: Context): Session {
        return Session(context)
    }

    // Provide the user repository instance
    fun provideUserRepository(context: Context): UserRepository {
        return UserRepository(
            provideDatabase(context).userDao()
        )
    }

    // Provide the character repository instance
    fun provideCharacterRepository(context: Context): CharacterRepository {
        return CharacterRepository(
            provideDatabase(context).characterDao()
        )
    }
}