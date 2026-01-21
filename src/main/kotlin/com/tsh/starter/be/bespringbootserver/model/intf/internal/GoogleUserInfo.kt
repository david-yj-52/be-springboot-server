package com.tsh.starter.be.bespringbootserver.model.intf.internal

data class GoogleUserInfo(
    val id: String,              // 위에서 말한 'sub'와 동일한 고유 ID
    val email: String,           // 이메일
    val verified_email: Boolean, // 인증 여부
    val name: String,            // 전체 이름
    val given_name: String,      // 이름
    val family_name: String,     // 성
    val picture: String,         // 프로필 사진 URL
    val locale: String           // 지역 (ko, en 등)
)