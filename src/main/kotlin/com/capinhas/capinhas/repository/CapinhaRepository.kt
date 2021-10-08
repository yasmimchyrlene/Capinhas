package com.capinhas.capinhas.repository

import com.capinhas.capinhas.model.Capinha
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CapinhaRepository: JpaRepository<Capinha, Long> {
}