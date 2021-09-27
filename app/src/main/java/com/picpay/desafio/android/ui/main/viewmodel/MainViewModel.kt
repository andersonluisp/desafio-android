package com.picpay.desafio.android.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.picpay.desafio.android.data.repository.Repository

class MainViewModel(private val repository: Repository) : ViewModel() {

    val users = repository.getUsers().asLiveData()
}

