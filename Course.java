// Qazi Owais
public class Course {
    private int course_id;
    private String title;
    private String description;
    private String schedule;
    private List<Student> students;
    private Department department;

    public Course(int course_id, String title, String description, String schedule, Department department) {
        this.course_id = course_id;
        this.title = title;
        this.description = description;
        this.schedule = schedule;
        // don't use arraylist
        students = new Student[10];
        this.department = department;
    }

    public void add_student(Student student) {
        students.add(student);
    }

    public void remove_student(Student student) {
        students.remove(student);
    }

    // Getters and setters for the fields can be added here if needed
}
