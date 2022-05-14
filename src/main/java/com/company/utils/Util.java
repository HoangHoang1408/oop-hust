package com.company.utils;

import java.util.Random;

public class Util {
    public static void main(String[] args) {
        System.out.println(randomNumberString(10));
    }

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

    public static String randomNumberString(int length) {
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomLimitedInt = (int) (random.nextFloat() * (10));
            buffer.append(randomLimitedInt);
        }
        return buffer.toString();
    }
}
