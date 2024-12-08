// Muzammil Ahmed
// The login process for new and existing students is designed to ensure secure access to the portal. New students must complete a registration form that collects essential information, including their name, student ID, email, and password. After submission, their credentials are verified and stored securely in the system. Existing students can log in using their registered email and password. The system incorporates security measures, such as password encryption and a CAPTCHA verification step, to protect user data and prevent unauthorized access.

public class Student extends Person {
    private String email;
    private String password;
    private Course[] courses;
    private Department department;
    private Financials financials;

    public Student(String name, String email, String password, Course[] courses, Department department, Financials financials) {
        super(name);
        this.email = email;
        this.password = password;
        this.courses = courses;
        this.department = department;
        this.financials = financials;
    }

    public void enroll_course(Course course) {
        Course[] new_courses = new Course[courses.length + 1];
        for (int i = 0; i < courses.length; i++) {
            new_courses[i] = courses[i];
        }
        new_courses[courses.length] = course;
        courses = new_courses;
    }

    public void submit_assignment(Course course, Assignment assignment) {
        course.add_assignment(assignment);
    }
}