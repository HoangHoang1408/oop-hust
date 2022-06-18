package com.company.TestManager;

import com.company.BaseURL;
import com.company.constants.ANSI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


// chứa các thuộc tính và phương thức cần cho 1 test để chạy (các class test khác phải kế thừa class này)
public abstract class Test {
    protected String apiName;
    protected BaseURL baseURLString;
    protected String fullURLString; //nên lưu ý thuộc tính này để gửi request nếu url cần phải bổ sung thêm route nhỏ (giá trị ví dụ: https://auctions-app-2.herokuapp.com/api/login)
    protected ArrayList<UnitTest> unitTests;

    public Test(BaseURL baseURLString, String apiName) {
        this.baseURLString = baseURLString;
        this.apiName = apiName;
        this.fullURLString = baseURLString.getBaseURL() + '/' + apiName;
        this.unitTests = new ArrayList<>();
    }

    protected void startTest() throws IOException {
        beforeAll();
        initUnitTests();
        introduceUnitTests();
        if (this.unitTests.size() <= 0) {
            System.out.println(ANSI.YELLOW + "This api has no test" + ANSI.RESET);
            return;
        }
        executeUnitTests();
    }

    //  phương thức này phải đc ghi đề ở class con
    protected abstract void initUnitTests();

    protected void beforeAll() throws IOException {
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

    private void executeUnitTests() throws IOException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> chosenUnitTestList = new ArrayList<>();
        System.out.println("Input unit tests to start testing (end with -1) or 0 to test all:");
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
        System.out.println(ANSI.YELLOW + "\nTesting for " + this.apiName + " api..." + ANSI.RESET);
        int totalTestsPassed = 0;
        ArrayList<String> failedTestList = new ArrayList<>();
        for (Integer testId : chosenUnitTestList) {
            UnitTest unitTest = this.unitTests.get(testId - 1);
            try {
                unitTest.test();
            } catch (NullPointerException e) {
                unitTest.forceFail();
            }
            if (unitTest.judge(testId)) {
                totalTestsPassed += 1;
            } else {
                failedTestList.add(testId.toString());
            }
        }
        String color = totalTestsPassed == chosenUnitTestList.size() ? ANSI.GREEN : ANSI.RED;
        System.out.println("\n" + color + "Finished: " + totalTestsPassed + "/" + chosenUnitTestList.size() + " tests passed!" + ANSI.RESET);
        if (failedTestList.size() <= 0) return;
        System.out.println(ANSI.RED + (failedTestList.size() != 1 ? "Failed tests: " : "Failed test: ") + String.join(", ", failedTestList) + ANSI.RESET);
    }

    public String getFullURLString() {
        return fullURLString;
    }

    public String getBaseUrlString() {
        return baseURLString.getBaseURL();
    }
}
