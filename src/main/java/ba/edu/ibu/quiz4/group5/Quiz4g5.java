package ba.edu.ibu.quiz4.group5;

/*
You are working on a Java project where you need to introduce a simple mechanism for marking certain fields as "configurable."

Create a custom exception named MySystemException that extends the appropriate base exception class.
Use this custom exception to handle any errors that may occur during the following program, your exception has to provide meaningful messages.

Define a custom annotation named ConfigurableField that can be applied to fields in a Java class.

Create a class called Classroom with the following fields code, name, and description. Apply the custom annotation to code and name only.

Implement a method named readSettings in a separate class named ConfigSettings. This method should read the values from the file settings.txt and populate the fields in the main method.

The settings.txt file should contain the following:
code,name,description
lab1,Lab 316, Lab with 24 PCs

Implement a method named saveConfigurableFields in a separate class named ConfigSaver. This method should take an object and use reflection to save the names of the fields annotated with ConfigurableField into a file passed in the filename parameter in the format fieldname=>fieldvalue (repeat this for each field).


Your main file:

public class Quiz4g2 {
    public static void main(String[] args) {
        Classroom readValues = ConfigSettings.readSettings();


        String filename = "data.txt";
        Classroom classroom = new Classroom();
        classroom.setCode(readValues.getCode());
        classroom.setName(readValues.getName());
        classroom.setDescription(readValues.getDescription());


        ConfigSaver.saveConfigurableFields(filename, classroom);
    }
}
 */

import java.io.*;
import java.lang.annotation.*;
import java.lang.reflect.*;


// Custom exception class
class MySystemException extends RuntimeException {
    public MySystemException(String message, Throwable cause) {
        super(message, cause);
    }
}


// Custom annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface ConfigurableField {
}


// Classroom class with configurable fields
class Classroom {
    @ConfigurableField
    private String code;
    @ConfigurableField
    private String name;
    private String description;


    // Getters and setters for non-configurable fields
    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    // Getters and setters for configurable fields
    public String getCode() {
        return code;
    }


    public void setCode(String code) {
        this.code = code;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }
}


// ConfigSettings class to read settings from file
class ConfigSettings {
    public static Classroom readSettings() {
        try (BufferedReader reader = new BufferedReader(new FileReader("settings.txt"))) {
            String line = reader.readLine();
            if (line != null) {
                String[] values = line.split(",");
                Classroom classroom = new Classroom();
                classroom.setCode(values[0]);
                classroom.setName(values[1]);
                classroom.setDescription(values[2]);
                return classroom;
            }
        } catch (IOException e) {
            // Handle exceptions
            throw new MySystemException("Error reading settings", e);
        }
        return null;
    }
}


// ConfigSaver class to save configurable fields using reflection
class ConfigSaver {
    public static void saveConfigurableFields(String filename, Object obj) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            Class<?> clazz = obj.getClass();
            Field[] fields = clazz.getDeclaredFields();


            for (Field field : fields) {
                if (field.isAnnotationPresent(ConfigurableField.class)) {
                    field.setAccessible(true);
                    String fieldName = field.getName();
                    Object fieldValue = field.get(obj);
                    writer.println(fieldName + "=>" + fieldValue);
                }
            }


        } catch (IOException | IllegalAccessException e) {
            // Handle exceptions
            throw new MySystemException("Error saving configurable fields", e);
        }
    }
}


// Main class
public class Quiz4g5 {
    public static void main(String[] args) {
        Classroom readValues = ConfigSettings.readSettings();


        String filename = "data.txt";
        Classroom classroom = new Classroom();
        classroom.setCode(readValues.getCode());
        classroom.setName(readValues.getName());
        classroom.setDescription(readValues.getDescription());


        ConfigSaver.saveConfigurableFields(filename, classroom);
    }
}

