package com.sangmin.keepthetime_20220730_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.sangmin.keepthetime_20220730_practice.adapters.MainViewPagerAdapter
import com.sangmin.keepthetime_20220730_practice.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    lateinit var  mBinding : ActivityMainBinding

    lateinit var mPagerAdapter : MainViewPagerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        setValues()
        setupEvents()
    }

    override fun setupEvents() {

    }

    override fun setValues() {
        mPagerAdapter = MainViewPagerAdapter(this)
        mBinding.mainViewPager.adapter = mPagerAdapter

    }
}