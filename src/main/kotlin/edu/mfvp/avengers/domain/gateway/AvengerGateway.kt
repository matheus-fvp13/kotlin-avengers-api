package edu.mfvp.avengers.domain.gateway

import edu.mfvp.avengers.domain.entities.Avenger
import org.springframework.stereotype.Component

@Component
interface AvengerGateway {
    fun getDetail(id: Long): Avenger?
    fun getAvengers(): List<Avenger>
    fun create(avenger: Avenger): Avenger
    fun delete(id: Long)
    fun update(avenger: Avenger): Avenger
}