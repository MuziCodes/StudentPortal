// Muhammad Akif
import java.io.*;
import java.util.Scanner;
// maybe don't give different experience to faculty and student?
public class Login {
    private String username;
    private String password_hash;

    public Login(String username, String password_hash) {
        this.username = username;
        this.password_hash = password_hash;
    }

    public boolean authenticate(String username, String password) {
        try {
            File file = new File("login.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                String[] arr = data.split(" ");
                if (arr[0].equals(username) && arr[1].equals(password)) {
                    return true;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return false;
    }

    public void logout() {
        System.out.println("Logged out successfully");
    }

    public void loginExperience(Object user) {
        if (user instanceof Student) {
            Student student = (Student) user;
            System.out.println("Welcome, student " + student.getName() + "!");
        } else if (user instanceof Faculty) {
            Faculty faculty = (Faculty) user;
            System.out.println("Welcome, faculty member " + faculty.getName() + "!");
        } else {
            System.out.println("Welcome, user!");
        }
    }
}
