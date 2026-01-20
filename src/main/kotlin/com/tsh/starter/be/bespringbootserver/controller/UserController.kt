package com.tsh.starter.be.bespringbootserver.controller

import com.tsh.starter.be.bespringbootserver.model.intf.`in`.NewUserAddReqIvo
import com.tsh.starter.be.bespringbootserver.service.user.UserBizService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(
    private val usrBizService: UserBizService
) {

    @GetMapping("/fetch")
    fun getUserInfo(@RequestParam(defaultValue = "TSH") siteId: String, @RequestParam() userKey: String): String {
        return "Hello World"
    }

    @PostMapping("/add")
    fun welcomeNewUser(@RequestBody payload: NewUserAddReqIvo): String {
        usrBizService.welcomeToNewUser(payload)
        return "Hello World"
    }
}