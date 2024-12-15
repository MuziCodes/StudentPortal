// Muzammil Ahmed
// The login process for new and existing students is designed to ensure secure access to the portal. New students must complete a registration form that collects essential information, including their name, student ID, email, and password. After submission, their credentials are verified and stored securely in the system. Existing students can log in using their registered email and password. The system incorporates security measures, such as password encryption and a CAPTCHA verification step, to protect user data and prevent unauthorized access.

package classes;

public class Student extends Person {
    private String studentID;
    private String email;
    private String password;

    private Course[] courses; 
    private Department department;
    private Financials financials;

    public Student(String name, String ID, String studentID, String email, String password, 
                   Department department, Financials financials, int courseCapacity) {
        super(name, ID);
        this.studentID = studentID;
        this.email = email;
        this.password = password;
        this.department = department;
        this.financials = financials;
        this.courses = new Course[courseCapacity];
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Financials getFinancials() {
        return financials;
    }

    public void setFinancials(Financials financials) {
        this.financials = financials;
    }

    public void enrollCourse(Course course) {
        for (int i = 0; i < courses.length; i++) {
            if (courses[i] == null) {
                courses[i] = course;
                System.out.println(getName() + " enrolled in the course: " + course.getTitle());
                return;
            }
        }
        System.out.println("Course enrollment failed! No available slots.");
    }

    public void listCourses() {
        System.out.println("Courses for " + getName() + ":");
        for (Course course : courses) {
            if (course != null) {
                System.out.println("- " + course.getTitle());
            }
        }
    }

    @Override
    public String getInfo() {
        return "Student Name: " + getName() +
               "\nID: " + getID() +
               "\nStudent ID: " + studentID +
               "\nEmail: " + email +
               "\nDepartment: " + (department != null ? department.getDepartmentName() : "N/A");
    }

    public void submitAssignment() {
        System.out.println(getName() + " has submitted an assignment.");
    }
}
