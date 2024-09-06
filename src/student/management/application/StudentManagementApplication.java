/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package student.management.application;

/**
 *
 * @author Fentse
 */
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String id;
    private String name;
    private int age;

    public Student(String id, String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class StudentManagementApplication {
    private ArrayList<Student> students;
    private Scanner scanner;

    public StudentManagementApplication() {
        this.students = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("1. Capture a new student");
            System.out.println("2. Search for a student");
            System.out.println("3. Delete a student");
            System.out.println("4. View student report");
            System.out.println("5. Exit application");
            System.out.print("Choose an option: ");
            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    captureStudent();
                    break;
                case 2:
                    searchStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    viewStudentReport();
                    break;
                case 5:
                    System.out.println("Exiting application...");
                    return;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }

    private void captureStudent() {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        int age;
        while (true) {
            try {
                System.out.print("Enter student age: ");
                age = Integer.parseInt(scanner.nextLine());
                if (age >= 16) {
                    break;
                } else {
                    System.out.println("Age must be greater than or equal to 16.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid age. Please enter a number.");
            }
        }
        students.add(new Student(id, name, age));
        System.out.println("Student details saved successfully.");
    }

    private void searchStudent() {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        for (Student student : students) {
            if (student.getId().equals(id)) {
                System.out.println("Student ID: " + student.getId());
                System.out.println("Student Name: " + student.getName());
                System.out.println("Student Age: " + student.getAge());
                return;
            }
        }
        System.out.println("Student not found.");
    }

    private void deleteStudent() {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        for (Student student : students) {
            if (student.getId().equals(id)) {
                System.out.println("Are you sure you want to delete this student? (yes/no)");
                String confirm = scanner.nextLine();
                if (confirm.equalsIgnoreCase("yes")) {
                    students.remove(student);
                    System.out.println("Student deleted successfully.");
                }
                return;
            }
        }
        System.out.println("Student not found.");
    }

    private void viewStudentReport() {
        for (Student student : students) {
            System.out.println("Student ID: " + student.getId());
            System.out.println("Student Name: " + student.getName());
            System.out.println("Student Age: " + student.getAge());
            System.out.println("------------------------");
        }
    }

    public static void main(String[] args) {
        StudentManagementApplication application = new StudentManagementApplication();
        application.run();
    }
}

    

