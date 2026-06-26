package com.blackmensa.ddtool.ui.login

import androidx.lifecycle.ViewModel
import com.blackmensa.ddtool.data.repository.UserRepository

class LoginViewModel(
    private val userRepository: UserRepository
) : ViewModel() {

    fun login(email: String, password: String): Boolean {
        if (email.isBlank() || password.isBlank()) {
            return false
        }

        return userRepository.login(email, password)
    }

    fun createTestUser() {
        userRepository.addUser(
            email = "test@test.com",
            name = "Test",
            password = "1234"
        )
    }
}