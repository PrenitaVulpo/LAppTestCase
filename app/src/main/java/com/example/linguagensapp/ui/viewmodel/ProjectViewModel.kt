package com.example.linguagensapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.linguagensapp.HTTP.HTTPProjects
import com.example.linguagensapp.Models.ProjectModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class ProjectViewModel: ViewModel() {
    private val _state = MutableLiveData<State>()
    val state: LiveData<State>
        get() = _state

    fun loadProjs(s: String?){
        if(state.value != null)return
        viewModelScope.launch{
            _state.value = State.StateLoading
            val result = withContext(Dispatchers.IO) {
                HTTPProjects.getProjs(s)
            }
            if (result != null) {
                _state.value = State.StateLoaded(result)
            } else {
                _state.value = State.StateError(Exception("No results"), false)
            }

        }
    }


    sealed class State {
        object StateLoading: State()
        data class StateLoaded(val list: List<ProjectModel>): State()
        data class StateError(val error: Throwable, var hasConsumed: Boolean): State()
    }
}