package com.tsh.starter.be.bespringbootserver.model.intf.`in`

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.tsh.starter.be.bespringbootserver.constant.InterfaceSystemType
import com.tsh.starter.be.bespringbootserver.model.intf.common.ApBodyIvo
import com.tsh.starter.be.bespringbootserver.model.intf.common.ApInterfaceVo
import com.tsh.starter.be.bespringbootserver.model.intf.common.toApHeadVo

data class SampleBodyIvo(
    val status: String,
    val version: String,
    val path: String,
    override val siteId: String,
    override val userId: String
) : ApBodyIvo {
    companion object {
        val SRC = InterfaceSystemType.UI
        val URI = "/sameple"
        val METHOD = "GET"

    }
}

fun main() {

    val objectMapper = jacksonObjectMapper()

    val body = SampleBodyIvo(
        status = "Active",
        version = "1.0",
        path = "/sameple",
        siteId = "Sample",
        userId = "user"
    )

    val head = body.toApHeadVo(src = SampleBodyIvo.SRC)

    val ivo = ApInterfaceVo(head, body)

    println(objectMapper.writeValueAsString(ivo))
}