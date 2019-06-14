package net.simplifiedcoding.mvvmsampleapp.data.repositories

import net.simplifiedcoding.mvvmsampleapp.data.network.MyApi
import net.simplifiedcoding.mvvmsampleapp.data.network.responses.AuthResponse
import retrofit2.Response

class UserRepository {

    suspend fun userLogin(email: String, password: String) : Response<AuthResponse> {
        return MyApi().userLogin(email, password)
    }

}