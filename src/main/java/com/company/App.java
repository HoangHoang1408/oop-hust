package com.company;

import com.company.Tests.TestManager;
import com.company.constants.ANSI;
import com.company.constants.Constant;

import java.util.Scanner;

// class chính chứa các hàm thực hiện luồng công việc
public class App {
    private final BaseURL baseUrl;
    private final TestManager testManager;
    private final Scanner scanner;
    private boolean running;

    public App() {
        this.scanner = new Scanner(System.in);
        this.baseUrl = new BaseURL();
        this.testManager = new TestManager();
        this.running = true;
    }

    public void start() {
        while (this.running) {
            printOption();
            switch (this.getOption("Select option (integer):")) {
                case 1 -> this.setBaseUrl();
                case 2 -> this.testAPI();
                case 3 -> this.quitApp();
            }
            int temp = this.getOption("Continue? (1|0)");
            if (temp == 0) this.quitApp();
        }
    }

    private void printOption() {
        System.out.println("\n////////////////////////////////////");
        System.out.print(ANSI.YELLOW);
        System.out.println("Options: ");
        System.out.println("1) Input Base URL");
        System.out.println("2) Test API");
        System.out.println("3) Quit");
        System.out.print(ANSI.RESET);
    }

    private int getOption(String s) {
        System.out.println("\n" + s);
        int option = this.scanner.nextInt();
        scanner.nextLine();
        return option;
    }

    private void setBaseUrl() {
        System.out.println("Input base URL (string):");
        String baseURL = scanner.nextLine();
        if (baseURL != null && !baseURL.equals("")) {
            this.baseUrl.setBaseURL(baseURL);
            System.out.println("Base ULR set!");
        } else {
            System.out.println("Will use default Base URL!");
        }
    }

    private void testAPI() {
        System.out.print(ANSI.YELLOW);
        System.out.println("\nSelect API to test: ");
        for (int i = 1; i <= Constant.paths.size(); i++) {
            System.out.println(i + ") " + Constant.testNames.get(i));
        }
        System.out.print(ANSI.RESET);
        int testId = getOption("Input api Id (integer):");
        this.testManager.startTest(Constant.paths.get(testId), this.baseUrl);
    }

    private void quitApp() {
        this.scanner.close();
        this.running = false;
        System.out.println("App quited!");
    }
}
