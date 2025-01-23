import java.io.*;
import java.util.*;

public class StudentManagementSystem {
    private List<Student> students = new ArrayList<>();
    private static final String FILE_NAME = "students.txt";

    // Add student
    public void addStudent(String name, String rollNumber, String grade) {
        students.add(new Student(name, rollNumber, grade));
    }

    // Remove student
    public void removeStudent(String rollNumber) {
        students.removeIf(s -> s.getRollNumber().equals(rollNumber));
    }

    // Search for a student
    public Student searchStudent(String rollNumber) {
        return students.stream().filter(s -> s.getRollNumber().equals(rollNumber)).findFirst().orElse(null);
    }

    // Display all students
    public void displayAllStudents() {
        students.forEach(System.out::println);
    }

    // Save to file
    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Student student : students) {
                writer.write(student.getName() + "," + student.getRollNumber() + "," + student.getGrade());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving data.");
        }
    }

    // Load from file
    public void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                students.add(new Student(data[0], data[1], data[2]));
            }
        } catch (IOException e) {
            System.out.println("Error loading data.");
        }
    }

    // Input validation
    public static String getValidInput(String prompt) {
        Scanner sc = new Scanner(System.in);
        String input;
        do {
            System.out.print(prompt);
            input = sc.nextLine().trim();
        } while (input.isEmpty());
        return input;
    }
}