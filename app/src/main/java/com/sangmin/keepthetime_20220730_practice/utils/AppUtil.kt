package com.sangmin.keepthetime_20220730_practice.utils

import com.sangmin.keepthetime_20220730_practice.datas.BasicResponse
import org.json.JSONObject
import retrofit2.Response


class AppUtil {

    companion object{
        fun getMessageFromErroBody(
            response: Response<BasicResponse>
        ) : String{
            val errorBodyStr = response.errorBody()!!.string()
            val jsonObj = JSONObject(errorBodyStr)
            val message = jsonObj.getString("message")

            return message


        }
    }


}