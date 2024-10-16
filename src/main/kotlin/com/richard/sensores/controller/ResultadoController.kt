package com.richard.sensores.controller

import com.richard.sensores.model.Resultado
import com.richard.sensores.model.Sensor
import com.richard.sensores.service.ResultadoService
import com.richard.sensores.service.SensorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/sensores/resultados")
class ResultadoController {
    @Autowired
    private lateinit var resultadoService: ResultadoService
    @Autowired
    private lateinit var sensorService: SensorService

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun listar(@PageableDefault(size = 50) pageable: Pageable) = resultadoService.listar(pageable)

    @GetMapping(params = ["sensor"])
    @ResponseStatus(HttpStatus.OK)
    fun listar(@PageableDefault(size = 50) pageable: Pageable, @RequestParam sensor: Long) = sensorService.buscarId(sensor)?.let {
        ResponseEntity.ok().body(resultadoService.listarPorSensor(pageable, it.id!!))
    } ?: ResponseEntity.badRequest().body(mapOf(Pair("erro", "sensor não existe")))

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    fun buscar(@PathVariable id: Long) = resultadoService.buscarId(id)?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun criar(@RequestBody resultado: Resultado) = resultadoService.criar(resultado)


}