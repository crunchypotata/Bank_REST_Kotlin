package com.rest.bank.entity

import jakarta.persistence.*
import java.time.LocalDateTime


@Entity
@Table(name = "transactions")
class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_card_id")
    var fromCard: Card? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_card_id")
    var toCard: Card? = null

    var amount: Double? = null
    var createdAt: LocalDateTime? = null
    var status: String? = null
}