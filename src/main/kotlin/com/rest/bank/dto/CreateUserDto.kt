package com.rest.bank.dto

import jakarta.validation.constraints.*;

data class CreateUserDto(

    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 30, message = "Username must be 3-30 chars")
    val username: String,

    @NotBlank
    @Email(message = "Email should be valid")
    val email: String,

    @NotBlank
    @Size(min = 6, message = "Password must be at least 6 chars")
    val password: String
)
