package pro.sky.collectionset.empl;

import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;

    public Employee(String secondName, String firstName) {
        this.firstName = firstName;
        this.lastName = secondName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "Employee: " + lastName + " " + firstName;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}