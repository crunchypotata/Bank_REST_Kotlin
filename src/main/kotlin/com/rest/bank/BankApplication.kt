package com.rest.bank

import com.rest.bank.dto.CardDto
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BankApplication

fun main(args: Array<String>) {
	runApplication<BankApplication>(*args)

}
