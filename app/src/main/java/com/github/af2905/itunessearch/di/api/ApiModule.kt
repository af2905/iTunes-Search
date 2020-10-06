package com.github.af2905.itunessearch.di.module

import com.github.af2905.itunessearch.BuildConfig
import com.github.af2905.itunessearch.repository.server.ApiService
import com.github.af2905.itunessearch.repository.server.ServerCommunicator
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
class ApiModule {
    @Reusable
    @Provides
    fun providesServerCommunicator(apiService: ApiService): ServerCommunicator {
        return ServerCommunicator(apiService)
    }
    @Reusable
    @Provides
    fun providesApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
    @Reusable
    @Provides
    fun providesRetrofit(
        client: OkHttpClient, converter: GsonConverterFactory, adapter: RxJava2CallAdapterFactory
    ): Retrofit {
        return Retrofit.Builder().client(client)
            .addConverterFactory(converter)
            .addCallAdapterFactory(adapter)
            .baseUrl(BASE_URL).build()
    }
    @Reusable
    @Provides
    fun providesCallAdapterFactory(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.create()
    }
    @Reusable
    @Provides
    fun providesConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }
    @Reusable
    @Provides
    fun providesOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .connectionPool(ConnectionPool(5, 30, TimeUnit.SECONDS))
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .build()
    }
    @Reusable
    @Provides
    fun providesHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = when (BuildConfig.DEBUG) {
            true -> HttpLoggingInterceptor.Level.BODY
            else -> HttpLoggingInterceptor.Level.NONE
        }
        return interceptor
    }

    companion object {
        private const val BASE_URL = "https://itunes.apple.com/"
    }
}