package com.example.linguagensapp.repository

import android.content.Context
import com.example.linguagensapp.Models.LanguageModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LangRepository (context: Context) {
    private val database = AppDatabase.getDatabase(context)

    suspend fun save(language: LanguageModel){
        database.getLangDao().save(
            LangMapper.languageToLang(language)
        )
    }

    suspend fun delete(language: LanguageModel){
        database.getLangDao().delete(
            LangMapper.languageToLang(language)
        )
    }

    suspend fun isFavorite(id: String): Boolean{
        return database.getLangDao().isFavorite(id) > 0
    }

    fun allFavorites(): Flow<List<LanguageModel>> {
        return database.getLangDao().allFavorites().map {
            langList ->
            langList.map {
                lang -> LangMapper.langToLanguage((lang))
            }
        }
    }
}