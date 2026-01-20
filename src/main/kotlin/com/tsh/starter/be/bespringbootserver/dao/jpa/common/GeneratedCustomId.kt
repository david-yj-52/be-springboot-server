package com.tsh.starter.be.bespringbootserver.dao.jpa.common

import org.hibernate.annotations.IdGeneratorType

@IdGeneratorType(CustomIdGenerator::class)
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD, AnnotationTarget.PROPERTY)
annotation class GeneratedCustomId
