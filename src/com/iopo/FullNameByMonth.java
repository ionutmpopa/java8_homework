package com.iopo;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class FullNameByMonth {

    private static Scanner scanner = new Scanner(System.in);
    private static final String MY_INPUT_FILE = "resources" + File.separator + "employee.csv";
    private static final String MY_OUTPUT_FILE = "resources" + File.separator + "fileToWrite.csv";

    public static void main(String[] args) {

        System.out.println("Choose a month by entering a number from 1 to 12:");
        int myMonth = scanner.nextInt();
        scanner.nextLine();
        if ((myMonth >= 1) && (myMonth <= 12)) {
        	readFromFileBuildListAndWriteToFile(MY_INPUT_FILE, myMonth, MY_OUTPUT_FILE);
        } else {
        	System.out.println("The value you entered is not a valid month, try again!");
        }
    }

    public static void readFromFileBuildListAndWriteToFile (String input, int month, String output) {
    	ReadFromAndWriteToCsv readFromAndWrite = new ReadFromAndWriteToCsv();
    	List<Employee> myEmployeeList = readFromAndWrite.readFromFileAndPassResultsToList(input, month, true);
        readFromAndWrite.orderNamesAndWriteToFile(myEmployeeList, output);
    }
}
