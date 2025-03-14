package com.example.eyesonthetableyop.repos

import com.example.eyesonthetableyop.models.Comment
import com.example.eyesonthetableyop.models.Post
import com.example.eyesonthetableyop.models.User

class PostRepo_Test {

    val testUser = User(
        id = 5,
        userName = "Timmy test",
        imgURL = "https://media.istockphoto.com/id/2099403180/photo/laughing-yougn-businesswoman-standing-with-her-arms-crossed-against-an-office-wall.jpg?s=2048x2048&w=is&k=20&c=Bxof_N_lGmZ_xYhiNp53Uz8g3tJZk4de01NRvmSh8n0="
    )
    val testCommenter = User(
        id = 10,
        userName = "Sarah",
        imgURL = "https://media.istockphoto.com/id/2099403180/photo/laughing-yougn-businesswoman-standing-with-her-arms-crossed-against-an-office-wall.jpg?s=2048x2048&w=is&k=20&c=Bxof_N_lGmZ_xYhiNp53Uz8g3tJZk4de01NRvmSh8n0="
    )
    val testComments = listOf(
        Comment(
            owner = testCommenter ,
            content = "So cool!"
        ),
        Comment(
            owner = testCommenter,
            content = "Inspiring!"
        )
    )

    fun getAllPosts():List<Post>{
        return listOf(
            Post(
                postID = 5,
                title = "Wood",
                imgURL = "https://media.istockphoto.com/id/2149316473/photo/woman-walking-in-fantasy-landscape.jpg?s=2048x2048&w=is&k=20&c=Je10cUo1Mf5O0HHMTOO_PY1GbBxot3cow9lQcgThcKI=",
                description = "Hella trippy brah",
                likes = 1,
                postOwner = testUser,
                comments = testComments
            ),
            Post(
                postID = 4,
                title = "Wood",
                imgURL = "https://media.istockphoto.com/id/2149316473/photo/woman-walking-in-fantasy-landscape.jpg?s=2048x2048&w=is&k=20&c=Je10cUo1Mf5O0HHMTOO_PY1GbBxot3cow9lQcgThcKI=",
                description = "Hella trippy brah",
                likes = 10,
                postOwner = testUser,
                comments = testComments
            ),
            Post(
                postID = 8,
                title = "Wood",
                imgURL = "https://media.istockphoto.com/id/2149316473/photo/woman-walking-in-fantasy-landscape.jpg?s=2048x2048&w=is&k=20&c=Je10cUo1Mf5O0HHMTOO_PY1GbBxot3cow9lQcgThcKI=",
                description = "Hella trippy brah",
                likes = 5,
                postOwner = testUser,
                comments = testComments
            )
            ,            Post(
                postID = 9,
                title = "Wood",
                imgURL = "https://media.istockphoto.com/id/2149316473/photo/woman-walking-in-fantasy-landscape.jpg?s=2048x2048&w=is&k=20&c=Je10cUo1Mf5O0HHMTOO_PY1GbBxot3cow9lQcgThcKI=",
                description = "Hella trippy brah",
                likes = 7,
                postOwner = testUser,
                comments = null,
            )
        )
    }
}