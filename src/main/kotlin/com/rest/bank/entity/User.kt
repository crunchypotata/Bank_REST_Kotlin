package com.rest.bank.entity

import jakarta.persistence.*
import jakarta.validation.constraints.*
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Entity
@Table(name = "users")
class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @field:NotBlank
    @field:Size(min = 3, max = 100)
    @Column (nullable = false, length = 100)
    val username: String = "",

    @field:NotBlank
    @field:Size(min = 6)
    @Column(nullable = false)
    val password: String = "",

    @field:NotBlank
    @field:Email
    @Column(nullable = false, unique = true)
    val email: String = "",

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role", nullable = false)
    val userRole: UserRole = UserRole.USER,

    @OneToMany(mappedBy = "owner", cascade = [CascadeType.ALL], orphanRemoval = true)
    var cards: MutableList<Card> = mutableListOf()

) : UserDetails {

    // properties of UserDetails
    override fun getAuthorities(): kotlin.collections.List<GrantedAuthority> =
        listOf(SimpleGrantedAuthority(userRole.name))

    override fun getPassword() = password
    override fun getUsername() = username
    override fun isAccountNonExpired() = true
    override fun isAccountNonLocked() = true
    override fun isCredentialsNonExpired() = true
    override fun isEnabled() = true
}