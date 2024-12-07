// Qazi Owais
public class Course {
    private int course_id;
    private String title;
    private String description;
    private String schedule;
    private Student[] students;
    private Department department;
    private int studentCount;

    public Course(int course_id, String title, String description, String schedule, Department department) {
        this.course_id = course_id;
        this.title = title;
        this.description = description;
        this.schedule = schedule;
        this.students = new Student[300];
        this.department = department;
        this.studentCount = 0;
    }

    public void add_student(Student student) {
        if (studentCount < students.length) {
            students[studentCount++] = student;
        } else {
            System.out.println("Course is full, cannot add more students.");
        }
    }

    public void remove_student(Student student) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].equals(student)) {
                students[i] = students[--studentCount];
                students[studentCount] = null;
                break;
            }
        }
    }

    public void print_students() {
        for (int i = 0; i < studentCount; i++) {
            System.out.println(students[i]);
        }
    }

    public int getCourse_id() {
        return course_id;
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

    public Student[] getStudents() {
        return students;
    }

    public Department getDepartment() {
        return department;
    }

    public int getStudentCount() {
        return studentCount;
    }

    @Override
    public String toString() {
        return "Course{" +
                "course_id=" + course_id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", schedule='" + schedule + '\'' +
                ", students=" + students +
                ", department=" + department +
                ", studentCount=" + studentCount +
                '}';
    }

    

}
