package edu.mfvp.avengers.infra.gateway

import edu.mfvp.avengers.domain.entities.Avenger
import edu.mfvp.avengers.domain.gateway.AvengerGateway
import edu.mfvp.avengers.infra.persistence.AvengerEntity
import edu.mfvp.avengers.infra.persistence.AvengerRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class AvengerRepositoryGateway(
    private val repository: AvengerRepository
) : AvengerGateway {
    override fun getDetail(id: Long): Avenger? =
        repository.findByIdOrNull(id)?.toAvenger()

    override fun getAvengers(): List<Avenger> =
        repository.findAll().map { it.toAvenger() }

    override fun create(avenger: Avenger): Avenger =
        repository.save(AvengerEntity.from(avenger)).toAvenger()

    override fun delete(id: Long) = repository.deleteById(id)

    override fun update(avenger: Avenger): Avenger =
        repository.save(AvengerEntity.from(avenger)).toAvenger()
}