package com.example.linguagensapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.linguagensapp.Models.LanguageModel
import com.example.linguagensapp.repository.LangRepository
import kotlinx.coroutines.launch

class DetailViewModel ( private val repository: LangRepository): ViewModel(){
    private val _isFavorite = MutableLiveData<Boolean>()
    val isFavorite: LiveData<Boolean> = _isFavorite

    fun onCreate(item: LanguageModel){
        viewModelScope.launch {
            _isFavorite.value = repository.isFavorite(item.id)
            val str = "Entrada id: "+ item.id + " de nome: " + item.name
            Log.i(str, "teste" )
        }
    }

    fun saveToFavorite(item: LanguageModel){
        viewModelScope.launch {
            repository.save(item)
            _isFavorite.value = repository.isFavorite(item.id)
        }
    }

    fun removeToFavorites(item: LanguageModel){
        viewModelScope.launch {
            repository.delete(item)
            _isFavorite.value = repository.isFavorite(item.id)
        }
    }
}