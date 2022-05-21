package com.company.Tests;

import com.company.BaseURL;
import com.company.constants.ANSI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Test {
    protected String apiName;
    protected BaseURL baseURL;
    protected String fullURLString;
    protected ArrayList<UnitTest> unitTests;

    public Test(BaseURL baseURL, String apiName) {
        this.baseURL = baseURL;
        this.apiName = apiName;
        this.fullURLString = baseURL.getBaseURL() + '/' + apiName;
        this.unitTests = new ArrayList<>();
    }


    protected void startTest() throws IOException {
        initUnitTests();
        introduceUnitTests();
        executeUnitTests();
    }

    protected void initUnitTests() {
    }

    private void introduceUnitTests() {
        if (unitTests.size() <= 0) return;
        System.out.print(ANSI.YELLOW);
        System.out.println("\nUnit tests for " + this.apiName + ": ");
        for (int i = 0; i < unitTests.size(); i++) {
            System.out.println("Expectation " + (i + 1) + ": " + unitTests.get(i).getExpectation());
        }
        System.out.println(ANSI.RESET);
    }

    private void executeUnitTests() throws IOException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> chosenUnitTests = new ArrayList<>();
        System.out.println("Input unit tests to start testing (end with -1):");
        while (scanner.hasNextInt()) {
            String input = scanner.next();
            if (input.equals("-1")) break;
            int temp = Integer.parseInt(input);
            if (temp > this.unitTests.size()) {
                System.out.println("Invalid unit test id");
                continue;
            }
            chosenUnitTests.add(temp);
        }
        System.out.println(ANSI.YELLOW + "\nTesting for " + this.apiName + " api..." + ANSI.RESET);
        for (int testId : chosenUnitTests) {
            this.unitTests.get(testId - 1).startUnitTest();
        }
        System.out.println(ANSI.YELLOW + "Finished..." + ANSI.RESET);
    }

    public String getFullURLString() {
        return fullURLString;
    }
}
