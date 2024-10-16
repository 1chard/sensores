package com.richard.sensores.service

import com.richard.sensores.model.Resultado
import com.richard.sensores.model.Sensor
import com.richard.sensores.repository.ResultadoRepository
import com.richard.sensores.repository.SensorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class ResultadoService {
    @Autowired
    private lateinit var resultadoRepository: ResultadoRepository

    fun buscarId(id: Long) = resultadoRepository.findById(id).getOrNull()

    fun listar(pageable: Pageable) = resultadoRepository.findAll(pageable)

    fun listarPorSensor(pageable: Pageable, idSensor: Long) = resultadoRepository.findAllByIdSensor(pageable, idSensor)

    fun criar(resultado: Resultado) = resultadoRepository.save(resultado)
}