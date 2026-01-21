package com.tsh.starter.be.bespringbootserver.model.intf.`in`

import com.tsh.starter.be.bespringbootserver.constant.SocialType
import com.tsh.starter.be.bespringbootserver.constant.UserCategory

data class NewUserAddReqIvo(
    val code: String,       // Next.js에서 보낸 구글 인가 코드
    // 유저가 추가로 입력한 정보
    val siteId: String,
    val userCategory: UserCategory,
    val socialType: SocialType

)