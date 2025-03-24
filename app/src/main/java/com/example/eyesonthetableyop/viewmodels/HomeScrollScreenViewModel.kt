package com.example.eyesonthetableyop.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eyesonthetableyop.models.postmodels.PostModel
import com.example.eyesonthetableyop.services.PostService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeScrollScreenViewModel : ViewModel(){
    private val postService = PostService()

    private val _imgURLs = MutableStateFlow<List<String>>(emptyList())
    private val _posts = MutableStateFlow<List<PostModel>>(emptyList())

    val posts: StateFlow<List<PostModel>> = _posts
    val imgURLs: StateFlow<List<String>> = _imgURLs

    init {
        fetchPosts()
    }

    private fun fetchPosts() {
        viewModelScope.launch {
            postService.getAllPosts().collectLatest {
                posts ->
                _posts.value = posts
            }
        }
    }

    private fun fetchImgUrl(){
        viewModelScope.launch {
            postService.getAllImageURLsFromFirebase().collectLatest {
                urls ->
                _imgURLs.value = urls
            }
        }
    }

}