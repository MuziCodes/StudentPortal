// Muzammil Ahmed

//Faculty members have a dedicated section within the portal that grants them access to relevant information about the subjects they teach. They can view their course outlines, schedules, and assigned roles within the university. Furthermore, the portal provides faculty with departmental information, allowing them to collaborate with colleagues and access resources pertinent to their teaching responsibilities. This functionality supports a cohesive academic environment and promotes effective communication among faculty members.

package classes;

public class Faculty extends Person {
    private String email;
    private String department;
    private Course[] assignedCourses;
    private int courseCount;

    public Faculty(String name, String ID, String email, String department, int courseCapacity) {
        super(name, ID);
        this.email = email;
        this.department = department;
        this.assignedCourses = new Course[courseCapacity];
        this.courseCount = 0;
    }

    public int getCourseCount() {
        return courseCount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void assignCourse(Course course) {
        if (courseCount < assignedCourses.length) {
            assignedCourses[courseCount++] = course;
        }
    }

    public void removeCourse(String courseID) {
        for (int i = 0; i < courseCount; i++) {
            if (assignedCourses[i] != null && assignedCourses[i].getCourseID().equals(courseID)) {
                assignedCourses[i] = assignedCourses[courseCount - 1];
                assignedCourses[courseCount - 1] = null;
                courseCount--;
                return;
            }
        }
    }

    public void listAssignedCourses() {
        for (int i = 0; i < courseCount; i++) {
            if (assignedCourses[i] != null) {
                System.out.println("- " + assignedCourses[i].getTitle() + " (ID: " + assignedCourses[i].getCourseID() + ")");
            }
        }
    }

    @Override
    public String getInfo() {
        return "Faculty Name: " + getName() + "\nID: " + getID() + "\nEmail: " + email + "\nDepartment: " + department;
    }
}
