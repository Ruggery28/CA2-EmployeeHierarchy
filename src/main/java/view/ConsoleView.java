/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import model.Department;
import model.Employee;
import model.ManagerType;

/**
 *
 * @author Ruggery
 */

/* The VIEW: the only class that talks to the user (Scanner and System.out). It
shows things and reads text. It never decides what to do with the text.*/
public class ConsoleView {

    private static final String YES = "y";
    private static final String NO = "n";

    // One Scanner for the whole program (several Scanners on System.in cause trouble).
    private final Scanner scanner = new Scanner(System.in);

    // ========== generic messages ==========
    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showError(String message) {
        System.out.println("Error: " + message);
    }

    // ========== file ==========
    public String askFileName(String defaultName) {
        System.out.print("Please enter the filename to read (press Enter for " + defaultName + "): ");
        String input = scanner.nextLine().trim();
        return input.isEmpty() ? defaultName : input;
    }

    // ========== menu ==========
    public MenuOption askMenuOption() {
        while (true) {
            System.out.println();
            System.out.println("Do you wish to SORT or SEARCH:");
            for (MenuOption option : MenuOption.values()) {
                System.out.println(option.getNumber() + ". " + option.getLabel());
            }
            System.out.print("Your choice: ");

            Optional<MenuOption> choice = parseMenuChoice(scanner.nextLine().trim());
            if (choice.isPresent()) {
                return choice.get();
            }
            showError("Please enter a number between 1 and " + MenuOption.values().length + ".");
        }
    }

    private Optional<MenuOption> parseMenuChoice(String input) {
        try {
            return MenuOption.fromNumber(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    // ========== sort / search output ==========
    public void showNames(String title, List<Employee> employees, int limit) {
        System.out.println();
        System.out.println(title);
        int count = Math.min(limit, employees.size());
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + employees.get(i).getFullName());
        }
        System.out.println("(showing " + count + " of " + employees.size() + " names)");
    }

    public String askSearchName() {
        System.out.print("Enter the full name to search for (for example Aoife Murphy): ");
        return scanner.nextLine();
    }

    public void showSearchResult(Employee employee) {
        System.out.println();
        System.out.println("Employee found:");
        System.out.println("  Name:         " + employee.getFullName());
        System.out.println("  Manager type: " + employee.getManagerType());
        System.out.println("  Department:   " + employee.getDepartment());
    }

    // ========== add records ==========
    public String askNewName() {
        System.out.print("Enter the new employee's full name (first and last name): ");
        return scanner.nextLine();
    }

    public String askManagerTypeChoice() {
        System.out.println("Manager types:");
        ManagerType[] types = ManagerType.values();
        for (int i = 0; i < types.length; i++) {
            System.out.println("  " + (i + 1) + ". " + types[i].getLabel());
        }
        System.out.print("Choose a manager type (number or name): ");
        return scanner.nextLine();
    }

    public String askDepartmentChoice() {
        System.out.println("Departments:");
        Department[] departments = Department.values();
        for (int i = 0; i < departments.length; i++) {
            System.out.println("  " + (i + 1) + ". " + departments[i].getLabel());
        }
        System.out.print("Choose a department (number or name): ");
        return scanner.nextLine();
    }

    public boolean askYesNo(String question) {
        while (true) {
            System.out.print(question + " (" + YES + "/" + NO + "): ");
            String answer = scanner.nextLine().trim().toLowerCase();
            if (answer.equals(YES)) {
                return true;
            }
            if (answer.equals(NO)) {
                return false;
            }
            showError("Please type " + YES + " or " + NO + ".");
        }
    }

    public void showEmployeeDetails(String title, List<Employee> employees) {
        System.out.println();
        System.out.println(title);
        for (Employee employee : employees) {
            System.out.println("  " + employee.getEmployeeId() + " | " + employee);
        }
    }

    // ========== binary tree ==========
    // levels.get(0) is the root level, levels.get(1) the second level, and so on.
    public void showTree(List<List<Employee>> levels, int height, int nodeCount) {
        System.out.println();
        System.out.println("Employee hierarchy (level-order traversal):");
        for (int i = 0; i < levels.size(); i++) {
            List<Employee> level = levels.get(i);
            String nodeWord = (level.size() == 1) ? " node" : " nodes";
            System.out.println("Level " + (i + 1) + " (" + level.size() + nodeWord + "):");
            for (Employee employee : level) {
                System.out.println("  " + employee);
            }
        }
        System.out.println();
        System.out.println("Tree height: " + height + " levels (" + (height - 1) + " edges)");
        System.out.println("Total nodes: " + nodeCount);
    }
}
