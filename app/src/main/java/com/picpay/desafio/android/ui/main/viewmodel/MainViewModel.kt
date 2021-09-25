package com.picpay.desafio.android.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.picpay.desafio.android.data.model.User
import com.picpay.desafio.android.data.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {

    private val mainViewState = MainViewState()
    private val _state = MutableLiveData(mainViewState)
    val state: LiveData<MainViewState>
        get() = _state

    val users = repository.getUsers().asLiveData()
}

