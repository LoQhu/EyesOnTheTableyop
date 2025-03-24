package com.example.eyesonthetableyop.fragments

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.eyesonthetableyop.models.usermodels.UserModel

@Composable
fun PostRowItem(userPost: UserModel){
    val context = LocalContext.current
    Card(
        modifier = Modifier.size(width = 80.dp, height = 100.dp)
            .padding(horizontal = 5.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Black),
        elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
        shape = RoundedCornerShape(6.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = ImageRequest.Builder(context)
                    .crossfade(true)
                    .data(userPost.imgURL)
                    .build(),
                    filterQuality = FilterQuality.High
                ),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .wrapContentWidth()
                    .size(64.dp)
                    .clip(shape = CircleShape)
            )
            Text(
                text = userPost.userName,
                color = Color.White,
                maxLines = 1
            )
        }
    }
}

@Composable
fun Posts_ForTesting(
    postList:List<UserModel>,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(top = 20.dp)
    ) {
        LazyRow(
            state = rememberLazyListState(),
            modifier = modifier.fillMaxWidth()
                .wrapContentWidth()
                .padding(top = 5.dp)
        ) {
            items(items = postList){item ->
                PostRowItem(userPost = item)
            }
        }
    }
}