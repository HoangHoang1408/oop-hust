package com.company.TestManager;

import com.company.constants.ANSI;

import java.util.Arrays;

// class chứa các phương thức thường dùng để thực hiện việc giả định
public class Assertion {
    private final String defaultFailMessage = "Assertion failed error";
    private AssertionError assertionError;
    private Boolean pass;
    private String expected;
    private String actual;

    public Assertion() {
        this.pass = true;
        this.assertionError = null;
        this.expected = null;
        this.actual = null;
    }

    public <T> void assertEquals(T t1, T t2) {
        assertEquals(t1, t2, defaultFailMessage);
    }

    public <T> void assertEquals(T t1, T t2, String failMessage) {
        if (!this.pass) return;
        try {
            assert (t1 == null && t2 == null) || (t1 != null && t1.equals(t2)) : failMessage;
        } catch (AssertionError e) {
            setExpectedAndActual(t2, t1);
            this.assertionError = e;
            this.pass = false;
        }
    }

    public <T> void assertNotEquals(T t1, T t2) {
        assertNotEquals(t1, t2, defaultFailMessage);
    }

    public <T> void assertNotEquals(T t1, T t2, String failMessage) {
        if (!this.pass) return;
        try {
            assert (t1 == null && t2 != null) || (t1 != null && !t1.equals(t2)) : failMessage;
        } catch (AssertionError e) {
            this.setExpectedAndActual(t2, t1);
            this.assertionError = e;
            this.pass = false;
        }
    }

    public <T1, T2> void assertInstanceOf(T1 t1, Class<T2> cl) {
        assertInstanceOf(t1, cl, defaultFailMessage);
    }

    public <T1, T2> void assertInstanceOf(T1 t1, Class<T2> cl, String failMessage) {
        if (!this.pass) return;
        try {
            assert t1 != null && t1.getClass() == cl : failMessage;
        } catch (AssertionError e) {
            this.setExpectedAndActual(cl, t1);
            e.printStackTrace();
            this.assertionError = e;
            this.pass = false;
        }
    }

    public void assertTrue(Boolean a) {
        assertTrue(a, defaultFailMessage);
    }

    public void assertTrue(Boolean a, String failMessage) {
        if (!this.pass) return;
        try {
            assert a : failMessage;
        } catch (AssertionError e) {
            this.setExpectedAndActual(true, false);
            this.assertionError = e;
            this.pass = false;
        }
    }

    public boolean judge() {
        return pass;
    }

    public void forceFail() {
        this.pass = false;
    }

    public void printJudgement() {
        if (assertionError == null) return;
        printExpectedAndActual();
        printStackTrace();
        System.out.println(ANSI.SINGLE_TAB + "--------------------------------------------------------------------------------------------------------------------------------------\n");
    }

    private <T1, T2> void setExpectedAndActual(T1 expected, T2 actual) {
        this.expected = (String) expected;
        this.actual = (String) actual;
    }

    private void printExpectedAndActual() {
        System.out.println(ANSI.DOUBLE_TAB + "Expected value: " + ANSI.RED + this.expected + ANSI.RESET);
        System.out.println(ANSI.DOUBLE_TAB + "Actual value: " + ANSI.RED + this.actual + ANSI.RESET);
        System.out.println();
    }

    private void printStackTrace() {
        StackTraceElement[] stackTraceElements = this.assertionError.getStackTrace();
        System.out.println(ANSI.DOUBLE_TAB + this.assertionError.getMessage() + " at:");
        System.out.print(ANSI.RED);
        Arrays.stream(stackTraceElements, this.assertionError.getMessage().equals(this.defaultFailMessage) ? 2 : 1, stackTraceElements.length).forEach(e -> System.out.println(ANSI.TRIPLE_TAB + e));
        System.out.print(ANSI.RESET);
    }
}
