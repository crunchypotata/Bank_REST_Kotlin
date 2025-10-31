package com.rest.bank.dto

import jakarta.validation.constraints.*
import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "Request for user login")
data class SignInRequest(

    @Schema(description = "Username", example = "Alex123")
    @Size(min = 5, max = 50, message = "Username length must be between 5 and 50 characters")
    @NotBlank(message = "Username cannot be empty")
    val username: String,

    @Schema(description = "Password", example = "my_1secret1_password")
    @Size(min = 8, max = 255, message = "Password must be between 8 and 255 characters")
    @NotBlank(message = "Password cannot be empty")
    val password: String
)
