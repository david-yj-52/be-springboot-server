package com.tsh.starter.be.bespringbootserver.dao.jpa.common

import com.tsh.starter.be.bespringbootserver.constant.UseStatCd
import jakarta.persistence.*
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseEntity {

    var siteId: String? = null

    var evnt_nm: String? = null
    var prv_evnt_nm: String? = null
    var act_rsn_cd: String? = null
    var act_cm: String? = null
    var tid: String? = null

    @Enumerated(EnumType.STRING)
    var useStatCd: UseStatCd? = null


    var crtDt: LocalDateTime? = null

    @UpdateTimestamp
    @Column(name = "mdfy_dt")
    var mdfyDt: LocalDateTime? = null

    var crtUserId: String? = null
    var mdfyUserId: String? = null

    fun <T : BaseEntity> T.copyBaseFieldsFrom(source: BaseEntity): T {
        this.siteId = source.siteId
        this.evnt_nm = source.evnt_nm
        this.prv_evnt_nm = source.prv_evnt_nm
        this.act_rsn_cd = source.act_rsn_cd
        this.act_cm = source.act_cm
        this.tid = source.tid
        this.useStatCd = source.useStatCd
        this.crtDt = source.crtDt
        this.mdfyDt = source.mdfyDt
        this.crtUserId = source.crtUserId
        this.mdfyUserId = source.mdfyUserId
        return this
    }
    
}