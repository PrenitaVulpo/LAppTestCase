package com.example.linguagensapp.Models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LanguageModel (
    val id: String,
    val name: String,
    val creators: List<String>?,
    val release_date: String?,
    val typing_discipline: List<String>?,
    val image: String?
): Parcelable