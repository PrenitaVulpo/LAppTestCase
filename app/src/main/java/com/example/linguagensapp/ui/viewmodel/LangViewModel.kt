package com.example.linguagensapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.example.linguagensapp.HTTP.HTTPlang
import com.example.linguagensapp.Models.LanguageModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LangViewModel: ViewModel(){

    private val _state = MutableLiveData<Estado>()
    val state: LiveData<Estado>
    get() = _state

    sealed class Estado {
        object StateLoading: Estado()
        data class StateLoaded(val list: List<LanguageModel>): Estado()
        data class StateError(val error: Throwable, var hasConsumed: Boolean): Estado()
    }

    fun loadLangs(){
        if(state.value != null)return
        viewModelScope.launch{
            _state.value = Estado.StateLoading
            val result = withContext(Dispatchers.IO) {
                HTTPlang.getLangs()
            }
            Log.i("teste", result?.size.toString())
            if (result != null) {
                _state.value = Estado.StateLoaded(result)
            } else {
                _state.value = Estado.StateError(Exception("No results"), false)
            }

        }
    }

}