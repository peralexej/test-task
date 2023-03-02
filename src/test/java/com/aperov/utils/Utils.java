package com.aperov.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class Utils {
    public static String getRandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

}
