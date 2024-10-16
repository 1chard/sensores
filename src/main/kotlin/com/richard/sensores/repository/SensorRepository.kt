package com.richard.sensores.repository

import com.richard.sensores.model.Sensor
import org.springframework.data.jpa.repository.JpaRepository

interface SensorRepository : JpaRepository<Sensor, Long> {
    fun findByNome(sensorName: String): Sensor?
}