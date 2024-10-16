package com.richard.sensores.model

import jakarta.persistence.*
import jakarta.validation.constraints.Digits
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.Size
import org.springframework.boot.context.properties.bind.DefaultValue
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "tbl_sensores")
data class Sensor(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SENSORES")
    @SequenceGenerator(name = "SEQ_SENSORES", sequenceName = "SEQ_SENSORES", allocationSize = 1)
    var id : Long? = null,
    @Size(max = 100, message = "Nome maior que trinta casas")
    var nome : String? = null,
    @Column(updatable = false)
    var inicio : LocalDateTime? = LocalDateTime.now(),
    var ativo : Boolean? = null,
): UserDetails{
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return mutableListOf(SimpleGrantedAuthority("ROLE_USER"))
    }

    override fun getPassword() = id!!.toString()

    override fun getUsername() = nome!!
}