package com.company.TestManager;

import com.company.BaseURL;
import com.company.constants.ANSI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


// chứa các thuộc tính và phương thức cần cho 1 test để chạy (các class test khác phải kế thừa class này)
public abstract class Test {
    protected String apiName;
    protected String baseURLString;
    protected String fullURLString; //nên lưu ý thuộc tính này để gửi request nếu url cần phải bổ sung thêm route nhỏ (giá trị ví dụ: https://auctions-app-2.herokuapp.com/api/login)
    protected ArrayList<UnitTest> unitTests;

    public Test(BaseURL baseURLObject, String apiName) {
        this.baseURLString = baseURLObject.getBaseURL();
        this.apiName = apiName;
        this.fullURLString = baseURLObject.getBaseURL() + '/' + apiName;
        this.unitTests = new ArrayList<>();
    }

    protected void startTest() {
        System.out.println(ANSI.YELLOW + "Preparing data for unit tests..." + ANSI.RESET);
        try {
            beforeAll();
        } catch (Exception e) {
//          TODO: need to comment out next line when finish
            System.out.println(e.getMessage());
            System.out.println(ANSI.RED + "Failed to prepare for unit tests!");
            System.out.println("Try again later" + ANSI.RESET);
            return;
        }
        initUnitTests();
        introduceUnitTests();
        if (this.unitTests.size() <= 0) {
            System.out.println(ANSI.YELLOW + "This api has no test!" + ANSI.RESET);
            return;
        }
        executeUnitTests();
        try {
            afterAll();
        } catch (Exception e) {
//          TODO: need to comment out next line when finish
            System.out.println(e.getMessage());
            System.out.println(ANSI.RED + "Failed to finish after unit tests!");
            System.out.println("Try again later" + ANSI.RESET);
        }
    }

    //  phương thức này phải đc ghi đề ở class con
    protected abstract void initUnitTests();

    protected void beforeAll() throws IOException {
    }

    protected void beforeEach() throws IOException {
    }

    protected void afterAll() throws IOException {
    }

    protected void afterEach() throws IOException {
    }

    private void introduceUnitTests() {
        if (unitTests.size() <= 0) return;
        System.out.print(ANSI.YELLOW);
        System.out.println("\nUnit tests for " + this.apiName + ": ");
        for (int i = 0; i < unitTests.size(); i++) {
            System.out.println("Unit test " + (i + 1) + ": " + unitTests.get(i).getExpectation());
        }
        System.out.println(ANSI.RESET);
    }

    private ArrayList<Integer> takeChosenUnitTestIds() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> chosenUnitTestList = new ArrayList<>();
        System.out.println("Input unit test ids to start testing (end with -1) or input 0 to test all:");
        while (scanner.hasNextInt()) {
            String input = scanner.next();
            if (input.equals("-1")) break;
            int temp = Integer.parseInt(input);
            if (temp > this.unitTests.size() || temp < -1) {
                System.out.println("Invalid unit test id");
                continue;
            }
            if (temp == 0) {
                chosenUnitTestList.clear();
                for (int i = 1; i <= this.unitTests.size(); i++) chosenUnitTestList.add(i);
                break;
            }
            chosenUnitTestList.add(temp);
        }
        return chosenUnitTestList;
    }

    private void notifyUnitTestsPassedOrFail(int totalUnitTests, ArrayList<String> failedTestList) {
        int totalTestsPassed = totalUnitTests - failedTestList.size();
        String color = totalTestsPassed == totalUnitTests ? ANSI.GREEN : ANSI.RED;
        System.out.println("\n" + color + "Total: " + totalTestsPassed + " of " + totalUnitTests + " tests passed!" + ANSI.RESET);
        if (failedTestList.size() <= 0) return;
        System.out.println(ANSI.RED + (failedTestList.size() != 1 ? "Failed tests: " : "Failed test: ") + String.join(", ", failedTestList) + ANSI.RESET);
    }

    private void executeUnitTests() {
        ArrayList<Integer> chosenUnitTestList = takeChosenUnitTestIds();
        System.out.println(ANSI.YELLOW + "\nTesting for " + this.apiName + " api..." + ANSI.RESET);
        ArrayList<String> failedTestList = new ArrayList<>();
        for (Integer testId : chosenUnitTestList) {
            UnitTest unitTest = this.unitTests.get(testId - 1);
            try {
                try {
                    beforeEach();
                } catch (IOException e) {
                    System.out.println(ANSI.RED + "Failed to prepare unit test " + testId + ANSI.RESET);
                    throw e;
                }
                unitTest.test();
                try {
                    afterEach();
                } catch (IOException e) {
                    System.out.println(ANSI.RED + "Failed to finish unit test " + testId + ANSI.RESET);
                    throw e;
                }
            } catch (NullPointerException | IOException e) {
//              TODO: need to comment out next line when finish
                if (e.getClass().equals(IOException.class)) System.out.println(e.getMessage());
                unitTest.forceFail();
            }
            if (!unitTest.judge(testId)) failedTestList.add(testId.toString());
        }
        notifyUnitTestsPassedOrFail(chosenUnitTestList.size(), failedTestList);
    }

    public String getFullURLString() {
        return fullURLString;
    }

    public String getBaseUrlString() {
        return baseURLString;
    }
}
