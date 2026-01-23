package com.tsh.starter.be.bespringbootserver.model.intf.common

data class ApInterfaceVo<T>(
    val head: ApHeadVo,
    val body: T
)