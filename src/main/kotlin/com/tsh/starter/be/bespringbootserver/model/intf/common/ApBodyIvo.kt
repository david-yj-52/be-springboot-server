package com.tsh.starter.be.bespringbootserver.model.intf.common

import com.tsh.starter.be.bespringbootserver.constant.InterfaceSystemType
import com.tsh.starter.be.bespringbootserver.util.IdAndTimeUtil

interface ApBodyIvo {
    val siteId: String
    val userId: String
}

inline fun <reified T : ApBodyIvo> T.toApHeadVo(
    src: InterfaceSystemType? = InterfaceSystemType.SERVER,
    tgt: InterfaceSystemType? = InterfaceSystemType.SERVER,
    tid: String? = IdAndTimeUtil.generateTid()

): ApHeadVo {
    return ApHeadVo(
        src = src ?: InterfaceSystemType.SERVER,
        tgt = tgt ?: InterfaceSystemType.SERVER,
        mid = IdAndTimeUtil.generateTid(),
        tid = tid,
        enm = this::class.simpleName ?: "Unknown"

    )
}
