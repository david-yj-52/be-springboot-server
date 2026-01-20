package com.tsh.starter.be.bespringbootserver.dao.jpa.gnUsrMstrInf.repository

import com.tsh.starter.be.bespringbootserver.dao.jpa.gnUsrMstrInf.entity.GnUsrMstrInfEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GnUsrMstrInfRepository : JpaRepository<GnUsrMstrInfEntity, String> {

    fun findBySiteIdAndUsrKey(siteId: String, usrKey: String): GnUsrMstrInfEntity?
}