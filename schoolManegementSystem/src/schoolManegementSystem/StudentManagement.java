package schoolManegementSystem;
import java.util.List;
import java.util.ArrayList;

public class StudentManagement {
	    private static List<Student> students = new ArrayList<>();
	    private static int totalStudents = 0;
	    
	    public static void addStudent(int id, String name, int age, String grade) {
	        
	        if (name == null || name.trim().isEmpty() ||
	            age < 0 || grade == null || grade.trim().isEmpty()) {
	            throw new IllegalArgumentException("Invalid input. Please provide valid values for name, age, and grade.");
	        }

	        Student student = new Student(id, name, age, grade);
	        students.add(student);
	        totalStudents++;
	    }
	    
	    public static Student getStudentDetails(int id) {
	        for (Student student : students) {
	            if (student.getId() == id) {
	                return student;
	            }
	        }
	        return null;
	    }
	    
	    public static void updateStudent(int id, String name, int age, String grade) {
	        Student student = getStudentDetails(id);
	        if (student == null) {
	            throw new IllegalArgumentException("Student not found.");
	        }

	        
	        if (name == null || name.trim().isEmpty() ||
	            age < 0 || grade == null || grade.trim().isEmpty()) {
	            throw new IllegalArgumentException("Invalid input. Please provide valid values for name, age, and grade.");
	        }

	        
	        student.setName(name);
	        student.setAge(age);
	        student.setGrade(grade);
	    }

	    public static void deleteStudent(int id) {
	        int index = students.indexOf(getStudentDetails(id));
	        if (index == -1) {
	            throw new IllegalArgumentException("Student not found.");
	        }
	        students.remove(index);
	        totalStudents--;
	    }

	    public static int getTotalStudents() {
	        return totalStudents;
	    }
	    public static void viewAllStudents() {
	        if (!students.isEmpty()) {
	            System.out.println("Student Details:");
	            for (Student student : students) {
	                System.out.println("ID: " + student.getId());
	                System.out.println("Name: " + student.getName());
	                System.out.println("Age: " + student.getAge());
	                System.out.println("Grade: " + student.getGrade());
	                System.out.println("---------------------------");
	            }
	        } else {
	            System.out.println("No students found.");
	        }
	    }
	}

