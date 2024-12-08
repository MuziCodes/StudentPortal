// Muzammil Ahmed

//Faculty members have a dedicated section within the portal that grants them access to relevant information about the subjects they teach. They can view their course outlines, schedules, and assigned roles within the university. Furthermore, the portal provides faculty with departmental information, allowing them to collaborate with colleagues and access resources pertinent to their teaching responsibilities. This functionality supports a cohesive academic environment and promotes effective communication among faculty members.

public class Faculty extends Student {
    private String email;
    private Department department;

    public Faculty(String email, Department department) {
        this.email = email;
        this.department = department;
    }

    public void assign_grade() {
        // Implementation
    }

    public void manage_courses() {
        // Implementation
    }
}
