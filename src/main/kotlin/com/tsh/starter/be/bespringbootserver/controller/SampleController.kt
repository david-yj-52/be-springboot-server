package com.tsh.starter.be.bespringbootserver.controller

import com.tsh.starter.be.bespringbootserver.model.intf.out.HelloResponseIvo
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime


@RestController
@RequestMapping("/sample")
class SampleController {

    @GetMapping("/hello")
    fun sayHello(@RequestParam(defaultValue = "Guest") name: String): HelloResponseIvo {
        return HelloResponseIvo(
            message = "Hello, $name! Welcome to Spring boot!",
            timestamp = LocalDateTime.now()
        )

    }
}