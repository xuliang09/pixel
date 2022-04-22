package com.aliyun.pixel.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author shuixu.xl
 * @version 1.0
 * @date 2022/3/27
 * @description 无法识别logback.spring.xml
 */
public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Example log from {}", Main.class.getSimpleName());
        logger.debug("Example log from {}", Main.class.getSimpleName());
        logger.warn("Example log from {}", Main.class.getSimpleName());
        logger.error("Example log from {}", Main.class.getSimpleName());
        logger.trace("Example log from {}", Main.class.getSimpleName());
    }
}
