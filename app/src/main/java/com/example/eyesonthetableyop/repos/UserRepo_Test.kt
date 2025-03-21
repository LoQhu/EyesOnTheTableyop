package com.example.eyesonthetableyop.repos

import com.example.eyesonthetableyop.models.usermodels.UserModel

class UserRepo_Test {

    fun getAllPosts():List<UserModel>{
        return listOf(
            UserModel(
                id = 1,
                userName = "Alex",
                imgURL = "https://media.istockphoto.com/id/1480993877/photo/cute-pet-mouse.jpg?s=2048x2048&w=is&k=20&c=NnuHGjgIIgCBlwO9I5sXRNfK1qeoT0NldiMRfg0U6lA="
            ),
            UserModel(
                id = 4,
                userName = "Lukas",
                imgURL = "https://media.istockphoto.com/id/1765600103/photo/senior-black-man-playing-with-his-dogs-at-home.jpg?s=2048x2048&w=is&k=20&c=J_KGyqN4vhe0_PUGnptMueNuyy1dCjZ766aidwJYqR4="
            ),
            UserModel(
                id = 3,
                userName = "Benjamin",
                imgURL = "https://media.istockphoto.com/id/1483929305/photo/happy-frenchie-dog-sitting-inside-dog-car-seat.jpg?s=2048x2048&w=is&k=20&c=yrc2btogsMzrYqY21pGr3Ut1gZjDbak5pGsYYbhqEZE="
            ),
            UserModel(
                id = 8,
                userName = "Nicklas",
                imgURL = "https://media.istockphoto.com/id/1892103156/photo/a-young-man-and-his-pup-at-the-pet-shop.jpg?s=2048x2048&w=is&k=20&c=vtJFLwiRZ49rX3DcxLg0Fsz1TJiC8TCoMgvHCGVjQvQ="
            ),
            UserModel(
                id = 12,
                userName = "Finn",
                imgURL = "https://media.istockphoto.com/id/1979951980/photo/my-cat-is-my-best-painting-friend.jpg?s=2048x2048&w=is&k=20&c=ecC9hSr5UKx1j4KvyKJy0k3XdkaiOwds4oWkwXIL4c8="
            ),
            UserModel(
                id = 2,
                userName = "Sjogge",
                imgURL = "https://media.istockphoto.com/id/1795133707/photo/pet-owner-stroking-his-old-cat-and-dog-together.jpg?s=2048x2048&w=is&k=20&c=idWovjHcX-qajIIk6yNNNOduEpaWn90xV-i6GbVasCk="
            ),
            UserModel(
                id = 33,
                userName = "Hogge",
                imgURL = "https://media.istockphoto.com/id/1795133707/photo/pet-owner-stroking-his-old-cat-and-dog-together.jpg?s=2048x2048&w=is&k=20&c=idWovjHcX-qajIIk6yNNNOduEpaWn90xV-i6GbVasCk="
            ),
            UserModel(
                id = 22,
                userName = "Mogge",
                imgURL = "https://media.istockphoto.com/id/1795133707/photo/pet-owner-stroking-his-old-cat-and-dog-together.jpg?s=2048x2048&w=is&k=20&c=idWovjHcX-qajIIk6yNNNOduEpaWn90xV-i6GbVasCk="
            ),
            UserModel(
                id = 90,
                userName = "Dokke",
                imgURL = "https://media.istockphoto.com/id/1795133707/photo/pet-owner-stroking-his-old-cat-and-dog-together.jpg?s=2048x2048&w=is&k=20&c=idWovjHcX-qajIIk6yNNNOduEpaWn90xV-i6GbVasCk="
            )

        )
    }
}