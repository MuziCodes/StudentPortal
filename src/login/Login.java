// Muhammad Akif Alvi 

package login;

import java.io.*;
import java.util.Scanner;

public class Login {
    private static final String FILE_PATH = "users.txt";

    public void signUp(String username, String password) {
        if (isUsernameTaken(username)) {
            System.out.println("Sign-up failed! Username already exists.");
            return;
        }

        try {
            FileWriter writer = new FileWriter(FILE_PATH, true);
            String hashedPassword = hashPassword(password);
            writer.write(username + "," + hashedPassword + "\n");
            writer.close();
            System.out.println("Sign-up successful! You can now log in.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public boolean authenticate(String username, String password) {
        try {
            File file = new File(FILE_PATH);
            Scanner scanner = new Scanner(file);

            String hashedPassword = hashPassword(password);
            while (scanner.hasNextLine()) {
                String[] credentials = scanner.nextLine().split(",");
                if (credentials[0].equals(username) && credentials[1].equals(hashedPassword)) {
                    System.out.println("Authentication successful!");
                    scanner.close();
                    return true;
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: User database not found.");
        }

        System.out.println("Authentication failed! Incorrect username or password.");
        return false;
    }

    private boolean isUsernameTaken(String username) {
        try {
            File file = new File(FILE_PATH);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String[] credentials = scanner.nextLine().split(",");
                if (credentials[0].equals(username)) {
                    scanner.close();
                    return true;
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            // File not found means no users yet, so username is not taken
        }
        return false;
    }

    private String hashPassword(String password) {
        return Integer.toString(password.hashCode());
    }

    public void logout(String username) {
        System.out.println("User " + username + " logged out successfully.");
    }
}
