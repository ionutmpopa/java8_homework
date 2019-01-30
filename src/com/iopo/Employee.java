package com.iopo;

import java.util.Objects;

public class Employee implements Comparable<Employee> {
    private String firstName;
    private String lastName;
    private int monthDateOfBirth;

    public Employee(String firstName, String lastName, int monthDateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.monthDateOfBirth = monthDateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getMonthDateOfBirth() {
        return monthDateOfBirth;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return monthDateOfBirth == employee.monthDateOfBirth &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, monthDateOfBirth);
    }

    @Override
    public int compareTo(Employee e) {

        int result = getMonthDateOfBirth() - e.getMonthDateOfBirth();

        if (result < 0) {
            return 1;
        } else if (result > 0) {
            return -1;
        } else {
            return 0;
        }
    }
}
