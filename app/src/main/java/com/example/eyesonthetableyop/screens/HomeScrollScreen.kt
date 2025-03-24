package com.example.eyesonthetableyop.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.eyesonthetableyop.MainActivity
import com.example.eyesonthetableyop.R
import com.example.eyesonthetableyop.repos.PostRepo_Test
import com.example.eyesonthetableyop.repos.UserRepo_Test
import com.example.eyesonthetableyop.fragments.Post
import com.example.eyesonthetableyop.fragments.Posts_ForTesting
import com.example.eyesonthetableyop.viewmodels.HomeScrollScreenViewModel

@Composable
fun HomeScrollScreen(modifier: Modifier=Modifier,
                     viewModel: HomeScrollScreenViewModel = HomeScrollScreenViewModel(),
                     navController: NavController,
                     onNewPostClick: () -> Unit = {},

){
    val imgUrls by viewModel.imgURLs.collectAsState()
    val postsRepo_fortest = UserRepo_Test()
    val posts_fortest = postsRepo_fortest.getAllPosts()

    val postRepo = PostRepo_Test()
    val posts = postRepo.getAllPosts()

    Surface(modifier = Modifier
        .fillMaxSize()
        .padding(0.dp,20.dp),
        color = Color.Gray){

        Column {
            AppBar(
                onNewPostClick = { onNewPostClick() }
            )
           Posts_ForTesting(posts_fortest)
            HorizontalDivider()
//            Post(posts = posts)

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Text(text = "Images from Firebase Storage")
                LazyColumn {
                    items(imgUrls){imgUrl ->
                        AsyncImage(
                            model = imgUrl,
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                        )
                    }
                }
            }
        }


    }

}
@Composable
fun AppBar(modifier: Modifier = Modifier,
           onNewPostClick: () -> Unit){
    val context = LocalContext.current
    Row (modifier = Modifier.fillMaxWidth()
        .height(35.dp)
        .padding(5.dp)){
        Image(painter = painterResource(id= R.drawable.eyeofsauron),
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
            Image(painter = painterResource(R.drawable.plus_icon),
                contentDescription = "Add new post",
                contentScale = ContentScale.Fit,
                modifier = modifier
                    .wrapContentWidth()
                    .size(32.dp)
                    .clip(shape = CircleShape)
                    .clickable { onNewPostClick() }
            )
            Spacer(Modifier.width(12.dp))
            Image(painter = painterResource(R.drawable.eye_icon),
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
    HomeScrollScreen(navController = NavController(LocalContext.current))
}