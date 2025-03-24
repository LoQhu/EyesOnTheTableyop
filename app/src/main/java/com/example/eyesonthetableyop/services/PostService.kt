package com.example.eyesonthetableyop.services

import android.content.Context
import android.util.Log
import com.example.eyesonthetableyop.models.commentmodels.CommentModel
import com.example.eyesonthetableyop.models.postmodels.PostModel
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class PostService {
    //Get instance of firebase and create reference to collection
    private val firestoreInstance = FirebaseFirestore.getInstance()
    private val collection = firestoreInstance.collection("posts")

    fun getAllPosts(): Flow<List<PostModel>> = callbackFlow {
        val listenerRegistration = collection
            .addSnapshotListener{snapshot, exception ->
                if(exception != null){
                    Log.e("PostService",
                        "Error getting posts from firebase",
                        exception
                    )
                    close(exception)
                    return@addSnapshotListener
            }
                if(snapshot != null){
                    val posts = mutableListOf<PostModel>()
                    for (document in snapshot.documents){
                            val post = PostModel(
                                //postID = document.getString("Document ID") ?: "not found",
                                postID = document.id,
                                title = document.getString("title") ?: "not found",
                                imgURL = document.getString("imgURL") ?: "not found",
                                description = document.getString("description") ?: "not found",
                                likes = document.getLong("likes") ?: 0,
                                postOwner = document.getString("postOwner") ?: "not found",
//                                comments = document.get("comments") as List<CommentModel>,
                            )
                        post?.let{ posts.add(it)}
                        Log.d("PostService", "Post: $post")
                    }
                    trySend(posts)
                }else{
                    Log.e("PostService", "Snapshot is null")
                    close(Exception("Snapshot is null"))
                }
            }
        awaitClose {
            listenerRegistration.remove()
        }
    }

    fun getPostsByTag(
        context: Context,
        tag: String,
        onSuccess: (List<PostModel>) -> Unit,
        onError: (Exception) -> Unit,
    ) {
//TODO
    }

    fun uploadPostToFirebase(
        context: Context,
        post: PostModel,
        onSuccess: () -> Unit,
        onError: (Exception) -> Unit,
    ) {
        //TODO
    }

    fun deletePostFromFirebase(
        context: Context,
        postID: Int,
        onSuccess: () -> Unit,
        onError: (Exception) -> Unit,
    ) {
        //TODO
    }

    fun updatePostInFirebase(
        context: Context,
        post: PostModel,
        onSuccess: () -> Unit,
        onError: (Exception) -> Unit,
    ) {
        //TODO
    }

    fun getAllImageURLsFromFirebase(): Flow<List<String>> = callbackFlow {
        Log.d("PostService", "getAllImageURLsFromFirebase called")
        val listenerRegistration = collection
            .addSnapshotListener{snapshot, exception ->
                if(exception != null){
                    Log.e("PostService",
                        "Error getting image URLs from firebase",
                        exception
                    )
                    close(exception)
                    return@addSnapshotListener
                }
                if(snapshot != null){
                    val imgURLs = mutableListOf<String>()
                    for ( document in snapshot.documents ){
                        val imgURL = document.getString("imgUrl")
                        imgURL?.let { imgURLs.add(it) }
                        Log.d("PostService", "Image URL: $imgURL")
                    }
                    Log.d("PostService", "Image URLs: $imgURLs")
                    trySend(imgURLs)
                }else{
                    Log.e("PostService", "Snapshot is null")
                }
            }
        awaitClose{
            Log.d("PostService", "Listener removed")
            listenerRegistration.remove()
        }
    }
}
