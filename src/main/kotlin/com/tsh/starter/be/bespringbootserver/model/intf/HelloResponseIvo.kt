package com.tsh.starter.be.bespringbootserver.model.intf

import java.time.LocalDateTime

data class HelloResponseIvo (
    var message: String? = null,
    val timestamp: LocalDateTime = LocalDateTime.now()
)