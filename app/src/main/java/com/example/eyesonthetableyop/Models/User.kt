package com.example.eyesonthetableyop.Models

import androidx.compose.runtime.Immutable

@Immutable
data class User(
    val id:Long,
    val userName:String,
    val imgURL:String
)
