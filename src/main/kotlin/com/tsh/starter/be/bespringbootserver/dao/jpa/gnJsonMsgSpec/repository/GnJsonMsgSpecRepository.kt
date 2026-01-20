package com.tsh.starter.be.bespringbootserver.dao.jpa.gnJsonMsgSpec.repository

import com.tsh.starter.be.bespringbootserver.dao.jpa.gnJsonMsgSpec.entity.GnJsonMsgSpecEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GnJsonMsgSpecRepository: JpaRepository<GnJsonMsgSpecEntity, String> {

    fun findByObjId(objId: String): GnJsonMsgSpecEntity?
}