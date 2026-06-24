package com.blackmensa.ddtool.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.blackmensa.ddtool.data.local.dao.CharacterDao
import com.blackmensa.ddtool.data.local.dao.UserDAO
import com.blackmensa.ddtool.data.local.entity.CharacterEntity
import com.blackmensa.ddtool.data.local.entity.UserEntity

@Database(
    entities = [
        UserEntity::class,
        CharacterEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDAO
    abstract fun characterDao(): CharacterDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "the_tavern_database"
                )
                    //.fallbackToDestructiveMigration() // TEMPORAL, lo quitaremos con corrutinas
                    .allowMainThreadQueries() // TEMPORAL, lo quitaremos con corrutinas
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }
}