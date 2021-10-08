package com.capinhas.capinhas.controller

import com.capinhas.capinhas.model.Capinha
import com.capinhas.capinhas.service.CapinhaService
import com.capinhas.capinhas.utils.CapinhaUtils
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/capinhas")
@Api(value = "API REST Capinhas")
class CapinhaController {

    var logger: Logger = LoggerFactory.getLogger(CapinhaController::class.java)

    @Autowired
    lateinit var capinhaService: CapinhaService

    @PostMapping
    @ApiOperation(value = "Cadastra uma capinha")
    fun create(@RequestBody capinha: Capinha): ResponseEntity<Any> {
        logger.info("Capinha recebida {}",capinha)
        var capinhaEntity = this.capinhaService.create(capinha)
        CapinhaUtils.validation(capinha)
        logger.info("Retornando capinha {}",capinha)
        return ResponseEntity(capinhaEntity, HttpStatus.CREATED)
    }
    @GetMapping
    @ApiOperation(value = "Mostra todas as capinhas")
    fun getAll(): ResponseEntity<Any> {
        var capinha = this.capinhaService.getAll()
        logger.info("Retornando capinhas")
        return ResponseEntity(capinha, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deleta uma capinha")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        capinhaService.delete(id)
        logger.info("Capinha deletada id {} ",id)
        return ResponseEntity(Unit, HttpStatus.NO_CONTENT)
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Altera uma capinha")
    fun update(@PathVariable id: Long, @RequestBody capinha: Capinha): ResponseEntity<Any> {
        this.capinhaService.update(id, capinha)
        logger.info("Atualização recebida",capinha)
        CapinhaUtils.validation(capinha)
        return ResponseEntity(Unit, HttpStatus.OK)
    }
    @GetMapping("/{id}")
    @ApiOperation(value = "Mostra uma única capinha")
    fun getById(@PathVariable id: Long): ResponseEntity<Any> {
        logger.info("Id recebido")
        var capinha = this.capinhaService.getById(id)
        logger.info("Retornando capinha")
        return ResponseEntity(capinha, HttpStatus.OK)
    }

}