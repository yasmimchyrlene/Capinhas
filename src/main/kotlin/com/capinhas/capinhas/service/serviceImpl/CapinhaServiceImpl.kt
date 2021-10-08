package com.capinhas.capinhas.service.serviceImpl

import com.capinhas.capinhas.controller.handler.exception.NotFoundException
import com.capinhas.capinhas.model.Capinha
import com.capinhas.capinhas.repository.CapinhaRepository
import com.capinhas.capinhas.service.CapinhaService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CapinhaServiceImpl : CapinhaService {

    var logger: Logger = LoggerFactory.getLogger(CapinhaServiceImpl::class.java)

    @Autowired
    lateinit var capinhaRepository: CapinhaRepository

    override fun create(capinha: Capinha): Capinha {
        var capinha = capinhaRepository.save(capinha)
        logger.info("Capinha cadastrada com sucesso")
        return capinha
    }

    override fun getById(id: Long): Capinha {
         var capinha = capinhaRepository.findById(id).orElseThrow {NotFoundException("capinha não encontrada")}
        logger.info("Capinha encontrada")
        return capinha

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
        logger.info("Capinha atualizada com sucesso")
    }

    override fun getAll(): List<Capinha> {
        var capinha = this.capinhaRepository.findAll().toList()
        logger.info("Busca realizada com sucesso")
        return capinha
    }


}