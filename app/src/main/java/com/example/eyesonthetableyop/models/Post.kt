package com.example.eyesonthetableyop.models

import androidx.compose.runtime.Immutable


@Immutable
data class Post(
    val postID: Long,
    val title: String,
    val imgURL: String,
    val description: String,
    val likes: Long,
    val postOwner: User,
    val comments: List<Comment>?,
) {
    fun getCommentCount(): Int {
        return comments?.count() ?:0
    }
}
