//package com.example.eyesonthetableyop.fragments
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxHeight
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.wrapContentHeight
//import androidx.compose.foundation.layout.wrapContentSize
//import androidx.compose.foundation.layout.wrapContentWidth
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.foundation.lazy.rememberLazyListState
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.Button
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.FilterQuality
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import coil.compose.rememberAsyncImagePainter
//import coil.request.ImageRequest
//import com.example.eyesonthetableyop.models.postmodels.PostModel
////import com.example.eyesonthetableyop.repos.PostRepo_Test
//
//
//@Composable
//fun Post(posts: List<PostModel>){
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .wrapContentHeight()
//            .padding(top = 5.dp, bottom = 5.dp)
//    ) {
//        LazyColumn(
//            state = rememberLazyListState(),
//            modifier = Modifier
//                .padding(5.dp)
//        ) {
//            items(items = posts) { post ->
//                PostItem(post = post)
//            }
//        }
//    }
//}
//
//@Composable
//fun PostItem(post: PostModel){
//    val context = LocalContext.current
////    val commentCount = post.getCommentCount()
//
//    Row(modifier = Modifier
//        .wrapContentWidth()
//    ) {
////        Image(painter = rememberAsyncImagePainter(model = ImageRequest.Builder(context)
////            .crossfade(true)
////            .data(post.postOwner.imgURL)
////            .build(), filterQuality = FilterQuality.High),
////            contentDescription = null,
////            contentScale = ContentScale.Crop,
////            modifier = Modifier
////                .wrapContentWidth()
////                .wrapContentHeight()
////                .size(32.dp)
////                .clip(shape = CircleShape)
////        )
//        Text(
//            text = post.postOwner,
//            color = Color.White,
//            modifier = Modifier
//                .padding(start = 5.dp)
//                .align(Alignment.CenterVertically)
//        )
//        Row(modifier = Modifier
//            .wrapContentSize(align = Alignment.TopStart)
//            .fillMaxWidth()
//        ) {
//            Text(
//                text = "...",
//                color = Color.White,
//                fontSize = 24.sp,
//                modifier = Modifier.padding(5.dp)
//            )
//        }
//    }
//    Spacer(modifier = Modifier.height(10.dp))
//    Image(painter = rememberAsyncImagePainter(model = ImageRequest.Builder(context)
//        .crossfade(true)
//        .data(post.imgURL)
//        .build(), filterQuality = FilterQuality.High),
//        contentDescription = null,
//        contentScale = ContentScale.Fit,
//        modifier = Modifier
//            .fillMaxHeight()
//            .height(350.dp)
//            .clip(shape = RoundedCornerShape(4.dp))
//    )
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//    ) {
//        Button(
//            onClick = { println("You like this!") },
//        ) {
//            Text(text = "Like")
//        }
//        Text(text = "${post.likes} Like(s)", modifier = Modifier.padding(start = 5.dp, end = 5.dp).align(Alignment.CenterVertically))
//        Button(
//            onClick = { println("You commented!")},
//        ) {
//            Text(text = "Comment")
//        }
//        var textForComment =""
//        if(commentCount == 0){
//            textForComment= "No Comments"
//        }else if(commentCount == 1){
//            textForComment = "1 Comment"
//        }else{
//            textForComment = "${post.comments?.count()} Comments"
//        }
//        Text(text = textForComment,modifier = Modifier.padding(start = 5.dp, end = 5.dp).align(Alignment.CenterVertically))
//
//    }
//    Row() {
//        Text(text = post.title,color = Color.White)
//    }
//    Row() {
//        Text(text = post.description,color = Color.White)
//    }
//
//}
//
//@Preview
//@Composable
//fun postFragmentPreview(){
////    val postRepo = PostRepo_Test()
////    val testPosts = postRepo.getAllPosts()
////    Post(testPosts)
//}