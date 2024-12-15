//Once logged in, students can easily access their academic information. The portal provides a user-friendly interface where students can view their Grade Point Average (GPA), detailed marks for each course, and any outstanding fees. Additionally, students can review their registered courses and track attendance records through dedicated sections within the portal. This centralized access allows students to monitor their academic progress and manage their educational responsibilities efficiently.

//Student and faculty records are stored in a secure database within the portal. The system allows for the easy updating and management of these records, ensuring that all information is current and accurate. Students can edit their personal information as needed, while faculty can update their course details and departmental roles. Regular backups and data integrity checks are implemented to protect against data loss and ensure compliance with privacy regulations.

//The portal includes various collaboration tools designed to facilitate communication and project management among students and faculty. Features such as discussion forums, messaging systems, and shared document storage enable effective collaboration on group projects and academic initiatives. These tools encourage interaction and teamwork, enhancing the learning experience and promoting a sense of community within the academic environment.

package main;
import login.Login;
import classes.*;

import javax.swing.*;
import java.awt.*;

public class Main {
    private static Login loginSystem = new Login();
    private static Student currentStudent;
    private static Faculty currentFaculty;
    private static Department csDepartment = new Department("D001", "Computer Science", 10);
    private static Course javaCourse = new Course("C001", "Java Programming", "Learn Java basics", "Mon, Wed, Fri", 30, 5);
    private static Financials financials;

    public static void main(String[] args) {
        // Initialize Default Course and Department
        csDepartment.addCourse(javaCourse);
        javaCourse.addDepartment(csDepartment);

        // Initialize a default faculty
        currentFaculty = new Faculty("Dr. John Doe", "F001", "johndoe@example.com", "Computer Science", 5);

        // Start GUI
        SwingUtilities.invokeLater(() -> createLoginGUI());
    }

    private static void createLoginGUI() {
        JFrame frame = new JFrame("Student Management System - Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(5, 2, 10, 10));

        // Components
        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField();
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField();
        JLabel roleLabel = new JLabel("Role:");
        String[] roles = {"Student", "Faculty"};
        JComboBox<String> roleBox = new JComboBox<>(roles);

        JButton loginButton = new JButton("Login");
        JButton signupButton = new JButton("Sign Up");

        // Actions
        loginButton.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passField.getPassword());
            String role = (String) roleBox.getSelectedItem();

            if (loginSystem.authenticate(username, password)) {
                JOptionPane.showMessageDialog(frame, "Login Successful!");
                if ("Student".equals(role)) {
                    financials = new Financials(username, 2000, 500, "2024-06-01");
                    currentStudent = new Student(username, "ID123", username, username + "@example.com", password,
                            csDepartment, financials, 5);
                    showStudentMenu();
                } else if ("Faculty".equals(role)) {
                    showFacultyMenu();
                }
                frame.dispose();
            } else {
                JOptionPane.showMessageDialog(frame, "Login Failed!");
            }
        });

        signupButton.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passField.getPassword());

            loginSystem.signUp(username, password);
            JOptionPane.showMessageDialog(frame, "Sign Up Successful!");
        });

        // Add components
        frame.add(userLabel);
        frame.add(userField);
        frame.add(passLabel);
        frame.add(passField);
        frame.add(roleLabel);
        frame.add(roleBox);
        frame.add(loginButton);
        frame.add(signupButton);

        frame.setVisible(true);
    }

    private static void showStudentMenu() {
        JFrame frame = new JFrame("Student Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(6, 1, 10, 10));

        JButton viewProfileButton = new JButton("View Profile");
        JButton enrollCourseButton = new JButton("Enroll in Course");
        JButton listCoursesButton = new JButton("List Enrolled Courses");
        JButton viewFinancialsButton = new JButton("View Financials");
        JButton logoutButton = new JButton("Logout");

        viewProfileButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, currentStudent.getInfo());
        });

        enrollCourseButton.addActionListener(e -> {
            currentStudent.enrollCourse(javaCourse);
            JOptionPane.showMessageDialog(frame, "Enrolled in " + javaCourse.getTitle());
        });

        listCoursesButton.addActionListener(e -> {
            JFrame coursesFrame = new JFrame("Enrolled Courses");
            coursesFrame.setSize(300, 200);
            JTextArea courseArea = new JTextArea();
            courseArea.setEditable(false);
            for (int i = 0; i < 5; i++) {
                courseArea.append(javaCourse.getTitle() + "\n");
            }
            coursesFrame.add(new JScrollPane(courseArea));
            coursesFrame.setVisible(true);
        });

        viewFinancialsButton.addActionListener(e -> {
            currentStudent.getFinancials().displayFinancials();
        });

        logoutButton.addActionListener(e -> {
            loginSystem.logout(currentStudent.getName());
            JOptionPane.showMessageDialog(frame, "Logged Out!");
            createLoginGUI();
            frame.dispose();
        });

        // Add buttons
        frame.add(viewProfileButton);
        frame.add(enrollCourseButton);
        frame.add(listCoursesButton);
        frame.add(viewFinancialsButton);
        frame.add(logoutButton);

        frame.setVisible(true);
    }

    private static void showFacultyMenu() {
        JFrame frame = new JFrame("Faculty Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(5, 1, 10, 10));

        JButton viewProfileButton = new JButton("View Profile");
        JButton assignCourseButton = new JButton("Assign Course");
        JButton listCoursesButton = new JButton("List Assigned Courses");
        JButton logoutButton = new JButton("Logout");

        viewProfileButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, currentFaculty.getInfo());
        });

        assignCourseButton.addActionListener(e -> {
            currentFaculty.assignCourse(javaCourse);
            JOptionPane.showMessageDialog(frame, "Assigned course: " + javaCourse.getTitle());
        });

        listCoursesButton.addActionListener(e -> {
            JFrame coursesFrame = new JFrame("Assigned Courses");
            coursesFrame.setSize(300, 200);
            JTextArea courseArea = new JTextArea();
            courseArea.setEditable(false);
            for (int i = 0; i < currentFaculty.getCourseCount(); i++) {
                courseArea.append(javaCourse.getTitle() + "\n");
            }
            coursesFrame.add(new JScrollPane(courseArea));
            coursesFrame.setVisible(true);
        });

        logoutButton.addActionListener(e -> {
            loginSystem.logout(currentFaculty.getName());
            JOptionPane.showMessageDialog(frame, "Logged Out!");
            createLoginGUI();
            frame.dispose();
        });

        // Add buttons
        frame.add(viewProfileButton);
        frame.add(assignCourseButton);
        frame.add(listCoursesButton);
        frame.add(logoutButton);

        frame.setVisible(true);
    }
}
