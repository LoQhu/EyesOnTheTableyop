package com.example.eyesonthetableyop.models.postmodels

import androidx.compose.runtime.Immutable
import com.example.eyesonthetableyop.models.commentmodels.CommentModel
import com.example.eyesonthetableyop.models.usermodels.UserModel


@Immutable
data class PostModel(
    val postID: String,
    val title: String,
    val imgURL: String,
    val description: String,
    val likes: Long,
    val postOwner: String,
//    val comments: List<CommentModel>?,
) {
//    fun getCommentCount(): Int {
//        return comments?.count() ?:0
//    }
    fun getLikesCount(): Long {
        return likes
    }
}
