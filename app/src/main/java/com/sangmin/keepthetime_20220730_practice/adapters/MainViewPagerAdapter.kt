package com.sangmin.keepthetime_20220730_practice.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sangmin.keepthetime_20220730_practice.fragments.AppointmentsFragment
import com.sangmin.keepthetime_20220730_practice.fragments.InvitedFragment
import com.sangmin.keepthetime_20220730_practice.fragments.SettingFragment

class MainViewPagerAdapter(fa : FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int {
            return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AppointmentsFragment()
            1 -> InvitedFragment()
            else -> SettingFragment()
        }

    }
}