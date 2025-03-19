package com.example.eyesonthetableyop.models.postmodels

import com.example.eyesonthetableyop.models.usermodels.UserModel

data class NewPostModel(
    val title: String,
    val imgURL: String,
    val description: String,
    val postOwner: UserModel,
)
