package com.capinhas.capinhas.controller.handler.exception

class BadRequestException : RuntimeException{
    constructor (message: String): super(message)
}