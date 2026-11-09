/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Ruggery
 */
public class Employee {
    
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
            Department department, ManagerType managerType, String jobTitle, String branch){
        
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
    public String getEmployeeId(){
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
    
    @Override
    public String toString(){
        return firstName + " " + lastName + " | " + managerType + " | " + department;
    }
    
    
}
