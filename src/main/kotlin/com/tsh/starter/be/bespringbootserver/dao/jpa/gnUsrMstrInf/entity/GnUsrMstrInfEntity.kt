package com.tsh.starter.be.bespringbootserver.dao.jpa.gnUsrMstrInf.entity

import com.tsh.starter.be.bespringbootserver.constant.ApTableName
import com.tsh.starter.be.bespringbootserver.constant.SocialType
import com.tsh.starter.be.bespringbootserver.constant.UseStatCd
import com.tsh.starter.be.bespringbootserver.constant.UserCategory
import com.tsh.starter.be.bespringbootserver.constant.UserGroup
import com.tsh.starter.be.bespringbootserver.constant.YesOrNo
import com.tsh.starter.be.bespringbootserver.dao.jpa.common.BaseEntity
import com.tsh.starter.be.bespringbootserver.dao.jpa.common.GeneratedCustomId
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint

@Entity
@Table(name = ApTableName.GN_USR_MSTR_INF, schema = "public", uniqueConstraints = [
    UniqueConstraint(name = "uk_gn_json_msg_spec_01", columnNames = [])
])
class GnUsrMstrInfEntity (

    @Id
    @GeneratedCustomId
    var objId: String? = null,
    var usrKey: String? = null,
    var usrNm: String? = null,

    @Enumerated(EnumType.STRING)
    var usrGrp : UserGroup? = null,

    @Enumerated(EnumType.STRING)
    var usrCate : UserCategory? = null,

    @Enumerated(EnumType.STRING)
    var socialYn : YesOrNo? = null,

    @Enumerated(EnumType.STRING)
    var socialTyp : SocialType? = null,

): BaseEntity()