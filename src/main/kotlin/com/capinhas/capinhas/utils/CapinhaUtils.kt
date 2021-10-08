package com.capinhas.capinhas.utils

import com.capinhas.capinhas.controller.handler.exception.BadRequestException
import com.capinhas.capinhas.model.Capinha
import org.springframework.util.ObjectUtils

class CapinhaUtils {

    companion object {
        fun validation(capinha: Capinha): Capinha {
            isValor(capinha.preco)
            isModelo(capinha.modelo)
            isCor(capinha.cor)
            return capinha
        }

        private fun isValor(preco: Double) {
            if (preco <= 0) {
                throw BadRequestException("Preço inválido")
            }
        }

        private fun isModelo(nome: String) {
            if (ObjectUtils.isEmpty(nome)) {
                throw BadRequestException("Precisa de um nome válido")
            }
        }

        private fun isCor(nomeCor: String) {
            if (nomeCor == null || nomeCor == "") {
                throw BadRequestException("Cor inválida")
            }
        }
    }
}