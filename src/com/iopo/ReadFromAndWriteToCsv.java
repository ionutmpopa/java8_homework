package com.iopo;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadFromAndWriteToCsv {

	private Employee employee;

	public Employee getEmployee() {
		return employee;
	}

	public List<Employee> readFromFileAndPassResultsToList(String fileToBeParsed, int myArg,
			boolean headerTrueOrFalse) {

		List<Employee> myEmList = new ArrayList<>();
		Path theFile = Paths.get(fileToBeParsed);

		Charset charset = Charset.forName("UTF-8");
		try (BufferedReader reader = Files.newBufferedReader(theFile, charset)) {

			String line;
			int iteration = 0;
			while ((line = reader.readLine()) != null) {
				// Here we make sure that, when there's a header, it will not be
				// taken into consideration.
				if (headerTrueOrFalse) {
					if (iteration == 0) {
						iteration++;
						continue;
					}
				}
				List<Employee> myEmp = buildEmployeeList(line, myArg);
				myEmList.addAll(myEmp);
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		return myEmList;
	}

	public List<Employee> buildEmployeeList(String expression, int searchedMonth) {

		String[] myFirstSplit = expression.split("\n");

		for (String myLine : myFirstSplit) {

			String[] mySecondSplit = myLine.split(",");
			String getSubstring = mySecondSplit[2].substring(mySecondSplit[2].indexOf("-") + 1,
					mySecondSplit[2].indexOf("-") + 3);
			Integer myConvertedValue = Integer.parseInt(getSubstring);

			employee = new Employee(mySecondSplit[0], mySecondSplit[1], myConvertedValue);

			List<Employee> finalList = Stream.of(employee).filter(employee -> {
				if (employee.getMonthDateOfBirth() == searchedMonth) {
					return true;
				}
				return false;
			}).collect(Collectors.toList());
			return finalList;
		}
		return null;
	}

	public void orderNamesAndWriteToFile(List<Employee> input, String output) {

		Writer writer = null;

		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output), "UTF-8"));
			Collections.sort(input, Comparator.comparing(Employee::getFirstName));

			for (Employee myEmployee : input) {
				System.out.println(myEmployee);
				writer.write(myEmployee + "\n");
			}
		} catch (IOException e) {
			e.getStackTrace();
		} finally {
			try {
				writer.close();
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
	}
}
