package com.redeyesncode.callbackhell.RetrofitService

import com.redeyesncode.callbackhell.model.LoginDataClass
import com.redeyesncode.callbackhell.model.inputs.LoginInputBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiInterface {


    @Headers("Content-Type: application/json")
    @POST("authJWT")
    fun loginapiCoroutines(@Body loginInputBody: LoginInputBody): Call<LoginDataClass>

}