package com.example.androidsimulation.model.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object{
        private const val URL_BASE = "http://my-json-server.typicode.com/"

        fun getRetrofitClient() : ProductAPI {
            val mRetrofit = Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return mRetrofit.create(ProductAPI::class.java)
        }
    }
}