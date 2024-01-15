package schoolManegementSystem;
import java.util.Scanner;

public class AdminInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Student Record Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student Information");
            System.out.println("3. View Student Details");
            System.out.println("4. Delete Student");
            System.out.println("5. Total Students");
            System.out.println("6. View All Student Details");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    // Add a new student
                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter student grade: ");
                    String grade = scanner.nextLine();
                    StudentManagement.addStudent(id, name, age, grade);
                    System.out.println("Student added successfully.");
                    break;
                case 2:
                    // Update student information
                    System.out.print("Enter student ID to update: ");
                    int updateID = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter new student name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new student age: ");
                    int newAge = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter new student grade: ");
                    String newGrade = scanner.nextLine();
                    StudentManagement.updateStudent(updateID, newName, newAge, newGrade);
                    System.out.println("Student information updated successfully.");
                    break;
                case 3:
                    // View student details
                    System.out.print("Enter student ID to view details: ");
                    int viewID = scanner.nextInt();
                    scanner.nextLine(); 
                    Student student = StudentManagement.getStudentDetails(viewID);
                    if (student != null) {
                        System.out.println("Student Details:");
                        System.out.println("ID: " + student.getId());
                        System.out.println("Name: " + student.getName());
                        System.out.println("Age: " + student.getAge());
                        System.out.println("Grade: " + student.getGrade());
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    // Delete student
                    System.out.print("Enter student ID to delete: ");
                    int deleteID = scanner.nextInt();
                    scanner.nextLine(); 
                    try {
                        StudentManagement.deleteStudent(deleteID);
                        System.out.println("Student deleted successfully.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    // Total Students
                    System.out.println("Total Students: " + StudentManagement.getTotalStudents());
                    break;
                case 6:
                    // View All Students 
                    StudentManagement.viewAllStudents();
                    break;
                case 7:
                    // Exit the program
                    System.out.println("Exiting Student Management System.");
                    System.exit(0);
                    break;
               
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}

