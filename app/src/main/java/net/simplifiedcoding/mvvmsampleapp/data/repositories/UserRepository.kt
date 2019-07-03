package net.simplifiedcoding.mvvmsampleapp.data.repositories

import net.simplifiedcoding.mvvmsampleapp.data.db.AppDatabase
import net.simplifiedcoding.mvvmsampleapp.data.db.entities.User
import net.simplifiedcoding.mvvmsampleapp.data.network.MyApi
import net.simplifiedcoding.mvvmsampleapp.data.network.SafeApiRequest
import net.simplifiedcoding.mvvmsampleapp.data.network.responses.AuthResponse
import retrofit2.Response

class UserRepository(
    private val api: MyApi,
    private val db: AppDatabase
) : SafeApiRequest() {

    suspend fun userLogin(email: String, password: String): AuthResponse {
        return apiRequest { api.userLogin(email, password) }
    }

    suspend fun userSignup(
        name: String,
        email: String,
        password: String
    ) : AuthResponse {
        return apiRequest{ api.userSignup(name, email, password)}
    }

    suspend fun saveUser(user: User) = db.getUserDao().upsert(user)

    fun getUser() = db.getUserDao().getuser()

}