package com.tsh.starter.be.bespringbootserver.model.intf.out

import com.tsh.starter.be.bespringbootserver.constant.InterfaceSystemType
import com.tsh.starter.be.bespringbootserver.constant.UserOsType
import com.tsh.starter.be.bespringbootserver.model.intf.common.ApBodyIvo

data class SERVER_DEPLOY_VER_REP(
    override val siteId: String, override val userId: String,

    val apGrpNm: String,
    val apNm: String,
    val apVersion: String,
    val userOsType: UserOsType


) : ApBodyIvo {
    companion object {
        val TGT = InterfaceSystemType.Loader
    }
}
