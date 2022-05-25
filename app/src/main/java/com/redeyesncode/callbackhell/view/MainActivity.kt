package com.redeyesncode.callbackhell.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.redeyesncode.callbackhell.AppRepository.AppRepository
import com.redeyesncode.callbackhell.R
import com.redeyesncode.callbackhell.ViewModel.LoginViewModelCoroutines
import com.redeyesncode.callbackhell.model.inputs.LoginInputBody
import com.redeyesncode.callbackhell.viewModelFactory.ViewModelProviderFactory

class MainActivity : AppCompatActivity() {
    private lateinit var loginViewModelCoroutines: LoginViewModelCoroutines

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initCoroutine()
        attachObserversofCouroutines()
        var loginInputBody = LoginInputBody("1234567","123456")
        loginViewModelCoroutines.loginUser(loginInputBody)
    }

    fun initCoroutine() {
        val repository = AppRepository()
        var factory = ViewModelProviderFactory(application,repository)
        loginViewModelCoroutines = ViewModelProvider(this,factory).get(LoginViewModelCoroutines::class.java)
    }

    fun attachObserversofCouroutines(){
        loginViewModelCoroutines.loginResponse.observe(this, Observer { event ->

            if (event.peekContent().data?.code == 200 && event.peekContent().data?.status!!.contains("success")) {
                Toast.makeText(this@MainActivity,"Login Success !", Toast.LENGTH_SHORT).show()

            }else{

                Toast.makeText(this@MainActivity,"Login Failed", Toast.LENGTH_SHORT).show()
            }
        })


    }

}