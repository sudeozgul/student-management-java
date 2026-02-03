import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        StudentManager manager = new StudentManager();
        manager.loadFromFile();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. List Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Exit");
            System.out.print("Choose (1-4): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Student ID: ");
                    String id = scanner.nextLine();

                    System.out.print("Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Department: ");
                    String department = scanner.nextLine();

                    System.out.print("Faculty: ");
                    String faculty = scanner.nextLine();

                    Student student = new Student(id, name, department, faculty);
                    manager.addStudent(student);
                    break;

                case 2:
                    manager.listStudents();
                    break;

                case 3:
                    manager.listStudents();
                    System.out.print("Enter student number to delete: ");
                    int index = scanner.nextInt();
                    manager.deleteStudent(index - 1);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
