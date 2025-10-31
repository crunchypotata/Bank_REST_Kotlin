package com.rest.bank.dto

data class CardDto (
    val id: Long,
    val maskedNumber: String,
    val status: String,
    val expireAt: String,
    val balance: Double,
    val ownerUsername: String
)