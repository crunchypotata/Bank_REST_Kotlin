package com.rest.bank.service

import com.rest.bank.dto.UserDto
import com.rest.bank.entity.User
import com.rest.bank.dto.CreateUserDto
import com.rest.bank.repository.UserRepository
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: BCryptPasswordEncoder
) {
    // only ADMIN
    @PreAuthorize("hasRole('ADMIN')")
    fun createUser(userDto: CreateUserDto) : UserDto {

        if (userRepository.existsByUsername(userDto.username)) throw RuntimeException("User exists")
        if (userRepository.existsByEmail(userDto.email)) throw RuntimeException("Email exists")

        val user = User(
            username = userDto.username,
            email = userDto.email,
            password = passwordEncoder.encode(userDto.password)
        )
        userRepository.save(user)
        return user.toDto()
    }

    fun readUser() {}

    // only ADMIN
    @PreAuthorize("hasRole('ADMIN')")
    fun updateUser() {

    }

    // only ADMIN
    @PreAuthorize("hasRole('ADMIN')")
    fun deleteUser(id: Long) {
        val user = userRepository.findById(id)
            .orElseThrow { RuntimeException("User not found") }
        userRepository.delete(user)
    }



    fun User.toDto(): UserDto {
        return UserDto(
            id = this.id,
            username = this.username,
            email = this.email
        )
    }

}