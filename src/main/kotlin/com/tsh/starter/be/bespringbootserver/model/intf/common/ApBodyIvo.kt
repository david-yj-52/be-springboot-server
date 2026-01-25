package com.tsh.starter.be.bespringbootserver.model.intf.common

import com.tsh.starter.be.bespringbootserver.constant.InterfaceSystemType
import com.tsh.starter.be.bespringbootserver.util.IdAndTimeUtil

interface ApBodyIvo {
    val siteId: String
    val userId: String
}

inline fun <reified T : ApBodyIvo> T.toApHeadVo(
    src: InterfaceSystemType? = InterfaceSystemType.Server,
    tgt: InterfaceSystemType? = InterfaceSystemType.Server,
    tid: String? = IdAndTimeUtil.generateTid()

): ApHeadVo {
    return ApHeadVo(
        src = src ?: InterfaceSystemType.Server,
        tgt = tgt ?: InterfaceSystemType.Server,
        mid = IdAndTimeUtil.generateTid(),
        tid = tid,
        enm = this::class.simpleName ?: "Unknown"

    )
}
