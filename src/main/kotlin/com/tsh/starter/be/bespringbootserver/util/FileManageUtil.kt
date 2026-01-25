package com.tsh.starter.be.bespringbootserver.util

import mu.KotlinLogging
import java.io.File

private val logger = KotlinLogging.logger {}

object FileManageUtil {

    fun fetchLocalFile(filePath: String) {
        logger.info("Fetching local file $filePath")

        File(filePath).readBytes()
    }
}