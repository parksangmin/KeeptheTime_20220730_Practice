package com.sangmin.keepthetime_20220730_practice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.sangmin.keepthetime_20220730_practice.databinding.ActivityLoginBinding
import com.sangmin.keepthetime_20220730_practice.datas.BasicResponse
import com.sangmin.keepthetime_20220730_practice.utils.AppUtil
import com.sangmin.keepthetime_20220730_practice.utils.ContextUtil
import com.sangmin.keepthetime_20220730_practice.utils.GlobalData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : BaseActivity() {

    lateinit var mBinding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        mBinding.signupBtn.setOnClickListener {
            val myIntent = Intent(mContext, SignUpActivity::class.java)
            startActivity(myIntent)
        }

        mBinding.loginBtn.setOnClickListener {

            val inputEmail = mBinding.emailEdt.text.toString()
            val inputPw = mBinding.passwordEdt.text.toString()

            apiList.getRequestLogin(
                inputEmail,inputPw

            ).enqueue(object : Callback<BasicResponse>{
                override fun onResponse(
                    call: Call<BasicResponse>,
                    response: Response<BasicResponse>
                ) {
                    if (response.isSuccessful){
                        val br = response.body()!!


                        GlobalData.loginUser = br.data.user
                        ContextUtil.setLoginToken(mContext, br.data.token)


                        Toast.makeText(mContext, "${br.data.user.nick_name}님 환영합니다", Toast.LENGTH_SHORT).show()
                        val myIntent = Intent(mContext, MainActivity::class.java)
                        startActivity(myIntent)
                        finish()


                    }else
                    {
                        val message = AppUtil.getMessageFromErroBody(response)
                        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show()
                    }

                }


                override fun onFailure(call: Call<BasicResponse>, t: Throwable) {

                }
            })
        }

    }

    override fun setValues() {

    }
}