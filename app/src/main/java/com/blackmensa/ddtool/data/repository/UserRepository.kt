package com.blackmensa.ddtool.data.repository

import com.blackmensa.ddtool.data.local.dao.UserDAO
import com.blackmensa.ddtool.data.local.entity.UserEntity

class UserRepository(
    private val userDAO: UserDAO
) {

    fun login(
        email: String,
        password: String
    ): Boolean {

        return userDAO.getUser(
            email,
            password
        ) != null
    }

    fun addUser(
        email: String,
        name: String,
        password: String
    ): Boolean {

        val result =
            userDAO.insertUser(
                UserEntity(
                    email = email,
                    name = name,
                    password = password
                )
            )

        return result != -1L
    }
}