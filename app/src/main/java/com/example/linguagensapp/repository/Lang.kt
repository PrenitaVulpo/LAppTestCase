package com.example.linguagensapp.repository

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters


@Entity
@TypeConverters(StringListConverter::class)
data class Lang (
    @PrimaryKey
    val id: String,
    val name: String,
    val creators: List<String>?,
    val release_date: String?,
    val typing_discipline: List<String>?,
    val image: String?
)