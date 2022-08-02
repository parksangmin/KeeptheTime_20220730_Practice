package com.sangmin.keepthetime_20220730_practice

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import com.sangmin.keepthetime_20220730_practice.datas.BasicResponse
import com.sangmin.keepthetime_20220730_practice.utils.ContextUtil
import com.sangmin.keepthetime_20220730_practice.utils.GlobalData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SplashActivity : BaseActivity() {

    var isTokenOk = false
    var isAutoLogin = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setValues()
        setupEvents()
    }

    override fun setupEvents() {

//        토큰 유효성 검사 > isTokenOk > Boolean 값 수정\
        val token = ContextUtil.getLoginToken(mContext)
        apiList.getRequestMyInfo(token).enqueue(object : Callback<BasicResponse>{
            override fun onResponse(call: Call<BasicResponse>, response: Response<BasicResponse>) {
                if (response.isSuccessful){
                    val br = response.body()!!

                    GlobalData.loginUser = br.data.user

                    isTokenOk = true
                }
            }

            override fun onFailure(call: Call<BasicResponse>, t: Throwable) {

            }
        } )



    }

    override fun setValues() {

//        Handler 클래스 활용 > 자동 로그인 기능 구현
        val myHandler = Handler(Looper.getMainLooper())

        myHandler.postDelayed(
            {
//            token이 유효한지, 자동로그인 설정 > 분기처리후 MainActivity or LoginActivity로 이동


            var myIntent : Intent

            isAutoLogin = ContextUtil.getAutoLogin(mContext)


            if(isTokenOk && isAutoLogin) {
                Toast.makeText(mContext, "${GlobalData.loginUser!!.nick_name}님 환영합니다", Toast.LENGTH_SHORT).show()

                 myIntent = Intent(mContext, MainActivity::class.java)

            }else {
                 myIntent = Intent(mContext, LoginActivity::class.java)

            }

                startActivity(myIntent)
                finish()


            },1500
        )

    }
}