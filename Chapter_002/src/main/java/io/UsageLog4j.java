package io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    public static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        int i = 35;
        byte b = 24;
        short sh = 7;
        float f = 33.3f;
        boolean isTrue = true;
        double d = 3.14;
        char ch = 'X';
        long l = 100500L;
        LOG.debug("int={}, byte={}, short={}, float={}, boolean={}, double={}, char={}, long={}",
                i, b, sh, f, isTrue, d, ch, l);

    }
}
