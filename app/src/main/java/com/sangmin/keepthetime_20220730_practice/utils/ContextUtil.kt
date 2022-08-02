package com.sangmin.keepthetime_20220730_practice.utils

import android.content.Context

class ContextUtil {

    companion object{


//        메모장 이름
//        private 외부에서 접근 할 수 없어
        private val prefName = "KeepTheTime"


//        알아볼수 있는 메모 제목
        private val LOGIN_TOKEN = "LOGIN_TOKEN"
        private val AUTO_LOGIN = "AUTO_LOGIN"

        fun setLoginToken (context : Context, token : String) {
            val pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
            pref.edit().putString(LOGIN_TOKEN, token).apply()
        }

        fun getLoginToken (context: Context) {
            val pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
            pref.getString(LOGIN_TOKEN, "")!!
        }

        fun setAutoLogin (context: Context, autoLogin : Boolean){
            val pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
            pref.edit().putBoolean(AUTO_LOGIN, autoLogin).apply()
        }

        fun getAutoLogin (context: Context) : Boolean {
            val pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
            return pref.getBoolean(AUTO_LOGIN, false)

        }


    }
}