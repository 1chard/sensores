package com.richard.sensores.service

import com.richard.sensores.model.Sensor
import com.richard.sensores.repository.SensorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class SensorService {
    @Autowired
    private lateinit var sensorRepository: SensorRepository

    fun buscarId(id: Long) = sensorRepository.findById(id).getOrNull()

    fun listar(pageable: Pageable) = sensorRepository.findAll(pageable)

    fun criar(sensor: Sensor) = sensorRepository.save(sensor)

    fun atualizar(sensor: Sensor) = sensor.id?.let {
        buscarId(it)?.let { criar(sensor) }
    }
}