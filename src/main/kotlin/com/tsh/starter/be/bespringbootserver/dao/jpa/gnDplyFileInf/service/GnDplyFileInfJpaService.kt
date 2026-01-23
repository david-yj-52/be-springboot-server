package com.tsh.starter.be.bespringbootserver.dao.jpa.gnDplyFileInf.service

import com.tsh.starter.be.bespringbootserver.constant.UseStatCd
import com.tsh.starter.be.bespringbootserver.constant.UserOsType
import com.tsh.starter.be.bespringbootserver.dao.jpa.gnDplyFileInf.entity.GnDplyFileInfEntity
import com.tsh.starter.be.bespringbootserver.dao.jpa.gnDplyFileInf.repository.GhDplyFileInfRepository
import com.tsh.starter.be.bespringbootserver.dao.jpa.gnDplyFileInf.repository.GnDplyFileInfRepository
import com.tsh.starter.be.bespringbootserver.util.IdAndTimeUtil
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class GnDplyFileInfJpaService(
    private val gnDplyFileInfRepository: GnDplyFileInfRepository,
    private val ghDplyFileInfRepository: GhDplyFileInfRepository,
) {

    fun addNewDeployFile(
        siteId: String,
        apGrpNm: String,
        apNm: String,
        apVersion: String,
        filePath: String,
        osTyp: UserOsType
    ): GnDplyFileInfEntity {

        var existed = gnDplyFileInfRepository.findBySiteIdAndApNmAndApVersionAndOsTypAndUseStatCd(
            siteId, apNm, apVersion, osTyp,
            UseStatCd.Usable
        )

        if (existed != null) {
            throw Exception("Same file already exists!")
        }

        val entity = GnDplyFileInfEntity(
            apGrpNm = apGrpNm,
            apNm = apNm,
            apVersion = apVersion,
            osTyp = osTyp,
            filePath = filePath,
        ).apply {
            this.siteId = siteId
            this.tid = IdAndTimeUtil.generateTid()
            this.crtUserId = "ADMIN"
            this.mdfyUserId = "ADMIN"
            this.evnt_nm = "NEW DEPLOYMENT"
            this.crtDt = LocalDateTime.now()
        }

        val history = entity.toHistory()


        gnDplyFileInfRepository.save(entity)
        ghDplyFileInfRepository.save(history)

        return entity

    }

    fun findDeployFilePath(
        siteId: String,
        apGrpNm: String,
        apNm: String,
        osTyp: UserOsType
    ): GnDplyFileInfEntity? {
        return gnDplyFileInfRepository.findBySiteIdAndApGrpNmAndApNmAndOsTypAndUseStatCd(
            siteId, apGrpNm, apNm, osTyp, UseStatCd.Usable
        )
    }

}