/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Comparator;

/**
 *
 * @author Ruggery
 */
public class Employee {

    // ONE rule for ordering names, used by BOTH the sort and the search.
    // If the sort and the search used different rules, binary search would fail silently.
    public static final Comparator<String> NAME_ORDER = String.CASE_INSENSITIVE_ORDER;

    // Alphabetical order by full name ("Aoife Kelly" before "Aoife Murphy").
    public static final Comparator<Employee> BY_NAME = Comparator.comparing(Employee::getFullName, NAME_ORDER);

    // Highest rank first (Store Director ... Associate), then alphabetical.
    // ManagerType constants are declared from highest to lowest rank, so ordinal() is the rank.
    public static final Comparator<Employee> BY_RANK_THEN_NAME
            = Comparator.comparingInt((Employee e) -> e.getManagerType().ordinal())
                    .thenComparing(BY_NAME);

    //all fields to the employee being final that can not be changed after the object is created
    private final String employeeId;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final Department department;
    private final ManagerType managerType;
    private final String jobTitle;
    private final String branch;

    //constructor
    public Employee(String employeeId, String firstName, String lastName, String email,
            Department department, ManagerType managerType, String jobTitle, String branch) {

        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.department = department;
        this.managerType = managerType;
        this.jobTitle = jobTitle;
        this.branch = branch;
    }

    //getters to all fields
    public String getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Department getDepartment() {
        return department;
    }

    public ManagerType getManagerType() {
        return managerType;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getBranch() {
        return branch;
    }

    // The key that the sort and the search both use.
    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return getFullName() + " | " + managerType + " | " + department;
    }

}
