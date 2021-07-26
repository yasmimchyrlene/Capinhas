package com.capinhas.capinhas.repository

import com.capinhas.capinhas.model.Capinha
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CapinhaRepository: CrudRepository<Capinha, Long> {
}