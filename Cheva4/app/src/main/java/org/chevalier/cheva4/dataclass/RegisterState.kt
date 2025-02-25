package org.chevalier.cheva4.dataclass

data class RegisterState(
    val username: String = "",
    val password: String = "",
    val email: String = "",
    val passwordState: Boolean = false,
)
