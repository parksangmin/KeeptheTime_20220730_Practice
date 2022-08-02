package com.sangmin.keepthetime_20220730_practice.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.sangmin.keepthetime_20220730_practice.api.APIList
import com.sangmin.keepthetime_20220730_practice.api.ServerApi
import retrofit2.Retrofit
import retrofit2.create

abstract class BaseFragment : Fragment() {

    lateinit var mContext : Context

    lateinit var retrofit: Retrofit
    lateinit var apiList: APIList

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mContext = requireContext()
        retrofit = ServerApi.getRetrofit()
        apiList = retrofit.create(APIList::class.java)



    }

    abstract fun setupEvents()
    abstract fun setValues()
}