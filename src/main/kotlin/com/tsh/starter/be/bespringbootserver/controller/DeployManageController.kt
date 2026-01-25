package com.tsh.starter.be.bespringbootserver.controller

import com.tsh.starter.be.bespringbootserver.model.intf.common.ApInterfaceVo
import com.tsh.starter.be.bespringbootserver.model.intf.`in`.SERVER_DEPLOY_FILE_REQ
import com.tsh.starter.be.bespringbootserver.model.intf.`in`.SERVER_DEPLOY_VER_REQ
import com.tsh.starter.be.bespringbootserver.model.intf.out.SERVER_DEPLOY_VER_REP
import com.tsh.starter.be.bespringbootserver.service.deploy.DeployManageService
import mu.KotlinLogging
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


private val logger = KotlinLogging.logger {}

@RestController
@RequestMapping("/deploy")
class DeployManageController(
    private val deployManageService: DeployManageService,
) {

    @GetMapping("/file")
    fun fetchDeployFile(
        @RequestParam enm: String,
        @RequestBody ivo: ApInterfaceVo<SERVER_DEPLOY_FILE_REQ>,
    ): ResponseEntity<ByteArray> {
        logger.info { "Fetching deployment file. $enm" }
        return deployManageService.fetchDeployFile(ivo)
    }

    @GetMapping("/version")
    fun fetchDeployVersion(
        @RequestParam enm: String,
        @RequestBody ivo: ApInterfaceVo<SERVER_DEPLOY_VER_REQ>,
    ): ResponseEntity<ApInterfaceVo<SERVER_DEPLOY_VER_REP>> {
        logger.info { "Fetching deployment file. $enm" }
        return deployManageService.getLatestDeployVersion(ivo)
    }
}


