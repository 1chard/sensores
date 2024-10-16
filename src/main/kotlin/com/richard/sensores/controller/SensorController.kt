package com.richard.sensores.controller

import com.richard.sensores.model.Sensor
import com.richard.sensores.service.SensorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/sensores")
class SensorController {
    @Autowired
    private lateinit var sensorService: SensorService

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun listar(@PageableDefault(size = 50) pageable: Pageable) = sensorService.listar(pageable)

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    fun buscar(@PathVariable id: Long) = sensorService.buscarId(id)?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun criar(@RequestBody sensor: Sensor) = sensorService.criar(sensor)

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    fun atualizar(@RequestBody sensor: Sensor) = sensorService.atualizar(sensor)?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
}