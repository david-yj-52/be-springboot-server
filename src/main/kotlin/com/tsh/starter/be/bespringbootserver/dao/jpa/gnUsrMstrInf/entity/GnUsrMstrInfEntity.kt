package com.tsh.starter.be.bespringbootserver.dao.jpa.gnUsrMstrInf.entity

import com.tsh.starter.be.bespringbootserver.constant.*
import com.tsh.starter.be.bespringbootserver.dao.jpa.common.BaseEntity
import com.tsh.starter.be.bespringbootserver.dao.jpa.common.CustomIdGenerator
import com.tsh.starter.be.bespringbootserver.dao.jpa.common.GeneratedCustomId
import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator

@Entity
@Table(
    name = ApTableName.GN_USR_MSTR_INF, schema = "public", uniqueConstraints = [
        UniqueConstraint(name = "uk_gn_usr_mstr_inf_01", columnNames = ["site_id", "usr_key"])
    ]
)
class GnUsrMstrInfEntity(

    @Id
    @GeneratedCustomId
    @GeneratedValue(generator = "custom-id-gen")
    @GenericGenerator(
        name = "custom-id-gen",
        type = CustomIdGenerator::class
    )
    var objId: String? = null,
    var usrKey: String? = null,
    var usrNm: String? = null,

    @Enumerated(EnumType.STRING)
    var usrGrp: UserGrade? = null,

    @Enumerated(EnumType.STRING)
    var usrCate: UserCategory? = null,

    @Enumerated(EnumType.STRING)
    var socialYn: YesOrNo? = null,

    @Enumerated(EnumType.STRING)
    var socialTyp: SocialType? = null,

    ) : BaseEntity()