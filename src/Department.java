// Qazi Owais

public class Department {
    private int department_id;
    private String department_name;
    private Course[] list_of_courses;

    public Department(int department_id, String department_name, Course[] list_of_courses) {
        this.department_id = department_id;
        this.department_name = department_name;
        this.list_of_courses = list_of_courses;
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
