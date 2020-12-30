package com.example.android4a.data.repository

import com.example.android4a.data.local.DataBaseDAO
import com.example.android4a.data.local.models.toData
import com.example.android4a.data.local.models.toEntity
import com.example.android4a.domain.entity.User

class UserRepository(
    private val dataBaseDAO: DataBaseDAO
) {

    suspend fun createUser(user: User){
       dataBaseDAO.insert(user.toData())
    }

    fun getUser(email: String) : User? {
        val userLocal = dataBaseDAO.findByName(email)
        return userLocal?.toEntity()
    }
}