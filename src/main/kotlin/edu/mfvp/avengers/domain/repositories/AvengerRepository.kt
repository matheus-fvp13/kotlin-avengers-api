package edu.mfvp.avengers.domain.repositories

import edu.mfvp.avengers.domain.entities.Avenger
import org.springframework.stereotype.Component

@Component
interface AvengerRepository {
    fun getDetail(id: Long): Avenger
    fun getAvengers(): List<Avenger>
    fun create(avenger: Avenger): Avenger
    fun delete(id: Long)
    fun update(avenger: Avenger): Avenger
}