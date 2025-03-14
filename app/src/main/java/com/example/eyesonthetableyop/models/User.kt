package com.example.eyesonthetableyop.models

import androidx.compose.runtime.Immutable

@Immutable
data class User(
    val id:Long,
    val userName:String,
    val imgURL:String
)
