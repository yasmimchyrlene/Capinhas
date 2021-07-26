package com.capinhas.capinhas.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Capinha(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,
        val modelo: String = "",
        val cor: String = "",
        val preco: Double = 0.0,
)
