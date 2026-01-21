package com.tsh.starter.be.bespringbootserver.model.intf.`in`

data class UserCheckReqIvo(
    val code: String,       // Next.js에서 보낸 구글 인가 코드
    val siteId: String

)