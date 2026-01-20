package com.tsh.starter.be.bespringbootserver.util

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

object IdAndTimeUtil {

    fun generateTid(): String {
        return "TID" + "-" + IdAndTimeUtil.generateTimestampMillis()
    }

    fun generateUuid(prefix: String, length: Int): String {
        return prefix + "-" + UUID.randomUUID().toString().replace("-", "").take(length)
    }

    fun generateTimestampMillis(): String {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"))
    }
}
