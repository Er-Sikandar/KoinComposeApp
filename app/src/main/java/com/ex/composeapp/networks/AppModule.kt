package com.ex.composeapp.networks

import com.ex.composeapp.BuildConfig
import com.ex.composeapp.screens.login.data.LoginRepoImpl
import com.ex.composeapp.screens.login.domain.LoginRepo
import com.ex.composeapp.screens.login.presentation.LoginViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single {
        HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        }
    }
    single {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }
    single {
        Retrofit.Builder()
            .baseUrl(BuildConfig.MAN_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    single<ApiService> {
        get<Retrofit>().create(ApiService::class.java)
    }

   // single { LoginRepo(get()) }
    single<LoginRepo> { LoginRepoImpl(get()) }

    viewModel { LoginViewModel(get()) }
}
