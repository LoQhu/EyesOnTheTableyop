package com.example.eyesonthetableyop.models

import androidx.compose.runtime.Immutable

@Immutable
data class Comment(
    val owner: User,
    val content: String,
)
