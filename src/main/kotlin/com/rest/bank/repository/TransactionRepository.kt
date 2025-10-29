package com.rest.bank.repository

import com.rest.bank.entity.Card
import com.rest.bank.entity.Transaction
import org.springframework.data.jpa.repository.JpaRepository

interface TransactionRepository : JpaRepository<Transaction, Long> {
    fun findByFromCard(fromCard: Card) : MutableList<Transaction>
    fun findByToCard(toCard: Card) : MutableList<Transaction>
    fun findByFromCardOrToCard(fromCard: Card, toCard: Card) : MutableList<Transaction>
}