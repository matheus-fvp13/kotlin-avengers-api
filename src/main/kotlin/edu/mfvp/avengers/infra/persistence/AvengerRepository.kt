package edu.mfvp.avengers.infra.persistence

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AvengerRepository : JpaRepository<AvengerEntity, Long>