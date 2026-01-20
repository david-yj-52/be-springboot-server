package com.tsh.starter.be.bespringbootserver.dao.jpa.gnUsrMstrInf.service

import com.tsh.starter.be.bespringbootserver.constant.YesOrNo
import com.tsh.starter.be.bespringbootserver.dao.jpa.gnUsrMstrInf.entity.GnUsrMstrInfEntity
import com.tsh.starter.be.bespringbootserver.dao.jpa.gnUsrMstrInf.repository.GnUsrMstrInfRepository
import com.tsh.starter.be.bespringbootserver.model.intf.`in`.NewUserAddReqIvo
import com.tsh.starter.be.bespringbootserver.util.IdAndTimeUtil
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class GnUsrMstrInfJpaService(private val gnUsrMstrInfRepository: GnUsrMstrInfRepository) {

    fun findByUserKey(siteId: String, usrKey: String): GnUsrMstrInfEntity? {
        return gnUsrMstrInfRepository.findBySiteIdAndUsrKey(siteId, usrKey);
    }


    fun saveNewUser(ivo: NewUserAddReqIvo): GnUsrMstrInfEntity {

        var socialYn = YesOrNo.N
        if (ivo.socialType != null) {
            socialYn = YesOrNo.Y
        }
        val gnUsrMstrInfEntity = GnUsrMstrInfEntity(
            usrKey = ivo.userKey,
            usrNm = ivo.userName,
            usrGrp = ivo.userGrade,
            usrCate = ivo.userCategory,
            socialYn = socialYn,
            socialTyp = ivo.socialType
        ).apply {
            this.siteId = ivo.siteId
            this.tid = IdAndTimeUtil.generateTid()
            this.crtUserId = ivo.userName
            this.mdfyUserId = ivo.userName
            this.evnt_nm = ivo::class.simpleName
            this.crtDt = LocalDateTime.now()
        }

        return gnUsrMstrInfRepository.save(gnUsrMstrInfEntity)

    }
}