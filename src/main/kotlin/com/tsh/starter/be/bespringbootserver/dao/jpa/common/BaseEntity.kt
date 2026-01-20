package com.tsh.starter.be.bespringbootserver.dao.jpa.common

import com.tsh.starter.be.bespringbootserver.constant.UseStatCd
import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.MappedSuperclass
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseEntity {

    var siteId: String? = null

    var rsn_cd : String? = null
    var trns_cm : String? = null
    var tid : String? = null

    @Enumerated(EnumType.STRING)
    var useStatCd: UseStatCd? = null


    var crtDt: LocalDateTime? = null
    @UpdateTimestamp
    @Column(name = "mdfy_dt")
    var mdfyDt: LocalDateTime? = null

    var crtUserId: String? = null
    var mdfyUserId: String? = null


}