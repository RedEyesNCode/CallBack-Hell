package com.redeyesncode.callbackhell.model.inputs

import com.google.gson.annotations.SerializedName

data class LoginInputBody(@SerializedName("username" ) var username : String? = null,
                          @SerializedName("password" ) var password : String? = null
){

}
