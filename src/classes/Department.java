// Qazi Owais

package classes;

public class Department {
    private String departmentID;
    private String departmentName;
    private Course[] listOfCourses;
    private int courseCount;

    public Department(String departmentID, String departmentName, int courseCapacity) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.listOfCourses = new Course[courseCapacity];
        this.courseCount = 0;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void addCourse(Course course) {
        if (courseCount < listOfCourses.length) {
            listOfCourses[courseCount++] = course;
        }
    }

    public void removeCourse(String courseID) {
        for (int i = 0; i < courseCount; i++) {
            if (listOfCourses[i] != null && listOfCourses[i].getCourseID().equals(courseID)) {
                listOfCourses[i] = listOfCourses[courseCount - 1];
                listOfCourses[courseCount - 1] = null;
                courseCount--;
                return;
            }
        }
    }

    public void listCourses() {
        for (int i = 0; i < courseCount; i++) {
            if (listOfCourses[i] != null) {
                System.out.println("- " + listOfCourses[i].getTitle() + " (ID: " + listOfCourses[i].getCourseID() + ")");
            }
        }
    }

    public int getCourseCount() {
        return courseCount;
    }
}
