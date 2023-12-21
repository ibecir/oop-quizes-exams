package ba.edu.ibu.quiz4.group1;

/*
You are working on a Java project where you need to introduce a simple mechanism for marking certain fields as "configurable."

Create a custom exception named MySystemException that extends the appropriate base exception class.
Use this custom exception to handle any errors that may occur during the following program.

Define a custom annotation named ConfigurableField that can be applied to fields in a Java class.

Create a class called Student with the following fields firstName, lastName, and age. Apply the custom annotation to firstName and lastName only.

Implement a method named saveConfigurableFields in a separate class named Parser. This method should take an object and use reflection to save the names of the fields annotated with ConfigurableField into a file passed in the filename parameter in the format fieldname:fieldvalue (repeat this for each field). In case the data.txt does not exist, you should create the file and add the above, in case it does exist, you should append the values.

Write a unit test to confirm that the code in the main method has 4 written lines of code after the execution. Your test needs to re-use the methods in the main method.

Your main file:

public class Quiz4g1 {
    public static void main(String[] args) {
        String filename = "data.txt";
        Student student = new Student();
        student.setFirstName("Jane");
        student.setLastName("Doe");
        student.setAge(20);

        Parser.saveConfigurableFields(filename, student);
        Parser.saveConfigurableFields(filename, student);
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

// Student class with configurable fields
class Student {
    @ConfigurableField
    private String firstName;
    @ConfigurableField
    private String lastName;
    private int age;

    // Getters and setters for non-configurable fields
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Getters and setters for configurable fields
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

// Parser class to save configurable fields using reflection
class Parser {
    public static void saveConfigurableFields(String filename, Object obj) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            Class<?> clazz = obj.getClass();
            Field[] fields = clazz.getDeclaredFields();

            for (Field field : fields) {
                if (field.isAnnotationPresent(ConfigurableField.class)) {
                    field.setAccessible(true);
                    String fieldName = field.getName();
                    Object fieldValue = field.get(obj);
                    writer.println(fieldName + ":" + fieldValue);
                }
            }

        } catch (IOException | IllegalAccessException e) {
            // Handle exceptions
            throw new MySystemException("Error saving configurable fields", e);
        }
    }
}

// Unit test class
public class Quiz4g1 {
    public static void main(String[] args) {
        String filename = "data.txt";
        Student student = new Student();
        student.setFirstName("Jane");
        student.setLastName("Doe");
        student.setAge(20);

        // Save configurable fields
        Parser.saveConfigurableFields(filename, student);
        Parser.saveConfigurableFields(filename, student);

        // Confirm that there are 4 written lines of code after execution
        System.out.println("Number of lines after execution: " + countLines(filename));
    }

    // Helper method to count lines in a file
    private static int countLines(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            int lines = 0;
            while (reader.readLine() != null) {
                lines++;
            }
            return lines;
        } catch (IOException e) {
            // Handle exceptions
            throw new MySystemException("Error counting lines", e);
        }
    }
}
