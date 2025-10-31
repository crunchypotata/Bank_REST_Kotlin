package com.rest.bank.dto

import io.swagger.v3.oas.annotations.media.Schema

data class JwtAuthenticationResponse(
    @Schema(description = "JWT Access token", example = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTYyMjUwNj...")
    val token: String,

)
