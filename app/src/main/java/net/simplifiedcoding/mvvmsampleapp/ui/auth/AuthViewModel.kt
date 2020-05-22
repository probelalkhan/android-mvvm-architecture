package net.simplifiedcoding.mvvmsampleapp.ui.auth

import androidx.lifecycle.ViewModel
import net.simplifiedcoding.mvvmsampleapp.data.db.entities.User
import net.simplifiedcoding.mvvmsampleapp.data.repositories.UserRepository


class AuthViewModel(
    private val repository: UserRepository
) : ViewModel() {

    fun getLoggedInUser() = repository.getUser()

    suspend fun userLogin(
        email: String,
        password: String
    ) = repository.userLogin(email, password)

    suspend fun saveLoggedInUser(user: User) = repository.saveUser(user)

}