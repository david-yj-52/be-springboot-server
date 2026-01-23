package com.tsh.starter.be.bespringbootserver.model.intf.common

import com.tsh.starter.be.bespringbootserver.constant.InterfaceSystemType
import com.tsh.starter.be.bespringbootserver.util.IdAndTimeUtil

data class ApHeadVo(
    val src: InterfaceSystemType,
    val tgt: InterfaceSystemType,
    val tid: String? = IdAndTimeUtil.generateTid(),
    val mid: String,
    val enm: String,
)
