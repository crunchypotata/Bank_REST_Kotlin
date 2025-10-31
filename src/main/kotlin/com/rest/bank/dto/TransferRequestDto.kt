package com.rest.bank.dto

import jakarta.validation.constraints.*
import io.swagger.v3.oas.annotations.media.Schema

@Schema(
    description = "Request DTO for transferring funds between two cards"
)
data class TransferRequestDto(

    @NotNull(message = "Source card ID is required")
    val fromCardId: Long,

    @NotNull(message = "Destination card ID is required")
    val toCardId: Long,

    @NotNull(message = "Amount is required")
    @Min(value = 1, message = "Amount must be greater than 0")
    val amount: Double
)
