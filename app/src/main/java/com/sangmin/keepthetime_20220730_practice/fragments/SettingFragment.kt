package com.sangmin.keepthetime_20220730_practice.fragments


import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.sangmin.keepthetime_20220730_practice.FriendListActivity
import com.sangmin.keepthetime_20220730_practice.LoginActivity
import com.sangmin.keepthetime_20220730_practice.R
import com.sangmin.keepthetime_20220730_practice.databinding.FragmentSettingBinding
import com.sangmin.keepthetime_20220730_practice.utils.ContextUtil
import com.sangmin.keepthetime_20220730_practice.utils.GlobalData

class SettingFragment : BaseFragment() {

    lateinit var mBinding: FragmentSettingBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_setting, container, false)
        return mBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setValues()
        setupEvents()
    }


    override fun setupEvents() {
//        로그아웃

//        val ol = object : DialogInterface.OnClickListener{
//            override fun onClick(p0: DialogInterface?, p1: Int) {
//
//            }
//        }
        mBinding.logoutLayout.setOnClickListener {
            val alert = AlertDialog.Builder(mContext)
                .setTitle("로그아웃")
                .setMessage("로그아웃 하시겠습니까?")
                .setPositiveButton("확인", DialogInterface.OnClickListener { dialogInterface, i ->
//                    로그아웃 로직 진행

                    ContextUtil.setLoginToken(mContext, "")
                    GlobalData.loginUser = null

                    val myIntent = Intent(mContext, LoginActivity::class.java)
                    startActivity(myIntent)
                    requireActivity().finish()
                })
                .setNegativeButton("취소", null)
                .show()
        }

//        내 친구 목록 관리
        mBinding.FriendListLayoutList.setOnClickListener {
            val myIntent = Intent(mContext, FriendListActivity::class.java)
            startActivity(myIntent)
        }

    }

    override fun setValues() {
        val loginUser = GlobalData.loginUser!!
        Glide.with(mContext).load(loginUser.profile_img).into(mBinding.profileImg)
        mBinding.nickTxt.text = loginUser.nick_name
        mBinding.myReadyTimeTxt.text = "${loginUser.ready_minute}분"

    }


}