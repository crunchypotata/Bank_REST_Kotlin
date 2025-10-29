package com.rest.bank.repository

import com.rest.bank.entity.Transaction
import com.rest.bank.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface UserRepository : JpaRepository <User, Long> {
    fun findByUsername (username: String) : Optional<User>
    fun findByEmail(username: String) : Optional<User>
    fun existsByUsername(username: String) : Boolean
    fun existsByEmail(username: String) : Boolean
}