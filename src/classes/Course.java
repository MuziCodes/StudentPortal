// Qazi Owais

package classes;

public class Course {
    private String courseID;
    private String title;
    private String description;
    private String schedule;
    private Student[] students;
    private Department[] departments;
    private int studentCount;
    private int departmentCount;

    public Course(String courseID, String title, String description, String schedule, int studentCapacity, int departmentCapacity) {
        this.courseID = courseID;
        this.title = title;
        this.description = description;
        this.schedule = schedule;
        this.students = new Student[studentCapacity];
        this.departments = new Department[departmentCapacity];
        this.studentCount = 0;
        this.departmentCount = 0;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public void addStudent(Student student) {
        if (studentCount < students.length) {
            students[studentCount++] = student;
        }
    }

    public void removeStudent(String studentID) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i] != null && students[i].getStudentID().equals(studentID)) {
                students[i] = students[studentCount - 1];
                students[studentCount - 1] = null;
                studentCount--;
                return;
            }
        }
    }

    public void listStudents() {
        for (int i = 0; i < studentCount; i++) {
            if (students[i] != null) {
                System.out.println("- " + students[i].getName() + " (ID: " + students[i].getStudentID() + ")");
            }
        }
    }

    public void addDepartment(Department department) {
        if (departmentCount < departments.length) {
            departments[departmentCount++] = department;
        }
    }

    public void listDepartments() {
        for (int i = 0; i < departmentCount; i++) {
            if (departments[i] != null) {
                System.out.println("- " + departments[i].getDepartmentName() + " (ID: " + departments[i].getDepartmentID() + ")");
            }
        }
    }

    public int getStudentCount() {
        return studentCount;
    }

    public int getDepartmentCount() {
        return departmentCount;
    }
}
