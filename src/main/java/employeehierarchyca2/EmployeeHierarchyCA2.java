/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package employeehierarchyca2;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import model.Department;
import model.Employee;
import model.ManagerType;
import service.FileLoader;

/**
 *
 * @author Ruggery
 */
public class EmployeeHierarchyCA2 {

    public static void main(String[] args) throws IOException {
        //just testing the methods.
        System.out.println(ManagerType.fromLabel("Team Lead"));
        System.out.println(ManagerType.fromLabel("  team lead "));
        System.out.println(ManagerType.fromLabel("Team Leed"));

        System.out.println("===================");
        System.out.println(Department.fromLabel("Electronics"));
        System.out.println(Department.fromLabel(" human resources "));
        System.out.println(Department.fromLabel("Toys"));

        //testing the employee class
        Employee employee = new Employee("E01", "Cian", "O'Brien", "cian@email", Department.ELECTRONICS,
                ManagerType.TEAM_LEAD, "Eletronic", "branch");

        System.out.println(employee);

        //testing split
        String test = "ER002,Cian,O'Brien,cian.obrien@emeraldrow.example,Electronics,Team Lead,Electronics Team Lead,Cork";
        String test2 = "ER002,Cian,O'Brien,cian.obrien@emeraldrow.example,Electronic,Team Lead,Electronics Team Lead,Cork";
        String test3 = "ER002,Cian,O'Brien,cian.obrien@emeraldrow.example,Electronics";
        String[] pieces = test.split(",", -1); //-1 will tell java to considere the empty spaces between the comma

        for (int i = 0; i < pieces.length; i++) {
            System.out.println(i + ": " + pieces[i]);
        }
        //return the label for the value if exist
        Optional<Department> department = Department.fromLabel(pieces[4]);
        Optional<ManagerType> managerType = ManagerType.fromLabel(pieces[5]);

        Optional<Employee> file = FileLoader.parseEmployee(test);
        System.out.println(file);
        System.out.println(FileLoader.parseEmployee(test2));
        System.out.println(FileLoader.parseEmployee(test3));

        List<Employee> e = FileLoader.loadEmployees("Applicants_Form.txt");
        System.out.println(e.size());
        for (Employee employees : e) {
            System.out.println(employees);
        }
        //System.out.println(FileLoader.loadEmployees("Applicants_Form.txt"));
        //testing the print to see the results
//        System.out.println(department);
//        System.out.println(managerType);
//        if (department.isPresent() && managerType.isPresent()) {
//            Optional<Employee> file = FileLoader.parseLine(test);
//            System.out.println(file);
//        } else {
//            if (department.isEmpty()) {
//                System.out.println("department cant be found.");
//            } else {
//                System.out.println("manager type cant be found.");
//            }
//        }

    }
}
