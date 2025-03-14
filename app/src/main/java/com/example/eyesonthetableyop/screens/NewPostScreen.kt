package com.example.eyesonthetableyop.screens

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContract
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHostState
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
import coil.compose.AsyncImage
import com.example.eyesonthetableyop.R
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.launch

@Composable
fun NewPostScreen(){
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
                    contentDescription = null,
                    modifier = Modifier
                        .size(32.dp)
                        .wrapContentWidth()
                        .align(alignment = Alignment.CenterVertically)
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
                                if(imgUri != null){
                                    uploadImageToFirebase(imgUri,
                                        context = context
                                    ){
                                        downloadUrl ->
                                        Toast.makeText(
                                            context,
                                            downloadUrl,
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                }
                            }
                    )
                }
            }

            Row(modifier = Modifier.fillMaxWidth()
            ){
                AsyncImage(
                    model = imgUri,
                    contentDescription = null,
                    modifier = Modifier.size(200.dp),
                    contentScale = ContentScale.Crop,
                )
//                Image(
//                    painter = painterResource(R.drawable.icons8_no_image_100),
//                modifier = Modifier
//                    .size(200.dp)
//                , contentDescription = null)
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

fun validatePost():Boolean{
    return true
}

fun uploadImageToFirebase(uri: Uri?, context:Context, onComplete:(String) -> Unit ){
    val storage = FirebaseStorage.getInstance()
    val storageReference = storage.reference
    val imageReference = storageReference.child("images/${uri!!.lastPathSegment}")

    val uploadTask = uri.let { imageReference.putFile(it)}

    uploadTask.addOnSuccessListener {
        Toast.makeText(
            context,
            "image uploaded",
            Toast.LENGTH_SHORT
        ).show()
    }.addOnFailureListener(){
        Toast.makeText(
            context,
            "image upload failed",
            Toast.LENGTH_SHORT
        ).show()
    }
}


@Preview
@Composable
fun NewPostScreenPreview(){
    NewPostScreen()
}