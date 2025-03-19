package com.example.eyesonthetableyop.models.commentmodels

import androidx.compose.runtime.Immutable
import com.example.eyesonthetableyop.models.usermodels.UserModel

@Immutable
data class CommentModel(
    val owner: UserModel,
    val content: String,
)
