package com.log;

import org.apache.log4j.Logger;

public class Logging {

    static final Logger logger = Logger.getLogger("Logging.class");

    public static void main(String[] args) {
        logger.debug("Debug Log Deneme");
        logger.info("İnfo Log Deneme");
        logger.warn("Warn Log Deneme");
        logger.error("Error Log Deneme");
        logger.fatal("Fatal Log Deneme");
    }

}
