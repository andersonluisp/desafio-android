package com.picpay.desafio.android.data.di

import androidx.room.Room
import com.picpay.desafio.android.BuildConfig
import com.picpay.desafio.android.data.model.UserDatabase
import com.picpay.desafio.android.data.network.PicPayService
import com.picpay.desafio.android.data.repository.Repository
import com.picpay.desafio.android.ui.main.viewmodel.MainViewModel
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val mainModule = module {
    single {
        Retrofit.Builder()
            .client(get())
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PicPayService::class.java)
    }

    single {
        OkHttpClient.Builder()
            .build()
    }

    single {
        Room.databaseBuilder(get(), UserDatabase::class.java, "user_database")
            .build()
    }

    factory {
        Repository(
            api = get(),
            db = get()
        )
    }
    viewModel {
        MainViewModel(repository = get())
    }
}