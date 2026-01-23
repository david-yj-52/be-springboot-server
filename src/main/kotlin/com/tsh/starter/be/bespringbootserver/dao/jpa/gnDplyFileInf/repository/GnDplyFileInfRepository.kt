package com.tsh.starter.be.bespringbootserver.dao.jpa.gnDplyFileInf.repository

import com.tsh.starter.be.bespringbootserver.constant.UseStatCd
import com.tsh.starter.be.bespringbootserver.constant.UserOsType
import com.tsh.starter.be.bespringbootserver.dao.jpa.gnDplyFileInf.entity.GnDplyFileInfEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GnDplyFileInfRepository : JpaRepository<GnDplyFileInfEntity, String> {

    fun findBySiteIdAndApGrpNmAndApNmAndOsTypAndUseStatCd(
        siteId: String,
        apGrpNm: String,
        apNm: String,
        osTyp: UserOsType,
        useStatCd: UseStatCd,
    ): GnDplyFileInfEntity?

    fun findBySiteIdAndApNmAndApVersionAndOsTypAndUseStatCd(
        siteId: String, apNm: String, apVersion: String, osTyp: UserOsType, useStatCd: UseStatCd,
    ): GnDplyFileInfEntity?
}