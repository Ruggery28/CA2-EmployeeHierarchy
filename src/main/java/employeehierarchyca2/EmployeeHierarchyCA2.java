/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package employeehierarchyca2;

import model.Department;
import model.ManagerType;

/**
 *
 * @author Ruggery
 */
public class EmployeeHierarchyCA2 {

    public static void main(String[] args) {
        //just testing the methods.
        System.out.println(ManagerType.fromLabel("Team Lead"));
        System.out.println(ManagerType.fromLabel("  team lead "));
        System.out.println(ManagerType.fromLabel("Team Leed"));

        System.out.println("===================");
        System.out.println(Department.fromLabel("Electronics"));
        System.out.println(Department.fromLabel(" human resources "));
        System.out.println(Department.fromLabel("Toys"));
    }
}
