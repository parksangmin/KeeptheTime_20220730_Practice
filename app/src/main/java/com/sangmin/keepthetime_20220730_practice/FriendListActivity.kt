package com.sangmin.keepthetime_20220730_practice


import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.sangmin.keepthetime_20220730_practice.adapters.FriendViewPagerAdapter
import com.sangmin.keepthetime_20220730_practice.databinding.ActivityFriendListBinding

class FriendListActivity : BaseActivity() {

    lateinit var mBinding : ActivityFriendListBinding

    lateinit var mPagerAdapter: FriendViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_friend_list)
        setValues()
        setupEvents()
    }

    override fun setupEvents() {

    }

    override fun setValues() {
        mPagerAdapter = FriendViewPagerAdapter(supportFragmentManager)
        mBinding.viewPager.adapter = mPagerAdapter

        mBinding.tabLayout.setupWithViewPager(mBinding.viewPager)

    }
}