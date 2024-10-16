package com.richard.sensores

import com.richard.sensores.repository.SensorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class AuthorizationService : UserDetailsService {
    @Autowired
    private val sensorRepository: SensorRepository? = null

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        return sensorRepository!!.findByNome(username)!!
    }
}