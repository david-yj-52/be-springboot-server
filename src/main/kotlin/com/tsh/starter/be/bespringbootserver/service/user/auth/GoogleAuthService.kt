package com.tsh.starter.be.bespringbootserver.service.user.auth

import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier
import com.google.api.client.http.javanet.NetHttpTransport
import com.google.api.client.json.gson.GsonFactory
import com.tsh.starter.be.bespringbootserver.model.intf.internal.GoogleUserInfo
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.util.*


@Service
class GoogleAuthService(
    @Value("\${google.client-id}") private val clientId: String,
) {

    // GoogleIdTokenVerifier는 스레드 세이프하므로 한 번만 생성해서 재사용 가능합니다.
    private val verifier = GoogleIdTokenVerifier.Builder(NetHttpTransport(), GsonFactory())
        .setAudience(Collections.singletonList(clientId))
        .build()

    fun verifyToken(idTokenString: String): GoogleUserInfo {

        println("📍 주입된 Client ID: $clientId")
        println("📍 받은 토큰 값: ${idTokenString}")

        // 1.  토큰 검증 (서명, 만료시간, 발행처 등 체크)
        val idToken = verifier.verify(idTokenString) ?: throw RuntimeException("유효하지 않는 ID Token 입니다.")
        val payload = idToken.payload

        // 2. 고유 식별자(sub) 및 기본 정보 추축
        return GoogleUserInfo(
            id = payload.subject, // sub
            email = payload.email,
            verified_email = payload.emailVerified,
            name = payload["name"] as? String ?: "",
            given_name = payload["given_name"] as? String ?: "",
            family_name = payload["family_name"] as? String ?: "",
            picture = payload["picture"] as? String ?: "",
            locale = payload["locale"] as? String ?: "ko"
        )
    }
}