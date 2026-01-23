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
    name = ApTableName.GN_DPLY_FILE_INF, schema = ApTableName.SCHEMA, uniqueConstraints = [
        UniqueConstraint(name = "UK_GN_DPLY_FILE_INF_01", columnNames = ["SITE_ID", "AP_NM", "AP_VERSION", "OS_TYP"])]
)
class GnDplyFileInfEntity(

    @Id
    @GeneratedCustomId
    @GeneratedValue(generator = "custom-id-gen")
    @GenericGenerator(
        name = "cutom-id-gen",
        type = CustomIdGenerator::class
    )
    var objId: String? = null,
    var apGrpNm: String? = null,
    var apNm: String? = null,
    var apVersion: String? = null,

    @Enumerated(EnumType.STRING)
    var osTyp: UserOsType? = null,
    var filePath: String? = null,


    ) : BaseEntity() {

    fun toHistory(): GhDplyFileInfEntity {
        return GhDplyFileInfEntity(
            objId = null,
            refObjId = this.objId,
            apGrpNm = this.apGrpNm,
            apNm = this.apNm,
            apVersion = this.apVersion,
            osTyp = this.osTyp,
            filePath = this.filePath,
        ).copyBaseFieldsFrom(this)
    }
}