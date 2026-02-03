public class Student {

    private String studentId;
    private String name;
    private String department;
    private String faculty;

    public Student(String studentId, String name, String department, String faculty) {
        this.studentId = studentId;
        this.name = name;
        this.department = department;
        this.faculty = faculty;
    }

    public String getInfo() {
        return studentId + " - " + name + " - " + department + " - " + faculty;
    }

    public String toFileString() {
        return studentId + "," + name + "," + department + "," + faculty;
    }
}
