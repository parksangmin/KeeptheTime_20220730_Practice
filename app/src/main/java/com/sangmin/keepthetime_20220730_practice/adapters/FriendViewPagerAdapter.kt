package com.sangmin.keepthetime_20220730_practice.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.sangmin.keepthetime_20220730_practice.fragments.InviteFriendsFragment
import com.sangmin.keepthetime_20220730_practice.fragments.InvitedFragment
import com.sangmin.keepthetime_20220730_practice.fragments.MyFriendsFragment


class FriendViewPagerAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 2

    }

    override fun getItem(position: Int): Fragment {

        return  when (position){
            0-> MyFriendsFragment()
            else -> InviteFriendsFragment()
        }


    }

    override fun getPageTitle(position: Int): CharSequence? {
        return super.getPageTitle(position)

        return  when (position){
            0-> "내 친구 목록"
            else -> "친구 추가 요청"
        }
    }
}