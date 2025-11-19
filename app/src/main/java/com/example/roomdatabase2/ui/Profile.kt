package com.example.roomdatabase2.ui

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "user_profile")
data class Profile(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val department: String,
    val email: String,
    val dob: String,
    val district: String,
    val number: String,
): Serializable
