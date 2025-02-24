package org.chevalier.cheva4.viewmodel

import android.util.Patterns
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class RegisterViewModel: ViewModel() {
    private val _username = MutableStateFlow("")
    val username: StateFlow<String> = _username.asStateFlow()

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email.asStateFlow()

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password.asStateFlow()

    private val _passwordState = MutableStateFlow(false)
    val passwordState: StateFlow<Boolean> = _passwordState.asStateFlow()

    fun updateUsername(newText: String) {
        _username.value = newText
    }

    fun updateEmail(newText: String) {
        _email.value = newText
    }

    fun updatePassword(newText: String) {
        _password.value = newText
    }

    fun updatePasswordState() {
        _passwordState.value = !_passwordState.value
    }

    fun checkError(): String {
        if (_username.value.length < 5) return "[Error] Panjang username harus lebih dari 5."
        if (!Patterns.EMAIL_ADDRESS.matcher(_email.value).matches()) return "[Error] Format e-mail salah."
        if (_password.value.length < 5 ||
            !_password.value.contains(Regex(".*[0-9A-Za-z].*")))
            return "[Error] Panjang password harus lebih dari 5 dan memuat huruf serta angka"

        return "Registrasi Berhasil"
    }
}