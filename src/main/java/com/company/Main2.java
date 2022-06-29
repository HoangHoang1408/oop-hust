package com.company;

public class Main2 {
    public static void main(String[] args) {
        try {
            assert 1 > 3 : "Hello fail message";
            System.out.println("Hello");
        } catch (AssertionError e) {
            e.printStackTrace();
            System.out.println("Hello from error");
        }
        assert 1 > 3 : "Hello 2";
    }
}
