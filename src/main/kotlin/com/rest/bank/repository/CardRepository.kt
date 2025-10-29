package com.rest.bank.repository

import com.rest.bank.entity.Card
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface CardRepository : JpaRepository<Card, Long> {
    fun findByOwnerUsername(username: String, pageable: Pageable): Page<Card>?
    fun findByOwnerUsername(username: String): MutableList<Card>?
}