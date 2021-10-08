package com.capinhas.capinhas.service

import com.capinhas.capinhas.model.Capinha

interface CapinhaService {

    fun create(capinha: Capinha): Capinha
    fun getById(id: Long): Capinha
    fun delete(id: Long)
    fun update(id: Long, capinha: Capinha)
    fun getAll(): List<Capinha>


}