package com.sangmin.keepthetime_20220730_practice.api

import android.content.Context
import com.sangmin.keepthetime_20220730_practice.utils.ContextUtil
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServerApi {

    companion object {

//        서버주소 멤버변수화
        private val baseUrl = "https://keepthetime.xyz"

//        retrofit 초기화 진행
        private var retrofit : Retrofit? = null

        fun getRetrofit(context : Context) : Retrofit {

            if (retrofit == null) {

//                Api  요청이 발생하면 => 요청을 가로채서(intercept) ==> 우리의 헤더를 추가해주자
                val intercepto = Interceptor {
                    with(it) {
                        val newRequest = request().newBuilder()
                            .addHeader("X-Http-Token",
                                ContextUtil.getLoginToken(context).toString()
                            )
                            .build()
                        proceed(newRequest)
                    }
                }

//                retrofit : OKHttp의 확장판 => retrofit 자체가 OKHttpClient 형태의 클라이언트를 활용(커스터마이징 가능)


                val myClient = OkHttpClient.Builder().addInterceptor(intercepto).build()

                retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(myClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            }

            return retrofit!!
        }

    }

}