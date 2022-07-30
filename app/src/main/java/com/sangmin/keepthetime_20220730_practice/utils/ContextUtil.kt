package com.sangmin.keepthetime_20220730_practice.utils

import android.content.Context

class ContextUtil {

    companion object{


//        메모장 이름
//        private 외부에서 접근 할 수 없어
        private val prefName = "KeepTheTime"


//        알아볼수 있는 메모 제목
        private val LOGIN_TOKEN = "LOGIN_TOKEN"

        fun setLoginToken (context : Context, token : String) {
            val pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
            pref.edit().putString(LOGIN_TOKEN, token).apply()
        }

        fun getLoginToken (context: Context) {
            val pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
            pref.getString(LOGIN_TOKEN, "")!!
        }


    }
}