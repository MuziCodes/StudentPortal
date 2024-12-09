// Qazi Owais

public class Department {
    private int department_id;
    private String department_name;
    private Course[] list_of_courses;

    public Department(int department_id, String department_name, Course[] list_of_courses) {
        this.department_id = department_id;
        this.department_name = department_name;
        this.list_of_courses = list_of_courses;
    }// Getters and Setters (optional)
    public int getDepartmentId() {
        return department_id;
    }

    public void setDepartmentId(int department_id) {
        this.department_id = department_id;
    }

    public String getDepartmentName() {
        return department_name;
    }

    public void setDepartmentName(String department_name) {
        this.department_name = department_name;
    }

    public List<Course> getListOfCourses() {
        return new ArrayList<>(list_of_courses); // Return a copy for immutability
    }

    public void setListOfCourses(List<Course> list_of_courses) {
        this.list_of_courses = new ArrayList<>(list_of_courses);
    }
}

    public void add_course(Course course) {
        Course[] new_list_of_courses = new Course[list_of_courses.length + 1];
        for (int i = 0; i < list_of_courses.length; i++) {
            new_list_of_courses[i] = list_of_courses[i];
        }
        new_list_of_courses[list_of_courses.length] = course;
        list_of_courses = new_list_of_courses;
    }

    public void remove_course(Course course) {
        Course[] new_list_of_courses = new Course[list_of_courses.length - 1];
        int j = 0;
        for (int i = 0; i < list_of_courses.length; i++) {
            if (list_of_courses[i] != course) {
                new_list_of_courses[j] = list_of_courses[i];
                j++;
            }
        }
        list_of_courses = new_list_of_courses;
    }
}
