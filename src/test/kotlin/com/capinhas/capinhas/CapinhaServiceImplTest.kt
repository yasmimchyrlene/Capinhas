package com.capinhas.capinhas

import com.capinhas.capinhas.controller.handler.exception.NotFoundException
import com.capinhas.capinhas.model.Capinha
import com.capinhas.capinhas.repository.CapinhaRepository
import com.capinhas.capinhas.service.CapinhaService
import com.capinhas.capinhas.service.CapinhaServiceImpl
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import java.util.*

@SpringBootTest
@RunWith(MockitoJUnitRunner::class)
class CapinhaServiceImplTest {

    @InjectMocks
    lateinit var capinhaServiceImpl: CapinhaServiceImpl

    @Mock
    lateinit var capinhaRepository: CapinhaRepository

    lateinit var capinha: Capinha

    @Before
    fun setUp() {
        capinha = Capinha(1L, "modelo", "cor", true, 1.0)
    }

    @Test
    fun deveSalvarUmaCapinha(){
        `when`(capinhaRepository.save(capinha)).thenReturn(capinha)
        var result = capinhaServiceImpl.create(capinha)
        Assert.assertEquals("deveria salvar a capinha", result, Unit)
    }

    @Test
    fun deveMostrarUmaCapinha(){
        var capinhaOptional = Optional.of(capinha)
        `when`(capinhaRepository.findById(1L)).thenReturn(capinhaOptional)
        var result = capinhaServiceImpl.getById(1L)
        Assert.assertEquals("deveria mostrar uma capinha", capinha, result);
    }


    @Test
    fun deveDeletarUmaCapinha(){
        doNothing().`when`(capinhaRepository).deleteById(1)
        var result = capinhaServiceImpl.delete(1)
        Assert.assertEquals("deveria deletar uma capinha", result,Unit)
    }

    @Test
    fun updateCapinha(){
        `when`(capinhaRepository.save((Capinha(1, capinha.modelo, capinha.cor,
            capinha.antiImpacto, capinha.preco)))).thenReturn(capinha)
        var result = capinhaServiceImpl.update(1,capinha)
        Assert.assertEquals("deveria atualizar uma capinha",result,Unit)
    }

    @Test
    fun deveriaMostrarTodasAsCapinhas(){
        val capinhaList = listOf(capinha)
        `when`(capinhaRepository.findAll()).thenReturn(capinhaList)
        var result = capinhaServiceImpl.getAll()
        Assert.assertEquals("deveria mostrar as capinhas",capinhaList,result)
    }
}