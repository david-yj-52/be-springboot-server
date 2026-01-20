package com.tsh.starter.be.bespringbootserver.dao.jpa.gnUsrMstrInf.service

import com.tsh.starter.be.bespringbootserver.dao.jpa.gnUsrMstrInf.entity.GnUsrMstrInfEntity
import com.tsh.starter.be.bespringbootserver.dao.jpa.gnUsrMstrInf.repository.GnUsrMstrInfRepository
import org.springframework.stereotype.Service

@Service
class GnUsrMstrInfJpaService (private val gnUsrMstrInfRepository: GnUsrMstrInfRepository)
{
    fun findByUserKey(siteId: String, usrKey: String): List<GnUsrMstrInfEntity> {
        return gnUsrMstrInfRepository.findBySiteIdAndUsrKey(siteId, usrKey);
    }
}