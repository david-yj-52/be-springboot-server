package com.tsh.starter.be.bespringbootserver.dao.jpa.gnUsrMstrInf.service

import com.tsh.starter.be.bespringbootserver.constant.UserGrade
import com.tsh.starter.be.bespringbootserver.constant.YesOrNo
import com.tsh.starter.be.bespringbootserver.dao.jpa.gnUsrMstrInf.entity.GnUsrMstrInfEntity
import com.tsh.starter.be.bespringbootserver.dao.jpa.gnUsrMstrInf.repository.GnUsrMstrInfRepository
import com.tsh.starter.be.bespringbootserver.model.intf.`in`.NewUserAddReqIvo
import com.tsh.starter.be.bespringbootserver.model.intf.internal.GoogleUserInfo
import com.tsh.starter.be.bespringbootserver.util.IdAndTimeUtil
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class GnUsrMstrInfJpaService(private val gnUsrMstrInfRepository: GnUsrMstrInfRepository) {

    fun findByUserKey(siteId: String, usrKey: String): GnUsrMstrInfEntity? {
        return gnUsrMstrInfRepository.findBySiteIdAndUsrKey(siteId, usrKey);
    }


    fun saveNewUser(ivo: NewUserAddReqIvo, guser: GoogleUserInfo): GnUsrMstrInfEntity {

        var socialYn = YesOrNo.N
        if (ivo.socialType != null) {
            socialYn = YesOrNo.Y
        }
        val gnUsrMstrInfEntity = GnUsrMstrInfEntity(
            usrKey = guser.id,
            usrNm = guser.name,
            usrCate = ivo.userCategory,
            usrGrp = UserGrade.N,
            socialYn = socialYn,
            socialTyp = ivo.socialType
        ).apply {
            this.siteId = ivo.siteId
            this.tid = IdAndTimeUtil.generateTid()
            this.crtUserId = guser.name
            this.mdfyUserId = guser.name
            this.evnt_nm = ivo::class.simpleName
            this.crtDt = LocalDateTime.now()
        }

        return gnUsrMstrInfRepository.save(gnUsrMstrInfEntity)

    }
}