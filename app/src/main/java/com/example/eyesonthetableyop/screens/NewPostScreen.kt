package com.example.eyesonthetableyop.screens

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.example.eyesonthetableyop.R
import com.example.eyesonthetableyop.models.postmodels.NewPostModel
import com.example.eyesonthetableyop.tools.AppSettings
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage

@Composable
fun NewPostScreen(navController: NavHostController) {
    var context = LocalContext.current
    var title:MutableState<String> = remember { mutableStateOf("") }
    var description:MutableState<String> = remember { mutableStateOf("") }
    var imgUrl:MutableState<String> = remember { mutableStateOf("") }
    var imgUri by remember {
        mutableStateOf<Uri?>(null)
    }
    val singleImagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = {uri -> imgUri = uri}
    )
    val appSettings = AppSettings()

    Surface(
        color = Color.Gray,
        modifier = Modifier.padding(top = 20.dp)
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .wrapContentWidth()
                    .height(35.dp)
                    .padding(5.dp)
            ){
                Image(painter = painterResource(R.drawable.icons8_back_button_50),
                    contentDescription = "Back button",
                    modifier = Modifier
                        .size(32.dp)
                        .wrapContentWidth()
                        .align(alignment = Alignment.CenterVertically)
                        .clickable { navController.navigateUp() }
                )
                Spacer(Modifier.width(25.dp))
                Text(text = "New post", fontSize = 20.sp, color = Color.White)
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(align = Alignment.TopEnd)
                ) {
                    Image(painter = painterResource(R.drawable.icons8_check_mark_50),
                        contentDescription = null,
                        modifier = Modifier
                            .size(32.dp)
                            .wrapContentWidth()
                            .align(alignment = Alignment.CenterVertically)
                            .clickable {
                                if (validatePost(imgUri, title.value, description.value, context)) {
                                    uploadImageToFirebase(
                                        NewPostModel(
                                            title = title.value,
                                            description = description.value,
                                            imgURL = null,
                                            postOwner = "TestUser",
                                        ),
                                        imgUri,
                                        context = context
                                    ) { downloadUrl ->
                                        Toast
                                            .makeText(
                                                context,
                                                downloadUrl,
                                                Toast.LENGTH_SHORT
                                            )
                                            .show()
                                        Log.d("NewPostScreen", "Image URL: $downloadUrl")
                                    }
                                }
                            }
                    )
                }
            }

            Row(modifier = Modifier.fillMaxWidth()
            ){
                if(imgUri != null){
                    AsyncImage(
                        model = imgUri,
                        contentDescription = null,
                        modifier = Modifier.size(200.dp),
                        contentScale = ContentScale.Crop,
                    )
                }else{
                    Image(
                        painter = painterResource(R.drawable.icons8_no_image_100),
                        contentDescription = null,
                        modifier = Modifier
                            .size(200.dp)
                    )
                }
                Button(
                        onClick = { singleImagePickerLauncher.launch(
                            PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                        ) },
                modifier = Modifier.align(alignment = Alignment.CenterVertically)
                ) {
                Text(text = "Choose Image")
            }
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth()
                .padding(top = 15.dp, start = 5.dp)
            ){
                TextField(
                    value = title.value,
                    onValueChange = {title.value = it},
                    maxLines = 3,
                    label = { Text(text = "Title") }
                )
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth()
                .padding(top = 15.dp, start = 5.dp)
            ) {
                TextField(
                    value = description.value,
                    onValueChange = {description.value = it},
                    maxLines = 10,
                    label = { Text(text = "Description") },
                )
            }
        }
    }
}
fun openFileChooser(){
    val intent = Intent()
    intent.type = "image/*"
    intent.action = Intent.ACTION_GET_CONTENT
    Intent.createChooser(intent, "Choose an image to upload")
}

fun validatePost(imgUri: Uri?, title: String, desc: String, context: Context):Boolean{
    if(imgUri == null){
        Toast.makeText(
            context,
            "Please select an image",
            Toast.LENGTH_SHORT
        ).show()
        return false
    }
    if(title.isEmpty()){
        Toast.makeText(
            context,
            "Please enter a title",
            Toast.LENGTH_SHORT
        ).show()
        return false
        }
    if(desc.isEmpty()){
        Toast.makeText(
            context,
            "Please enter a description",
            Toast.LENGTH_SHORT
        ).show()
        return false
    }
    return true
}

fun uploadImageToFirebase(newPost:NewPostModel,uri: Uri?, context:Context, onComplete:(String) -> Unit ){
    val storage = FirebaseStorage.getInstance()
    val storageReference = storage.reference
    val imageReference = storageReference.child("images/${uri!!.lastPathSegment}")

    val uploadTask = uri?.let { imageReference.putFile(it)}

    uploadTask?.addOnSuccessListener {
        Toast.makeText(
            context,
            "Image uploaded",
            Toast.LENGTH_SHORT
        ).show()
        imageReference.downloadUrl.addOnSuccessListener { downloadUri ->
            savePostToFirestore(NewPostModel(
                title = newPost.title,
                description = newPost.description,
                imgURL = downloadUri.toString(),
                postOwner = newPost.postOwner,
            ),downloadUri.toString(),context)
            onComplete(downloadUri.toString())
        }.addOnFailureListener{
            Toast.makeText(
                context,
                "Error in getting image URL",
                Toast.LENGTH_SHORT,
            ).show()
        }
    }?.addOnFailureListener{
        Toast.makeText(
            context,
            "Image upload failed, try again",
            Toast.LENGTH_SHORT,
        ).show()
    }
}

fun savePostToFirestore(newPost:NewPostModel,imageUrl:String, context:Context){
    val db = Firebase.firestore
    val postData = hashMapOf(
        "description" to newPost.description,
        "imgURL" to imageUrl,
        "title" to newPost.title,
        "postOwner" to newPost.postOwner,
    )
    db.collection("posts")
        .add(postData)
        .addOnSuccessListener {
            Toast.makeText(
                context,
                "Post saved",
                Toast.LENGTH_SHORT,
            ).show()
        }
        .addOnFailureListener {e->
            Toast.makeText(
                context,
                "Error saving post: $e",
                Toast.LENGTH_LONG
            ).show()
            Log.e("NewPostScreen", "Error saving post: $e")
        }
}
@Preview
@Composable
fun NewPostScreenPreview(){
    NewPostScreen(navController = NavHostController(LocalContext.current))
}