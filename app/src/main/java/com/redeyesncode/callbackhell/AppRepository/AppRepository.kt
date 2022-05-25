package com.redeyesncode.callbackhell.AppRepository

import com.redeyesncode.callbackhell.RetrofitService.RetrofitService
import com.redeyesncode.callbackhell.model.inputs.LoginInputBody

class AppRepository {
    // MAKE SURE THE API'S THAT YOU ARE CALLING HERE SHOULD RETURN RESPONSE<MODEL_CLASS> instead of call FROM THE API_INTERFACE
    suspend fun loginUserCoroutine(loginInputBody: LoginInputBody) = RetrofitService().apiInterface.loginapiCoroutines(loginInputBody)

}