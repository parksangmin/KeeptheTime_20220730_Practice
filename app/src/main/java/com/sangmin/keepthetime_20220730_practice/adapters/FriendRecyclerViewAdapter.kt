package com.sangmin.keepthetime_20220730_practice.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sangmin.keepthetime_20220730_practice.R
import com.sangmin.keepthetime_20220730_practice.databinding.FriendListItemBinding
import com.sangmin.keepthetime_20220730_practice.datas.FriendData

class FriendRecyclerViewAdapter(
   val mContext: Context,
   val mList : ArrayList<FriendData>


) : RecyclerView.Adapter<FriendRecyclerViewAdapter.MyViewHolder>() {


    inner class MyViewHolder(val binding : FriendListItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item : FriendData){


            binding.nickTxt.text = item.nick_name
            Glide.with(mContext).load(item.profile_img).into(binding.profileImg)

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(FriendListItemBinding.inflate(LayoutInflater.from(mContext), parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(mList[position])

    }

    override fun getItemCount(): Int {
        return mList.size


    }
}