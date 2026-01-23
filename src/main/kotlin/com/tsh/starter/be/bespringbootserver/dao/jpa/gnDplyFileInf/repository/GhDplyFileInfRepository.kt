package com.tsh.starter.be.bespringbootserver.dao.jpa.gnDplyFileInf.repository

import com.tsh.starter.be.bespringbootserver.dao.jpa.gnDplyFileInf.entity.GhDplyFileInfEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GhDplyFileInfRepository : JpaRepository<GhDplyFileInfEntity, String> {

}