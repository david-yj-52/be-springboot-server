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

}