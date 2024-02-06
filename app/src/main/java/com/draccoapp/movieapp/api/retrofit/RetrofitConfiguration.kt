package com.draccoapp.movieapp.api.retrofit

import com.draccoapp.movieapp.utils.Constants
import com.draccoapp.movieapp.utils.Env
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitConfiguration {

    companion object {

        private lateinit var retrofit: Retrofit
        private const val CONNECTION_TIMEOUT = 30 * 1000

        private fun getRetrofitInstance(): Retrofit {


            val client =
                OkHttpClient.Builder().addInterceptor { chain ->
                    val newRequest = chain.request().newBuilder()
                        .header("accept", "application/json")
                        .header(
                            "Authorization",
                            "Bearer ${
                                Env.token
                            }"
                        )
                        .build()
                    chain.proceed(newRequest)
                }.connectTimeout(
                    CONNECTION_TIMEOUT.toLong(),
                    TimeUnit.MINUTES
                ).readTimeout(1, TimeUnit.MINUTES).build()

            if (!::retrofit.isInitialized) {
                retrofit = Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .client(client)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build()
            }

            return retrofit
        }


        fun <S> createService(serviceClass: Class<S>): S {
            return getRetrofitInstance().create(serviceClass)
        }
    }

}