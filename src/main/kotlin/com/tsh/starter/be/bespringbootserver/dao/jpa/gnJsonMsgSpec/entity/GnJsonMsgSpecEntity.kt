package com.tsh.starter.be.bespringbootserver.dao.jpa.gnJsonMsgSpec.entity

import com.tsh.starter.be.bespringbootserver.constant.ApTableName
import com.tsh.starter.be.bespringbootserver.dao.jpa.common.BaseEntity
import com.tsh.starter.be.bespringbootserver.dao.jpa.common.GeneratedCustomId
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint

@Entity
@Table(name = ApTableName.GN_JSON_MSG_SPEC,
    schema = "public",
    uniqueConstraints = [UniqueConstraint(name = "uk_gn_json_msg_spec_01", columnNames = ["msg_nm", "element_nm"])]
    )
class GnJsonMsgSpecEntity(

    @Id
    @GeneratedCustomId
    var objId: String? = null,

    var srv_nm : String? = null,
    var msg_nm : String? = null,
    var element_nm : String? = null,
    var data_typ : String? = null,
    var prnt_element : String? = null,
    var description: String? = null,
    var sample_val: String? = null

): BaseEntity()