package com.company.utils;

import java.util.Random;

// chứa các hàm tiện dụng để tạo data gửi đến server
public class Util {
    public static String randomAlphabetString(int length) {
        int leftLimit = 97;
        int rightLimit = 122;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }

    public static String randomNumberString(int length, int lowerBound, int upperBound) {
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomLimitedInt = (int) (random.nextFloat() * (upperBound - lowerBound + 1)) + lowerBound;
            buffer.append(randomLimitedInt);
        }
        return buffer.toString();
    }

    public static String randomNumberString(int length) {
        return Util.randomNumberString(length, 0, 9);
    }
}
