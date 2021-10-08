package com.capinhas.capinhas.controller.handler.exception

class NotFoundException : RuntimeException{
    constructor (message: String): super(message)
}