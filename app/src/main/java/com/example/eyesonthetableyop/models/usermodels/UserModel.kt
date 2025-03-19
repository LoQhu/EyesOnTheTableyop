package com.example.eyesonthetableyop.models.usermodels

import androidx.compose.runtime.Immutable

@Immutable
data class UserModel(
    val id:Long,
    val userName:String,
    val imgURL:String
)
