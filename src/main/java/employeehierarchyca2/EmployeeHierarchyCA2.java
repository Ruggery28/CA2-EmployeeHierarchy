/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package employeehierarchyca2;

import controller.AppController;
import java.io.IOException;
import view.ConsoleView;

/**
 *
 * @author Ruggery
 */
public class EmployeeHierarchyCA2 {

    public static void main(String[] args) throws IOException {
        /**
         * Entry point: it only creates the view and the controller and starts
         * the program.
         */
        String defaultFileName = "Applicants_Form.txt";
        
        ConsoleView view = new ConsoleView();
        AppController controller = new AppController(view, defaultFileName);
        controller.run();
        
    }
}
