package com.example.booktour.data.repository

import com.example.booktour.data.dao.UsersDAO
import com.example.booktourdemo.models.User

class UsersRepositoryImpl(private val usersDAO: UsersDAO) {

    suspend fun getUserById(id: String): User? {
        return usersDAO.getUserById(id)
    }

    suspend fun addUser(user: User): Boolean {
        return usersDAO.addUser(user)
    }

    suspend fun updateUser(id: String, user: User): Boolean {
        return usersDAO.updateUser(id, user)
    }

    suspend fun deleteUser(id: String): Boolean {
        return usersDAO.deleteUser(id)
    }

    suspend fun checkUser(email: String): String {
        return usersDAO.CheckUser(email)
    }
}
