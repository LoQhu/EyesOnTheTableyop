package com.example.eyesonthetableyop.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eyesonthetableyop.services.PostService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeScrollScreenViewModel : ViewModel(){
    private val postService = PostService()

    private val _imgURLs = MutableStateFlow<List<String>>(emptyList())
    val imgURLs: StateFlow<List<String>> = _imgURLs

    init {
        fetchImgUrl()
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