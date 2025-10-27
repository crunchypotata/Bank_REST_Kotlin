package com.rest.bank.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "cards")
class Card(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false, length = 16)
    var number: String = "",

    @Column(name = "expire_at", nullable = false)
    var expireAt: LocalDate = LocalDate.now(),

    @Column(nullable = false)
    var status: String = "ACTIVE",

    @Column(nullable = false)
    var balance: Double = 0.0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private val owner: User? = null

)