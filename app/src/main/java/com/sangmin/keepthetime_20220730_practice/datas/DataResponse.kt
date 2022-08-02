package com.sangmin.keepthetime_20220730_practice.datas

data class DataResponse (

    val code : Int,
    val user : UserData,
    val token : String,
    val friends : ArrayList<FriendData>

        ) {
}