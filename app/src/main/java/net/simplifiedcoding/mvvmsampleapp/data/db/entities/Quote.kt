package net.simplifiedcoding.mvvmsampleapp.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Quote(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val quote: String,
    val author: String,
    val thumbnail: String,
    val created_at: String?,
    val updated_at: String?
)