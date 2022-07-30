package com.sangmin.keepthetime_20220730_practice

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sangmin.keepthetime_20220730_practice.api.APIList
import com.sangmin.keepthetime_20220730_practice.api.ServerApi
import retrofit2.Retrofit
import retrofit2.create

abstract class BaseActivity : AppCompatActivity() {

    lateinit var mContext: Context

    lateinit var retrofit : Retrofit
    lateinit var apiList: APIList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = this

//       기본
        retrofit = ServerApi.getRetrofit()
        apiList = retrofit.create(APIList::class.java)

    }

    abstract fun setupEvents()

    abstract fun setValues()
}