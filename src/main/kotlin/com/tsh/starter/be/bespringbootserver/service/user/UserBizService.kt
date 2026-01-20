package com.tsh.starter.be.bespringbootserver.service.user

import com.tsh.starter.be.bespringbootserver.dao.jpa.gnUsrMstrInf.entity.GnUsrMstrInfEntity
import com.tsh.starter.be.bespringbootserver.dao.jpa.gnUsrMstrInf.service.GnUsrMstrInfJpaService
import com.tsh.starter.be.bespringbootserver.model.intf.`in`.NewUserAddReqIvo
import mu.KotlinLogging
import org.springframework.stereotype.Service

private val logger = KotlinLogging.logger {}

@Service
class UserBizService(private val gnUsrMstrInfJpaService: GnUsrMstrInfJpaService) {

    fun welcomeToNewUser(ivo: NewUserAddReqIvo): GnUsrMstrInfEntity? {
        logger.info("siteId:{}, userKey:{}", ivo.siteId, ivo.userKey)

        return try {
            val user = this.fetchUser(ivo.siteId, ivo.userKey)
            if (user != null) {
                logger.warn("Existing user add again userKey:{}", ivo.userKey)
                return user
            }

            val newUser = gnUsrMstrInfJpaService.saveNewUser(ivo)
            return newUser
            
        } catch (e: Exception) {
            logger.error(e) { "Failed to add user add again userKey:{}" }
            null
        }

    }

    fun fetchUser(siteId: String, userKey: String): GnUsrMstrInfEntity? {
        try {
            val user = gnUsrMstrInfJpaService.findByUserKey(siteId, userKey)
            return user

        } catch (e: Exception) {
            logger.error(e) { "Failed to find user key:{}" }
            return null
        }
    }
}