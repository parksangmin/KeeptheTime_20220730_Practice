package com.sangmin.keepthetime_20220730_practice.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServerApi {

    companion object {

//        서버주소 멤버변수화
        private val baseUrl = "https://keepthetime.xyz"

//        retrofit 초기화 진행
        private var retrofit : Retrofit? = null

        fun getRetrofit() : Retrofit {

            if (retrofit == null) {

                retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            }

            return retrofit!!
        }

    }

}