package com.example.linguagensapp.Models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class ProjectModel (
    val username: String,
    val name: String,
    val url: String,
    val avatar: String,
    val repo: RepoModel
): Parcelable