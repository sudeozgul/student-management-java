import java.util.ArrayList;
import java.io.*;

public class StudentManager {

    private ArrayList<Student> students = new ArrayList<>();

    public void loadFromFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("students.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
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
            reader.close();
        } catch (IOException e) {
            
        }
    }

    public void saveToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("students.txt"));
            for (Student s : students) {
                writer.write(s.toFileString());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("File write error!");
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

        int i = 1;
        for (Student s : students) {
            System.out.println(i + ". " + s.getInfo());
            i++;
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
