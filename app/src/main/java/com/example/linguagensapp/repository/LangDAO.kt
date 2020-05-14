package com.example.linguagensapp.repository

import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface LangDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(lang: Lang): Long

    @Delete
    suspend fun delete(lang: Lang)

    @Query("SELECT * FROM Lang")
    fun allFavorites(): Flow<List<Lang>>

    @Query("SELECT COUNT(id) FROM Lang WHERE id = :id")
    suspend fun isFavorite(id: String): Int
}