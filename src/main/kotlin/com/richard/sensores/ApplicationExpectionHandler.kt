package com.richard.sensores

import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.sql.SQLIntegrityConstraintViolationException

@RestControllerAdvice
class ApplicationExpectionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun campos(ex: MethodArgumentNotValidException): Map<String, Any> {
        val map = HashMap<String, Any>()

        println(ex.bindingResult.fieldErrors)

        ex.bindingResult.fieldErrors.forEach {
            map[it.field] = it.defaultMessage!!
        }

        return mapOf(Pair("erro", "campo(s) invalido(s)"), Pair("campos", map))
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(SQLIntegrityConstraintViolationException::class)
    fun restricao(ex: SQLIntegrityConstraintViolationException): Map<String, Any> {
        println(ex.message!!.let { it.substring(it.indexOf("(") + 1, it.indexOf(")")) })

        return mapOf(Pair("erro", "chave estrangeira invalida: " + when(ex.message!!.let { it.substring(it.indexOf("(") + 1, it.indexOf(")")) }){
            "SYSTEM.FK_SENSORES_RESULTADO" -> "sensor não existe"
            else -> "outro erro"
        }))
    }

}