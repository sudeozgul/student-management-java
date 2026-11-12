import java.util.ArrayList;
import java.io.*;

public class StudentManager {

    private ArrayList<Student> students = new ArrayList<>();

    public void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(
                new FileReader("students.txt"))) {

            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", -1);

                if (parts.length == 4) {
                    Student student = new Student(
                            parts[0],
                            parts[1],
                            parts[2],
                            parts[3]
                    );

                    students.add(student);
                }
            }

            System.out.println("Student records loaded successfully.");

        } catch (FileNotFoundException e) {
            System.out.println("No saved student records found.");

        } catch (IOException e) {
            System.out.println("Error reading student records: " + e.getMessage());
        }
    }

    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("students.txt"))) {

            for (Student student : students) {
                writer.write(student.toFileString());
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error saving student records: " + e.getMessage());
        }
    }

    public void addStudent(Student student) {
        students.add(student);
        saveToFile();
        System.out.println("Student added successfully!");
    }

    public void listStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i).getInfo());
        }
    }

    public void deleteStudent(int index) {
        if (index >= 0 && index < students.size()) {
            students.remove(index);
            saveToFile();
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Invalid student number!");
        }
    }
}
