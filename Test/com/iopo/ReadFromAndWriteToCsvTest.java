package com.iopo;

import org.junit.*;

import com.iopo.ReadFromAndWriteToCsv;

import static junit.framework.Assert.assertEquals;


public class ReadFromAndWriteToCsvTest {

    private ReadFromAndWriteToCsv myReadAndWrite;

    @Before
    public void setup() {
        System.out.println("Testing ...");
        myReadAndWrite = new ReadFromAndWriteToCsv();
    }

    @Test
    public void testWhenBuildEmployeeListRetrieveFirstAndLastName() {
        myReadAndWrite.buildEmployeeList(EmployeeForTest.EMPLOYEE1.replaceAll("\\s+", ""), 12);
        assertEquals("Jimmy Roland", myReadAndWrite.getEmployee().toString());
    }

    @Test
    public void testWhenBuildEmployeeListRetrieveFirstAndLastNameTwo() {
        myReadAndWrite.buildEmployeeList(EmployeeForTest.EMPLOYEE2.replaceAll("\\s+", ""), 10);
        assertEquals("Bruce Logan", myReadAndWrite.getEmployee().toString());
    }

    @Test
    public void testWhenBuildEmployeeListRetrieveFirstAndLastNameThree() {
        myReadAndWrite.buildEmployeeList(EmployeeForTest.EMPLOYEE3.replaceAll("\\s+", ""), 7);
        assertEquals("Timmy Rogers", myReadAndWrite.getEmployee().toString());
    }

    @Test
    public void testWhenBuildEmployeeListRetrieveFirstAndLastNameFour() {
        myReadAndWrite.buildEmployeeList(EmployeeForTest.EMPLOYEE4.replaceAll("\\s+", ""), 11);
        assertEquals("Michael Red", myReadAndWrite.getEmployee().toString());
    }

    @Test
    public void testWhenBuildEmployeeListRetrieveFirstAndLastNameFive() {
        myReadAndWrite.buildEmployeeList(EmployeeForTest.EMPLOYEE6.replaceAll("\\s+", ""), 10);
        assertEquals("Paul Alan", myReadAndWrite.getEmployee().toString());
    }

    @Test
    public void testWhenBuildEmployeeListRetrieveFirstAndLastNameSix() {
        myReadAndWrite.buildEmployeeList(EmployeeForTest.EMPLOYEE5.replaceAll("\\s+", ""), 3);
        assertEquals("Steve Podgorsky", myReadAndWrite.getEmployee().toString());
    }

    @Test
    public void testWhenBuildEmployeeListRetrieveFirstAndLastNameSeven() {
        myReadAndWrite.buildEmployeeList(EmployeeForTest.EMPLOYEE7.replaceAll("\\s+", ""), 2);
        assertEquals("John Doe", myReadAndWrite.getEmployee().toString());
    }

    @Test
    public void testWhenBuildEmployeeListRetrieveCorrectMonth() {
        myReadAndWrite.buildEmployeeList(EmployeeForTest.EMPLOYEE7.replaceAll("\\s+", ""), 2);
        assertEquals(2, myReadAndWrite.getEmployee().getMonthDateOfBirth());
    }

    @Test
    public void testWhenBuildEmployeeListRetrieveCorrectMonthTwo() {
        myReadAndWrite.buildEmployeeList(EmployeeForTest.EMPLOYEE6.replaceAll("\\s+", ""), 10);
        assertEquals(10, myReadAndWrite.getEmployee().getMonthDateOfBirth());
    }
    
    @Test
    public void testWhenBuildEmployeeListRetrieveCorrectMonthThree() {
        myReadAndWrite.buildEmployeeList(EmployeeForTest.EMPLOYEE5.replaceAll("\\s+", ""), 3);
        assertEquals(3, myReadAndWrite.getEmployee().getMonthDateOfBirth());
    }
    
    @Test
    public void testWhenBuildEmployeeListRetrieveCorrectMonthFour() {
        myReadAndWrite.buildEmployeeList(EmployeeForTest.EMPLOYEE4.replaceAll("\\s+", ""), 11);
        assertEquals(11, myReadAndWrite.getEmployee().getMonthDateOfBirth());
    }
    
    @Test
    public void testWhenBuildEmployeeListRetrieveCorrectMonthFive() {
        myReadAndWrite.buildEmployeeList(EmployeeForTest.EMPLOYEE3.replaceAll("\\s+", ""), 7);
        assertEquals(7, myReadAndWrite.getEmployee().getMonthDateOfBirth());
    }
    
    @Test
    public void testWhenBuildEmployeeListRetrieveCorrectMonthSix() {
        myReadAndWrite.buildEmployeeList(EmployeeForTest.EMPLOYEE2.replaceAll("\\s+", ""), 10);
        assertEquals(10, myReadAndWrite.getEmployee().getMonthDateOfBirth());
    }
    
    @Test
    public void testWhenBuildEmployeeListRetrieveCorrectMonthSeven() {
        myReadAndWrite.buildEmployeeList(EmployeeForTest.EMPLOYEE1.replaceAll("\\s+", ""), 12);
        assertEquals(12, myReadAndWrite.getEmployee().getMonthDateOfBirth());
    }

}