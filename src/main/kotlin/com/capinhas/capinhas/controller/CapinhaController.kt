package com.capinhas.capinhas.controller

import com.capinhas.capinhas.model.Capinha
import com.capinhas.capinhas.service.CapinhaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/capinhas"])
class CapinhaController {

    @Autowired
    lateinit var capinhaService: CapinhaService

    @PostMapping
    fun create(@RequestBody capinha: Capinha): ResponseEntity<Any> {
        this.capinhaService.create(capinha)
        return ResponseEntity(capinha, HttpStatus.CREATED)
    }

    @GetMapping
    fun getAll(): ResponseEntity<Any> {
        var capinha = this.capinhaService.getAll()
        return ResponseEntity(capinha, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        capinhaService.delete(id)
        return ResponseEntity(Unit, HttpStatus.NO_CONTENT)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody capinha: Capinha): ResponseEntity<Any> =
            ResponseEntity(this.capinhaService.update(id, capinha), HttpStatus.OK)

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Any> {
        var capinha = this.capinhaService.getById(id)
        return ResponseEntity(capinha, HttpStatus.OK)
    }

}