package com.tsh.starter.be.bespringbootserver.dao.jpa.gnJsonMsgSpec.service

import com.tsh.starter.be.bespringbootserver.dao.jpa.gnJsonMsgSpec.entity.GnJsonMsgSpecEntity
import com.tsh.starter.be.bespringbootserver.dao.jpa.gnJsonMsgSpec.repository.GnJsonMsgSpecRepository
import org.springframework.stereotype.Service

@Service
class GnJsonMsgSpecJpaService (private val gnJsonMsgSpecRepository: GnJsonMsgSpecRepository){

    fun findByObjId(objId: String): GnJsonMsgSpecEntity?{
        return gnJsonMsgSpecRepository.findByObjId(objId)
    }

}