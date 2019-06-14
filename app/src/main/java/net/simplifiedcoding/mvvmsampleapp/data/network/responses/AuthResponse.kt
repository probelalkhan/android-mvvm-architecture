package net.simplifiedcoding.mvvmsampleapp.data.network.responses

import net.simplifiedcoding.mvvmsampleapp.data.db.entities.User

data class AuthResponse(
    val isSuccessful : Boolean?,
    val message: String?,
    val user: User?
)