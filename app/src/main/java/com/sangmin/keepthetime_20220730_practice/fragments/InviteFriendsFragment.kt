package com.sangmin.keepthetime_20220730_practice.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.sangmin.keepthetime_20220730_practice.R
import com.sangmin.keepthetime_20220730_practice.databinding.FragmentInviteFriendsBinding
import com.sangmin.keepthetime_20220730_practice.databinding.FragmentInvitedBinding
import com.sangmin.keepthetime_20220730_practice.databinding.FragmentMyFriendsBinding
import com.sangmin.keepthetime_20220730_practice.fragments.BaseFragment

class InviteFriendsFragment : BaseFragment() {

    lateinit var mBinding : FragmentInviteFriendsBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_invite_friends, container, false)
        return mBinding.root
    }
    override fun setupEvents() {

    }

    override fun setValues() {

    }
}