package com.tsh.starter.be.bespringbootserver.controller

import com.tsh.starter.be.bespringbootserver.model.intf.`in`.NewUserAddReqIvo
import com.tsh.starter.be.bespringbootserver.model.intf.`in`.UserCheckReqIvo
import com.tsh.starter.be.bespringbootserver.service.user.UserBizService
import com.tsh.starter.be.bespringbootserver.service.user.auth.GoogleAuthService
import mu.KotlinLogging
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

private val logger = KotlinLogging.logger {}

@RestController
@RequestMapping("/user")
class UserController(
    private val usrBizService: UserBizService,
    private val googleAuthService: GoogleAuthService
) {

    @GetMapping("/fetch")
    fun getUserInfo(@RequestParam(defaultValue = "TSH") siteId: String, @RequestParam() userKey: String): String {
        return "Hello World"
    }

    @PostMapping("/register")
    fun welcomeNewUser(@RequestBody payload: NewUserAddReqIvo): ResponseEntity<Any> {

        val user = googleAuthService.verifyToken(payload.code)
            ?: return ResponseEntity.status(401).body("Token invalid")

        usrBizService.welcomeToNewUser(payload, user)
        return ResponseEntity.ok(mapOf("message" to "success"))
    }

    @PostMapping("/auth/check")
    fun checkTokenValid(@RequestBody payload: UserCheckReqIvo): ResponseEntity<Any> {

        val user = googleAuthService.verifyToken(payload.code)
            ?: return ResponseEntity.status(401).body("Token invalid")

        val registeredUser = usrBizService.fetchUser(payload.siteId, user.id)

        return if (registeredUser != null) {
            logger.warn("User ${user.name} is already registered")
            ResponseEntity.ok(
                mapOf(
                    "status" to "EXISTING"
                )
            )
        } else {
            logger.info("User ${user.name} is first and valid.")
            ResponseEntity.ok(
                mapOf(
                    "status" to "NEW"
                )
            )
        }

    }
}