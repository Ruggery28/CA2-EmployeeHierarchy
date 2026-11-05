/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package model;

import java.util.Optional;

/**
 *
 * @author Ruggery
 */
public enum Department {

    WOMENSWEAR("Womenswear"),
    MENSWEAR("Menswear"),
    HOME_AND_LIVING("Home and Living"),
    BEAUTY_AND_FRAGRANCE("Beauty and Fragrance"),
    ELECTRONICS("Electronics"),
    CUSTOMER_SERVICE("Customer Service"),
    FINANCE("Finance"),
    HUMAN_RESOURCES("Human Resources"),
    LOGISTICS("Logistics"),
    STORE_OPERATIONS("Store Operations");

    private final String label;

    //constructor to get the label
    private Department(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    //toString to return that specific text according to the label 
    @Override
    public String toString() {
        return label;
    }
    
    public static Optional<Department> fromLabel(String label) {
        String cleanedDepartment = label.trim();
        for (Department dep : values()) {
            if (dep.label.equalsIgnoreCase(cleanedDepartment)) {
                return Optional.of(dep);
            }
        }
        return Optional.empty();
    }
}
