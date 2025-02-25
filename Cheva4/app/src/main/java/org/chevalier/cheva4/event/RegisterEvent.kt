package org.chevalier.cheva4.event

sealed interface RegisterEvent {
    data class onUsernameChanged (val username: String): RegisterEvent
    data class onPasswordChanged (val password: String): RegisterEvent
    data class onEmailChanged (val email: String): RegisterEvent
    data class onPasswordStateChanged (val passwordState: Boolean): RegisterEvent
    data object onRegister: RegisterEvent
}