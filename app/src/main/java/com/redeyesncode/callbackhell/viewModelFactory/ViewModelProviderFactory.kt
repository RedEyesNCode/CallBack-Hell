package com.redeyesncode.callbackhell.viewModelFactory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.redeyesncode.callbackhell.AppRepository.AppRepository
import com.redeyesncode.callbackhell.ViewModel.LoginViewModelCoroutines

class ViewModelProviderFactory(
    val app: Application,
    val appRepository: AppRepository
) : ViewModelProvider.Factory {

    // ADD ALL YOUR VIEW MODELS IN A SINGLE FACTORY.

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModelCoroutines::class.java)) {
            return LoginViewModelCoroutines(app, appRepository) as T
        } else{
            throw IllegalArgumentException("Unknown class name")

        }
    }

}