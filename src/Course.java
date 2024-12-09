// Qazi Owais
import java.util.ArrayList;
import java.util.List;

public class Course {
    private int courseId;
    private String title;
    private String description;
    private String schedule;
    private List<Student> students;
    private Department department;

    public Course(int courseId, String title, String description, String schedule, Department department) {
        this.courseId = courseId;
        this.title = title;
        this.description = description;
        this.schedule = schedule;
        this.students = new ArrayList<>();
        this.department = department;
    }

    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        } else {
            System.out.println("Student is already enrolled in the course.");
        }
    }

    public void removeStudent(Student student) {
        if (students.remove(student)) {
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student not found in the course.");
        }
    }

    public void printStudents() {
        if (students.isEmpty()) {
            System.out.println("No students enrolled in the course.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    public int getCourseId() {
        return courseId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getSchedule() {
        return schedule;
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students); // Returning a copy to prevent external modification
    }

    public Department getDepartment() {
        return department;
    }

    public int getStudentCount() {
        return students.size();
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", schedule='" + schedule + '\'' +
                ", students=" + students +
                ", department=" + department +
                ", studentCount=" + students.size() +
                '}';
    }
}

    
