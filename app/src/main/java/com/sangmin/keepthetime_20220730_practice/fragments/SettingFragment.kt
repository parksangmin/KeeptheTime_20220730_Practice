package com.sangmin.keepthetime_20220730_practice.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.sangmin.keepthetime_20220730_practice.R
import com.sangmin.keepthetime_20220730_practice.databinding.FragmentSettingBinding
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

    }

    override fun setValues() {
        val loginUser = GlobalData.loginUser!!
        Glide.with(mContext).load(loginUser.profile_img).into(mBinding.profileImg)
        mBinding.nickTxt.text = loginUser.nick_name
        mBinding.myReadyTimeTxt.text = "${loginUser.ready_minute}분"

    }


}