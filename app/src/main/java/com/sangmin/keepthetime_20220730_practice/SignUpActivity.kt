package com.sangmin.keepthetime_20220730_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.sangmin.keepthetime_20220730_practice.databinding.ActivityLoginBinding
import com.sangmin.keepthetime_20220730_practice.databinding.ActivitySignUpBinding

class SignUpActivity : BaseActivity() {

    lateinit var mBinding: ActivitySignUpBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       mBinding = DataBindingUtil.setContentView(this,R.layout.activity_sign_up)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        mBinding.signUpBtn.setOnClickListener {
//            1. 이메일 중복 체크

            if(){
//                이메일 중복 체크 x
                Toast.makeText(mContext, "이메일 중복 체크를 해주세요", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


//            2. 비밀번호 중복 체크(EditText 2가지 비교)

//            3. 닉네임 중복체크
            if (){

                //               닉네임 중복 체크 x
                Toast.makeText(mContext, "닉네임 중복 체크를 해주세요", Toast.LENGTH_SHORT).show()
                return@setOnClickListener


            }


//            4. 실제 회원가입



               }

//         이메일 중복 체크 API / 닉네임 중복 체크 API
        mBinding.emailCheckBtn.setOnClickListener {  }

        mBinding.nickCheckBtn.setOnClickListener {  }
    }

    override fun setValues() {

    }

    fun dupValue() {
//        들어오는 생성자에 따른 별도의 중복체크크
   }
}