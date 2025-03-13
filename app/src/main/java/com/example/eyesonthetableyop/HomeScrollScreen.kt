package com.example.eyesonthetableyop

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.eyesonthetableyop.Repos.PostRepo
import com.example.eyesonthetableyop.fragments.Posts
import com.google.accompanist.systemuicontroller.SystemUiController

@Composable
fun HomeScrollScreen(modifier: Modifier=Modifier){
    val postsRepo = PostRepo()
    val posts = postsRepo.getAllPosts()
    Surface(modifier = Modifier
        .fillMaxSize()
        .padding(0.dp,20.dp),
        color = Color.Gray){

        Column {
            AppBar()
            Posts(posts)
        }


    }

}
@Composable
fun AppBar(modifier: Modifier = Modifier){
    val context = LocalContext.current
    Row (modifier = Modifier.fillMaxWidth()
        .height(35.dp)
        .padding(5.dp)){
        Image(painter = painterResource(id=R.drawable.eyeofsauron),
            contentDescription = null,
            alignment = Alignment.TopStart,
            modifier = Modifier.size(32.dp))
        Spacer(Modifier.width(12.dp))
        Text(
            text = "Eyes On The Tabletop",
            fontStyle = FontStyle.Italic,
            fontSize = 25.sp
        )

        Row(modifier = Modifier.fillMaxWidth()
            .wrapContentSize(align = Alignment.TopEnd)) {
            Image(painter = rememberAsyncImagePainter(
                ImageRequest.Builder(context)
                    .crossfade(true)
                    .data("https://img.icons8.com/?size=100&id=37784&format=png&color=000000")
                    .build(),
                filterQuality = FilterQuality.High
            ),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = modifier
                    .wrapContentWidth()
                    .size(32.dp)
                    .clip(shape = CircleShape)
            )
            Spacer(Modifier.width(12.dp))
            Image(painter = rememberAsyncImagePainter(
                ImageRequest.Builder(context)
                    .crossfade(true)
                    .data("https://img.icons8.com/?size=100&id=7877&format=png&color=000000")
                    .build(),
                filterQuality = FilterQuality.High
            ),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = modifier
                    .wrapContentWidth()
                    .size(32.dp)
                    .clip(shape = CircleShape)
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun MainScrollScreenPreview(){
    HomeScrollScreen()
}