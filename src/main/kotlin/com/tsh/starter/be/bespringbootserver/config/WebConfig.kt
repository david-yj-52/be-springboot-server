package com.tsh.starter.be.bespringbootserver.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig: WebMvcConfigurer {

    override fun addCorsMappings(regsitry: CorsRegistry){
        regsitry.addMapping("/**").allowedOrigins("http://localhost:3000", "https://tsh-web-plate.vercel.app")
    }
}