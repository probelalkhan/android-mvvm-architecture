package net.simplifiedcoding.mvvmsampleapp.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import net.simplifiedcoding.mvvmsampleapp.data.repositories.UserRepository


class AuthViewModel : ViewModel() {

    var email: String? = null
    var password: String? = null

    var authListener: AuthListener? = null


    fun onLoginButtonClick(view: View){
        authListener?.onStarted()
        if(email.isNullOrEmpty() || password.isNullOrEmpty()){
            authListener?.onFailure("Invalid email or password")
            return
        }

        val loginResponse = UserRepository().userLogin(email!!, password!!)
        authListener?.onSuccess(loginResponse)
    }

}