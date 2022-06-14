package com.company.TestManager;

import com.company.constants.ANSI;

// class chứa các phương thức thường dùng để thực hiện việc giả định
public class AssertionManager {
    private final String expectation;
    private Boolean check;

    public AssertionManager(String expectation) {
        this.expectation = expectation;
        this.check = true;
    }

    public <T> void assertEquals(T t1, T t2) {
        if (!this.check) return;
        this.check = (t1 == null && t2 == null) || (t1 != null && t1.equals(t2));
    }

    public <T> void assertNotEquals(T t1, T t2) {
        if (!this.check) return;
        this.check = (t1 == null && t2 != null) || (t1 != null && !t1.equals(t2));
    }

    public <T1, T2> void assertInstanceOf(T1 t1, Class<T2> cl) {
        if (!this.check) return;
        this.check = t1 != null && t1.getClass() == cl;
    }

    public void assertBoolean(Boolean a) {
        if (!this.check) return;
        this.check = a;
    }

    public boolean judge() {
        if (check) {
            notifyTestPassed();
            return true;
        }
        notifyTestFailed();
        return false;
    }

    public void forceFail() {
        this.check = false;
    }

    private void notifyTestPassed() {
        System.out.println(ANSI.GREEN + "Unit test: " + this.expectation + " => Passed!" + ANSI.RESET);
    }

    private void notifyTestFailed() {
        System.out.println(ANSI.RED + "Unit test: " + this.expectation + " => Failed!" + ANSI.RESET);
    }
}
