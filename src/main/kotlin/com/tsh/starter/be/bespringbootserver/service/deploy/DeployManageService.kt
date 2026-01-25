package com.tsh.starter.be.bespringbootserver.service.deploy

import com.tsh.starter.be.bespringbootserver.constant.InterfaceSystemType
import com.tsh.starter.be.bespringbootserver.dao.jpa.gnDplyFileInf.service.GnDplyFileInfJpaService
import com.tsh.starter.be.bespringbootserver.model.intf.common.ApInterfaceVo
import com.tsh.starter.be.bespringbootserver.model.intf.common.toApHeadVo
import com.tsh.starter.be.bespringbootserver.model.intf.`in`.SERVER_DEPLOY_FILE_REQ
import com.tsh.starter.be.bespringbootserver.model.intf.`in`.SERVER_DEPLOY_VER_REQ
import com.tsh.starter.be.bespringbootserver.model.intf.out.SERVER_DEPLOY_VER_REP
import mu.KotlinLogging
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.io.File

private val logger = KotlinLogging.logger {}

@Service
class DeployManageService(private val gnDplyFileInfJpaService: GnDplyFileInfJpaService) {

    /**
     * 1. 먼저 버전을 가져오고
     * 2. 버전까지 함께 요청해서 파일을 준다
     * 전문에 바이너리를 넣으면 파싱이 복잡해진다고 함
     */

    fun getLatestDeployVersion(ivo: ApInterfaceVo<SERVER_DEPLOY_VER_REQ>): ResponseEntity<ApInterfaceVo<SERVER_DEPLOY_VER_REP>> {
        val siteId = ivo.body.siteId
        val apGrpNm = ivo.body.apGrpNm
        val apNm = ivo.body.apNm
        val osType = ivo.body.userOsType

        val dplyInf = gnDplyFileInfJpaService.findDeployFilePath(siteId, apGrpNm, apNm, osType)
            ?: throw Exception("No deployment file found for site $siteId $apGrpNm $apNm $osType")

        val apVersion = dplyInf.apVersion ?: throw Exception("No version found for $siteId $apGrpNm $apNm $osType")

        val body = SERVER_DEPLOY_VER_REP(
            siteId = siteId,
            apGrpNm = apGrpNm,
            apNm = apNm,
            apVersion = apVersion,
            userId = InterfaceSystemType.Server.name,
            userOsType = osType,
        )
        val ivo = ApInterfaceVo(body.toApHeadVo(tgt = SERVER_DEPLOY_VER_REP.TGT, tid = ivo.head.tid), body)

        return ResponseEntity.ok(ivo)

    }


    fun fetchDeployFile(ivo: ApInterfaceVo<SERVER_DEPLOY_FILE_REQ>): ResponseEntity<ByteArray> {

        val siteId = ivo.body.siteId
        val apGrpNm = ivo.body.apGrpNm
        val apNm = ivo.body.apNm
        val apVersion = ivo.body.apVersion
        val osType = ivo.body.userOsType

        // search db
        val dplyInf = gnDplyFileInfJpaService.findDeployFilePath(siteId, apGrpNm, apNm, apVersion, osType)
            ?: throw Exception("No deployment file found for site $siteId $apGrpNm $apNm $osType")


        val file = File(dplyInf.filePath ?: throw Exception("File path is not defined."))
        val fileBytes = file.readBytes()

        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"${file.name}\"")
            .contentType(MediaType.APPLICATION_OCTET_STREAM)
            .body(fileBytes)

    }


}