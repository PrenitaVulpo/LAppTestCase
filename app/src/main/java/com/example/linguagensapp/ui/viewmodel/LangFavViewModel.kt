package com.example.linguagensapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.linguagensapp.repository.LangRepository

class LangFavViewModel(private val banco: LangRepository): ViewModel() {
    val favLangs = banco.allFavorites().asLiveData()
}