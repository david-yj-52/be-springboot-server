package com.tsh.starter.be.bespringbootserver.dao.jpa.common

import com.tsh.starter.be.bespringbootserver.util.IdAndTimeUtil
import org.hibernate.engine.spi.SharedSessionContractImplementor
import org.hibernate.id.IdentifierGenerator
import java.io.Serializable

class CustomIdGenerator : IdentifierGenerator {
    override fun generate(
        session: SharedSessionContractImplementor,
        obj: Any
    ): Serializable {
        return IdAndTimeUtil.generateUuid("OBJ", 50)
    }
}