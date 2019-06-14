package net.simplifiedcoding.mvvmsampleapp.ui.auth

import androidx.lifecycle.LiveData
import net.simplifiedcoding.mvvmsampleapp.data.db.entities.User

interface AuthListener {
    fun onStarted()
    fun onSuccess(user: User)
    fun onFailure(message: String)
}