package com.tsh.starter.be.bespringbootserver.model.intf.`in`

import com.tsh.starter.be.bespringbootserver.constant.SocialType
import com.tsh.starter.be.bespringbootserver.constant.UserCategory
import com.tsh.starter.be.bespringbootserver.constant.UserGrade

data class NewUserAddReqIvo(
    val siteId: String,
    val userKey: String,
    val userName: String,
    val userGrade: UserGrade,
    val userCategory: UserCategory,
    val socialType: SocialType

)