/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.Department;
import model.Employee;
import model.ManagerType;

/**
 *
 * @author Ruggery
 */


/* Builds a complete Employee from the three things the user types (name,
manager type, department). The other fields get sensible values.*/
public class EmployeeFactory {

    private static final String ID_PREFIX = "ER";
    private static final String EMAIL_DOMAIN = "emeraldrow.example";
    private static final String DEFAULT_BRANCH = "Dublin";

    // fullName must already be validated: at least two words.
    public static Employee createNew(List<Employee> existing, String fullName,
            ManagerType managerType, Department department) {
        int firstSpace = fullName.indexOf(' ');
        String firstName = fullName.substring(0, firstSpace);
        String lastName = fullName.substring(firstSpace + 1);

        return new Employee(
                nextId(existing),
                firstName,
                lastName,
                buildEmail(firstName, lastName),
                department,
                managerType,
                managerType.getLabel(),
                DEFAULT_BRANCH);
    }

    // Highest existing number + 1, so IDs never repeat (ER040 -> ER041).
    private static String nextId(List<Employee> existing) {
        int highest = 0;
        for (Employee employee : existing) {
            String id = employee.getEmployeeId();
            if (id.startsWith(ID_PREFIX)) {
                try {
                    highest = Math.max(highest, Integer.parseInt(id.substring(ID_PREFIX.length())));
                } catch (NumberFormatException e) {
                    // an ID that does not follow the pattern is simply ignored
                }
            }
        }
        return ID_PREFIX + String.format("%03d", highest + 1);
    }

    private static String buildEmail(String firstName, String lastName) {
        String local = (firstName + "." + lastName).toLowerCase().replaceAll("[^a-z.]", "");
        return local + "@" + EMAIL_DOMAIN;
    }
}
