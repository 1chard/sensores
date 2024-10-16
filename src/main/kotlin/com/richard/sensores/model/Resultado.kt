package com.richard.sensores.model

import jakarta.persistence.*
import jakarta.validation.constraints.Digits
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "tbl_resultadoS")
data class Resultado(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_RESULTADOS")
    @SequenceGenerator(name = "SEQ_RESULTADOS", sequenceName = "SEQ_RESULTADOS", allocationSize = 1)
    var id : Long? = null,
    @Column(name = "id_sensor")
    var idSensor : Long? = null,
    @Min(0, message = "umidade deve ser positiva")
    @Max(1, message = "umidade deve ser até 1 (100%)")
    @Digits(integer = 1, fraction = 2, message = "umidade deve ter apenas 1 digito na frente e dois digitos atras")
    var umidade : BigDecimal? = null,
    @Column(updatable = false)
    var horario : LocalDateTime? = LocalDateTime.now()
) {
//    constructor() : this(null)
}
