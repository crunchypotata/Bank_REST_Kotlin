package com.rest.bank.dto

import jakarta.validation.constraints.*

data class CreateCardDto(
    @field:NotNull(message = "Expiration date is required")
    @field:Pattern(
        regexp = "\\d{4}-\\d{2}-\\d{2}",
        message = "Expiration date must be in format YYYY-MM-DD"
    )
    val expireAt: String,

    @field:NotNull(message = "Balance is required")
    @field:Min(value = 0, message = "Balance cannot be negative")
    val balance: Double,

    @field:NotBlank(message = "Username is required")
    @field:Size(min = 3, max = 30, message = "Username must be 3-30 chars")
    val username: String
)
