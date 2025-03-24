package com.example.eyesonthetableyop.models.postmodels

import com.example.eyesonthetableyop.models.usermodels.UserModel

data class NewPostModel(
    var title: String?,
    var imgURL: String?,
    var description: String?,
    var postOwner: String?,
    //val postOwner: UserModel,
)
