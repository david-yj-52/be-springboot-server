package com.tsh.starter.be.bespringbootserver.dao.jpa.gnDplyFileInf.entity

import com.tsh.starter.be.bespringbootserver.constant.ApTableName
import com.tsh.starter.be.bespringbootserver.constant.UserOsType
import com.tsh.starter.be.bespringbootserver.dao.jpa.common.BaseEntity
import com.tsh.starter.be.bespringbootserver.dao.jpa.common.CustomIdGenerator
import com.tsh.starter.be.bespringbootserver.dao.jpa.common.GeneratedCustomId
import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator

@Entity
@Table(
    name = ApTableName.GH_DPLY_FILE_INF, schema = ApTableName.SCHEMA
)
class GhDplyFileInfEntity(

    @Id
    @GeneratedCustomId
    @GeneratedValue(generator = "custom-id-gen")
    @GenericGenerator(
        name = "cutom-id-gen",
        type = CustomIdGenerator::class
    )
    var objId: String? = null,
    var refObjId: String? = null,
    var apGrpNm: String? = null,
    var apNm: String? = null,
    var apVersion: String? = null,

    @Enumerated(EnumType.STRING)
    var osTyp: UserOsType? = null,
    var filePath: String? = null,


    ) : BaseEntity()