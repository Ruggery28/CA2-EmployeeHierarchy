/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import model.Department;
import model.Employee;
import model.ManagerType;

/**
 *
 * @author Ruggery
 */
public class FileLoader {

    public static Optional<Employee> parseEmployee(String line) {
        //it will split the line by comma and consider the empty ones.
        String[] splitLine = line.split(",", -1);
        //if the content of line is not 8, we return an empty Optional.
        if (splitLine.length != 8) {
            return Optional.empty();
        }
        Optional<Department> department = Department.fromLabel(splitLine[4]);
        Optional<ManagerType> managerType = ManagerType.fromLabel(splitLine[5]);
        if (department.isPresent() && managerType.isPresent()) {
            return Optional.of(new Employee(splitLine[0], splitLine[1], splitLine[2], splitLine[3], department.get(), managerType.get(), splitLine[6], splitLine[7]));
        }
        return Optional.empty();
    }

    public static List<Employee> loadEmployees(String fileName) throws IOException {
        //Reads all the files and set them into a List
        List<String> lines = Files.readAllLines(Path.of(fileName));
        List<Employee> employees = new ArrayList<>();

        for (int i = 1; i < lines.size(); i++) {
            //store each line inside a single String
            String line = lines.get(i);
            //if the line is blank, continue will run and skip the rest of the code
            if (line.isBlank()) {
                continue;
            }
            //if the line contain a value I will check if it matchs our requirement 
            Optional<Employee> results = parseEmployee(line);
            //if so I will check if its not empty(all department and managerType is right
            if (results.isPresent()) {
                employees.add(results.get());
            }
        }
        return employees;
    }

}
