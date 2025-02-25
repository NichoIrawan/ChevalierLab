package org.chevalier.cheva4.viewmodel

import android.util.Patterns
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.chevalier.cheva4.dataclass.RegisterState
import org.chevalier.cheva4.event.RegisterEvent

class RegisterViewModel: ViewModel() {

    private val _state = MutableStateFlow(RegisterState())
    val state = _state.asStateFlow()

    fun onEvent (event: RegisterEvent) {
        when (event) {
            is RegisterEvent.onUsernameChanged -> updateUsername(event.username)
            is RegisterEvent.onPasswordChanged -> updatePassword(event.password)
            is RegisterEvent.onEmailChanged -> updateEmail(event.email)
            is RegisterEvent.onPasswordStateChanged -> updatePasswordState(event.passwordState)
            RegisterEvent.onRegister -> register()
        }
    }

    private fun updateUsername(newUsername: String) {
        _state.update { it.copy(username = newUsername) }
    }

    private fun updatePassword(newPassword: String) {
        _state.update { it.copy(password = newPassword) }
    }

    private fun updateEmail(newEmail: String) {
        _state.update { it.copy(email = newEmail) }
    }

    private fun updatePasswordState(newPasswordState: Boolean) {
        _state.update { it.copy(passwordState = newPasswordState) }
    }

    private fun register() {}
}