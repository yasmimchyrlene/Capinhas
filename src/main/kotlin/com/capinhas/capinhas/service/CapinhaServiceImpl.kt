package com.capinhas.capinhas.service

import com.capinhas.capinhas.model.Capinha
import com.capinhas.capinhas.repository.CapinhaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CapinhaServiceImpl : CapinhaService {
    @Autowired
    lateinit var capinhaRepository: CapinhaRepository

    override fun create(capinha: Capinha) {
        capinhaRepository.save(capinha)
    }

    override fun getById(id: Long): Capinha {
        return this.capinhaRepository.findById(id).orElse(null)
    }

    override fun delete(id: Long) {
        return this.capinhaRepository.deleteById(id)
    }

    override fun update(id: Long, capinha: Capinha) {
        capinhaRepository.save(Capinha(id, capinha.modelo, capinha.cor, capinha.antiImpacto, capinha.preco))
    }

    override fun getAll(): List<Capinha> {
        return this.capinhaRepository.findAll().toList()

    }


}