package org.gsm.software.highthon.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    val api : Api
    init{
        val retrofit = Retrofit.Builder()
            .baseUrl(org.gsm.software.highthon.BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(callOkhttp())
            .build()

        api = retrofit.create(Api::class.java)
    }

    private fun callOkhttp(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        builder.addInterceptor(interceptor)
        return builder.build()
    }
}