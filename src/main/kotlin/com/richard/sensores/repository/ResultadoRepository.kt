package com.richard.sensores.repository

import com.richard.sensores.model.Resultado
import com.richard.sensores.model.Sensor
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface ResultadoRepository : JpaRepository<Resultado, Long> {
    fun findAllByIdSensor(pageable: Pageable, sensor: Long): Page<Resultado>
}