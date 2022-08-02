package com.sangmin.keepthetime_20220730_practice.api


import com.sangmin.keepthetime_20220730_practice.datas.BasicResponse
import retrofit2.Call
import retrofit2.http.*


interface APIList {

//    user
//    이메일 / 닉네임 중복 체크
    @GET("/user/check")
    fun getRequestUserCheck(
        @Query("type") type: String,
        @Query("value") value: String
    ) : Call<BasicResponse>

//    회원가입
    @FormUrlEncoded
    @PUT("/user")
    fun getRequestSignUp (
        @Field ("email") email : String,
        @Field ("password") password : String,
        @Field ("nick_name") nick : String
    ) : Call<BasicResponse>

//    로그인인
   @FormUrlEncoded
    @POST ("/user")
    fun getRequestLogin(
        @Field("email") email: String,
        @Field("password") password: String
    ) : Call<BasicResponse>


//    내정보 확인
    @GET("/user")
    fun getRequestMyInfo(
        @Header("X-Http-Token") token: String
    ) : Call<BasicResponse>


//    user//friend
//    내 친구 목록 불러오기

    @GET("/user/friend")
    fun getRequestFriendList(
        @Header("X-Http-Token") token: Unit,
        @Query("type") type: String
    ) : Call<BasicResponse>



}