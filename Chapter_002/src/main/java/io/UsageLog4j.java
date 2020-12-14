package io;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class UsageLog4j {

    public static final Logger LOG = LogManager.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.info("info message");
        LOG.warn("warning message");
        LOG.error("error message");
    }
}
