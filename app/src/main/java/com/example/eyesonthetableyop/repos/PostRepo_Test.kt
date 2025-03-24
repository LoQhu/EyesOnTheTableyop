//package com.example.eyesonthetableyop.repos
//
//import com.example.eyesonthetableyop.models.commentmodels.CommentModel
//import com.example.eyesonthetableyop.models.postmodels.PostModel
//import com.example.eyesonthetableyop.models.usermodels.UserModel
//
//class PostRepo_Test {
//
//    val testUser = UserModel(
//        id = 5,
//        userName = "Timmy test",
//        imgURL = "https://media.istockphoto.com/id/2099403180/photo/laughing-yougn-businesswoman-standing-with-her-arms-crossed-against-an-office-wall.jpg?s=2048x2048&w=is&k=20&c=Bxof_N_lGmZ_xYhiNp53Uz8g3tJZk4de01NRvmSh8n0="
//    )
//    val testCommenter = UserModel(
//        id = 10,
//        userName = "Sarah",
//        imgURL = "https://media.istockphoto.com/id/2099403180/photo/laughing-yougn-businesswoman-standing-with-her-arms-crossed-against-an-office-wall.jpg?s=2048x2048&w=is&k=20&c=Bxof_N_lGmZ_xYhiNp53Uz8g3tJZk4de01NRvmSh8n0="
//    )
//    val testComments = listOf(
//        CommentModel(
//            owner = testCommenter ,
//            content = "So cool!"
//        ),
//        CommentModel(
//            owner = testCommenter,
//            content = "Inspiring!"
//        )
//    )
//
//    fun getAllPosts():List<PostModel>{
//        return listOf(
//            PostModel(
//                postID = 5,
//                title = "Wood",
//                imgURL = "https://media.istockphoto.com/id/2149316473/photo/woman-walking-in-fantasy-landscape.jpg?s=2048x2048&w=is&k=20&c=Je10cUo1Mf5O0HHMTOO_PY1GbBxot3cow9lQcgThcKI=",
//                description = "Hella trippy brah",
//                likes = 1,
//                postOwner = testUser,
//                comments = testComments
//            ),
//            PostModel(
//                postID = 4,
//                title = "Wood",
//                imgURL = "https://media.istockphoto.com/id/2149316473/photo/woman-walking-in-fantasy-landscape.jpg?s=2048x2048&w=is&k=20&c=Je10cUo1Mf5O0HHMTOO_PY1GbBxot3cow9lQcgThcKI=",
//                description = "Hella trippy brah",
//                likes = 10,
//                postOwner = testUser,
//                comments = testComments
//            ),
//            PostModel(
//                postID = 8,
//                title = "Wood",
//                imgURL = "https://media.istockphoto.com/id/2149316473/photo/woman-walking-in-fantasy-landscape.jpg?s=2048x2048&w=is&k=20&c=Je10cUo1Mf5O0HHMTOO_PY1GbBxot3cow9lQcgThcKI=",
//                description = "Hella trippy brah",
//                likes = 5,
//                postOwner = testUser,
//                comments = testComments
//            )
//            ,PostModel(
//                postID = 9,
//                title = "Wood",
//                imgURL = "https://media.istockphoto.com/id/2149316473/photo/woman-walking-in-fantasy-landscape.jpg?s=2048x2048&w=is&k=20&c=Je10cUo1Mf5O0HHMTOO_PY1GbBxot3cow9lQcgThcKI=",
//                description = "Hella trippy brah",
//                likes = 7,
//                postOwner = testUser,
//                comments = null,
//            )
//        )
//    }
//}