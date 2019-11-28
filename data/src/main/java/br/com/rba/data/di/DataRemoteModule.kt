package br.com.rba.data.di

import br.com.rba.data.R
import br.com.rba.data.remote.api.ServerApi
import br.com.rba.data.remote.source.RemoteDataSource
import br.com.rba.data.remote.source.RemoteDataSourceImpl
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 *
 * Gerir as dependências do backend
 *
 * **/
val remoteDataSourceModule = module {

    factory { providesOkHttpClient() }

    single {
        createWebService<ServerApi>(
            okHttpClient = get(),
            url = androidContext().getString(R.string.base_url)
        )
    }

    factory<RemoteDataSource> { RemoteDataSourceImpl(serverApi = get()) }
}

fun providesOkHttpClient(): OkHttpClient {
    return OkHttpClient
        .Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()
}

inline fun <reified T> createWebService(okHttpClient: OkHttpClient, url: String): T {
    return Retrofit
        .Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl(url)
        .client(okHttpClient)
        .build()
        .create(T::class.java)
}