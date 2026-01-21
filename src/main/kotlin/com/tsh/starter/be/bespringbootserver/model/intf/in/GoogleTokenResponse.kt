package com.tsh.starter.be.bespringbootserver.model.intf.`in`

data class GoogleTokenResponse(
    val access_token: String,
    val expires_in: Int,
    val scope: String,
    val token_type: String,
    val id_token: String? = null
)