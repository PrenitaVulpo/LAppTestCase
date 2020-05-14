package com.example.linguagensapp.Models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class RepoModel (
    val name: String,
    val description: String,
    val url: String
): Parcelable