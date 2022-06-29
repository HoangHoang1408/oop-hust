package com.company.TestManager;

import com.company.constants.ANSI;

import java.util.Arrays;

// class chứa các phương thức thường dùng để thực hiện việc giả định
public class Assertion {
    private final String expectation;
    private final String defaultFailMessage = "Assertion failed error";
    private AssertionError assertionError;
    private Boolean check;
    private String expected;
    private String actual;

    public Assertion(String expectation) {
        this.expectation = expectation;
        this.check = true;
        assertionError = null;
    }

    public <T> void assertEquals(T t1, T t2) {
        assertEquals(t1, t2, defaultFailMessage);
    }

    public <T> void assertEquals(T t1, T t2, String failMessage) {
        if (!this.check) return;
        try {
            assert (t1 == null && t2 == null) || (t1 != null && t1.equals(t2)) : failMessage;
        } catch (AssertionError e) {
            setExpectedAndActual(t2, t1);
            this.assertionError = e;
            this.check = false;
        }
    }

    public <T> void assertNotEquals(T t1, T t2) {
        assertNotEquals(t1, t2, defaultFailMessage);
    }

    public <T> void assertNotEquals(T t1, T t2, String failMessage) {
        if (!this.check) return;
        try {
            assert (t1 == null && t2 != null) || (t1 != null && !t1.equals(t2)) : failMessage;
        } catch (AssertionError e) {
            this.setExpectedAndActual(t2, t1);
            this.assertionError = e;
            this.check = false;
        }
    }

    public <T1, T2> void assertInstanceOf(T1 t1, Class<T2> cl) {
        assertInstanceOf(t1, cl, defaultFailMessage);
    }

    public <T1, T2> void assertInstanceOf(T1 t1, Class<T2> cl, String failMessage) {
        if (!this.check) return;
        try {
            assert t1 != null && t1.getClass() == cl : failMessage;
        } catch (AssertionError e) {
            this.setExpectedAndActual(cl, t1);
            e.printStackTrace();
            this.assertionError = e;
            this.check = false;
        }
    }

    public void assertTrue(Boolean a) {
        assertTrue(a, defaultFailMessage);
    }

    public void assertTrue(Boolean a, String failMessage) {
        if (!this.check) return;
        try {
            assert a : failMessage;
        } catch (AssertionError e) {
            this.setExpectedAndActual(true, false);
            this.assertionError = e;
            this.check = false;
        }
    }

    public boolean judge(int i) {
        if (check) {
            notifyTestPassed(i);
            return true;
        }
        notifyTestFailed(i);
        printExpectedAndActual();
        printStackTrace();
        return false;
    }

    public void forceFail() {
        this.check = false;
    }

    private <T1, T2> void setExpectedAndActual(T1 expected, T2 actual) {
        this.expected = (String) expected;
        this.actual = (String) actual;
    }

    private void printExpectedAndActual() {
        System.out.println("\tExpected value: " + ANSI.RED + this.expected + ANSI.RESET);
        System.out.println("\tActual value: " + ANSI.RED + this.actual + ANSI.RESET);
        System.out.println();
    }

    private void printStackTrace() {
        StackTraceElement[] stackTraceElements = this.assertionError.getStackTrace();
        System.out.print(ANSI.SINGLE_TAB + this.assertionError.getMessage() + " at:");
        System.out.println(ANSI.RED);
        Arrays.stream(stackTraceElements, 2, stackTraceElements.length).forEach(e -> System.out.println(ANSI.DOUBLE_TAB + e));
        System.out.println(ANSI.RESET);
    }

    private void notifyTestPassed(int i) {
        System.out.println(ANSI.GREEN + i + ") " + this.expectation + " => Passed!" + ANSI.RESET);
    }

    private void notifyTestFailed(int i) {
        System.out.println(ANSI.RED + i + ") " + this.expectation + " => Failed!" + ANSI.RESET);
    }
}
