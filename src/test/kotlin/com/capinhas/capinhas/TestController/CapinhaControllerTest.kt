package com.capinhas.capinhas.TestController

import com.capinhas.capinhas.controller.CapinhaController
import com.capinhas.capinhas.model.Capinha
import com.capinhas.capinhas.service.CapinhaService
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.doNothing
import org.mockito.junit.MockitoJUnitRunner
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus


@SpringBootTest
@RunWith(MockitoJUnitRunner::class)
class CapinhaControllerTest {
    @InjectMocks
    lateinit var capinhaController: CapinhaController

    @Mock
    lateinit var capinhaService: CapinhaService

    lateinit var capinha: Capinha

    @Before
    fun setUp(){
        capinha = Capinha(1L,"modelo","cor",true,1.0)
    }

    @Test
    fun deveriaCriarACapinha(){
        //doNothing só para VOID(UNIT) sem retorno.
        `when`(capinhaService.create(capinha)).thenReturn(capinha)
        var result = capinhaController.create(capinha)
        Assert.assertEquals("deveria criar a capinha",capinha,result.getBody());
    }
    @Test
    fun deveriaMostrarTodasAsCapinhas(){
        val capinhaList = listOf(capinha)
        `when`(capinhaService.getAll()).thenReturn(capinhaList)
        var result = capinhaController.getAll()
        Assert.assertEquals("deveria mostras as capinhas",capinhaList,result.getBody());
    }

    @Test
    fun deveriaDeletarUmaCapinha(){
        doNothing().`when`(capinhaService).delete(1L)
        var result = capinhaController.delete(1L)
        Assert.assertEquals("deveria deletar uma capinha",result.statusCode, HttpStatus.NO_CONTENT);
    }

    @Test
    fun deveriaAlterarUmaCapinha(){
        doNothing().`when`(capinhaService).update(1L,capinha)
        var result = capinhaController.update(1L,capinha)
        Assert.assertEquals("deveria alterar uma capinha",HttpStatus.OK,result.statusCode);
    }

    @Test
    fun deveriaMostrarUmaCapinha(){
        `when`(capinhaService.getById(1L)).thenReturn(capinha)
        var result = capinhaController.getById(1L)
        Assert.assertEquals("deveria mostrar uma capinha",capinha,result.getBody());
    }

}
