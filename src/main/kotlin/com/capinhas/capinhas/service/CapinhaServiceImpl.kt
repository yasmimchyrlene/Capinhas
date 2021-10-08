package com.capinhas.capinhas.service

import com.capinhas.capinhas.controller.handler.exception.NotFoundException
import com.capinhas.capinhas.model.Capinha
import com.capinhas.capinhas.repository.CapinhaRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CapinhaServiceImpl : CapinhaService {

    var logger: Logger = LoggerFactory.getLogger(CapinhaServiceImpl::class.java)

    @Autowired
    lateinit var capinhaRepository: CapinhaRepository

    override fun create(capinha: Capinha) {
        capinhaRepository.save(capinha)
    }

    override fun getById(id: Long): Capinha {
         return capinhaRepository.findById(id).orElseThrow {NotFoundException("capinha não encontrada")}
    }

    override fun delete(id: Long) {
        try {
            this.capinhaRepository.deleteById(id)
        }catch (ex: Exception){
            logger.info("ID não encontrado")

        }
    }

    override fun update(id: Long, capinha: Capinha) {
        capinhaRepository.save(Capinha(id, capinha.modelo, capinha.cor, capinha.antiImpacto, capinha.preco))
    }

    override fun getAll(): List<Capinha> {
        return this.capinhaRepository.findAll().toList()

    }


}