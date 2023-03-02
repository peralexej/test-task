package com.aperov.Utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

public class Utils {
    public static String getRandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

}
