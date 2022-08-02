package com.sangmin.keepthetime_20220730_practice.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.sangmin.keepthetime_20220730_practice.R
import com.sangmin.keepthetime_20220730_practice.adapters.FriendRecyclerViewAdapter
import com.sangmin.keepthetime_20220730_practice.databinding.FragmentInviteFriendsBinding
import com.sangmin.keepthetime_20220730_practice.databinding.FragmentInvitedBinding
import com.sangmin.keepthetime_20220730_practice.databinding.FragmentMyFriendsBinding
import com.sangmin.keepthetime_20220730_practice.datas.BasicResponse
import com.sangmin.keepthetime_20220730_practice.datas.FriendData
import com.sangmin.keepthetime_20220730_practice.fragments.BaseFragment
import com.sangmin.keepthetime_20220730_practice.utils.ContextUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InviteFriendsFragment : BaseFragment() {

    lateinit var mBinding : FragmentInviteFriendsBinding

    lateinit var mFriendAdapter : FriendRecyclerViewAdapter
    var mFriendList = ArrayList<FriendData>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_invite_friends, container, false)
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
        getFriendListFromServer()

        mFriendAdapter = FriendRecyclerViewAdapter(mContext,mFriendList)
        mBinding.invitedRecyclerView.adapter = mFriendAdapter
        mBinding.invitedRecyclerView.layoutManager = LinearLayoutManager(mContext)


    }

    fun getFriendListFromServer() {
        val token = ContextUtil.getLoginToken(mContext)
        apiList.getRequestFriendList(token, "requested").enqueue(object : Callback<BasicResponse> {
            override fun onResponse(call: Call<BasicResponse>, response: Response<BasicResponse>) {
                if(response.isSuccessful) {
                    val br = response.body()!!

                    mFriendList.addAll(br.data.friends)
                    mFriendAdapter.notifyDataSetChanged()


                }

            }

            override fun onFailure(call: Call<BasicResponse>, t: Throwable) {

            }
        })



    }
}