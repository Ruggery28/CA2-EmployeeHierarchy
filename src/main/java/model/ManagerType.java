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
public enum ManagerType {

    //Categories named for the job title
    STORE_DIRECTOR("Store Director"),
    SENIOR_MANAGER("Senior Manager"),
    DEPARTMENT_MANAGER("Department Manager"),
    ASSISTANT_MANAGER("Assistant Manager"),
    TEAM_LEAD("Team Lead"),
    ASSOCIATE("Associate");

    private final String label;

    //constructor to get the label
    private ManagerType(String label) {
        this.label = label;
    }

    //getter
    public String getLabel() {
        return label;
    }

    //toString to return that specific text according to the label 
    @Override
    public String toString() {
        return label;
    }

    //optional holds a Manager type, and return the type.of if exists or empty if doesnt exist.
    public static Optional<ManagerType> fromLabel(String label) {
        String cleanTitle = label.trim();
        for (ManagerType title : values()) {
            if (title.label.equalsIgnoreCase(cleanTitle)) {
                return Optional.of(title);
            }
        }
        return Optional.empty();
    }

}
