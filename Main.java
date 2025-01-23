import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();
        sms.loadFromFile();

        while (true) {
            System.out.println("\n1. Add Student\n2. Remove Student\n3. Search Student\n4. Display All\n5. Save & Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    String name = StudentManagementSystem.getValidInput("Enter Name: ");
                    String rollNumber = StudentManagementSystem.getValidInput("Enter Roll No: ");
                    String grade = StudentManagementSystem.getValidInput("Enter Grade (A-F): ");
                    sms.addStudent(name, rollNumber, grade);
                    break;
                case 2:
                    String removeRoll = StudentManagementSystem.getValidInput("Enter Roll No to remove: ");
                    sms.removeStudent(removeRoll);
                    break;
                case 3:
                    String searchRoll = StudentManagementSystem.getValidInput("Enter Roll No to search: ");
                    Student found = sms.searchStudent(searchRoll);
                    if (found != null) {
                        System.out.println(found);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    sms.displayAllStudents();
                    break;
                case 5:
                    sms.saveToFile();
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}