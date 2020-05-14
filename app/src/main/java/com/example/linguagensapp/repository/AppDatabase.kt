package com.example.linguagensapp.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(
    entities = [Lang::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase(){
    abstract fun getLangDao(): LangDAO

    companion object{
        private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase{
            if (instance == null){
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "appDb"
                ).build()
            }
            return instance!!
        }
    }
}