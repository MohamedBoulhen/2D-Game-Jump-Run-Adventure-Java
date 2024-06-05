package user;

import java.util.*;
import java.io.*;

public class UserManager {
    private List<User> users;

    public UserManager() {
        users = new ArrayList<>();
        loadUsers();
    }

    public void login(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                System.out.println("Welcome back, " + name + "!");
                System.out.println("You are currently on level " + user.getLevel() + ".");
                return;
            }
        }

        User newUser = new User(name, 0); // New users start at level 0
        users.add(newUser);
        System.out.println("Welcome, " + name + "!");
    }

    public void register(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                System.out.println("This name is already taken. Please choose a different name.");
                return;
            }
        }

        User newUser = new User(name, 0); // New users start at level 0
        users.add(newUser);
        System.out.println("Welcome, " + name + "!");
    }

    public void loadUsers() {
        try {
            File file = new File("users.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split("\t");
                String name = line[0];
                int level = Integer.parseInt(line[1]);
                users.add(new User(name, level));
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("User file not found.");
        }
    }

    public void saveUsers() {
        try {
            FileWriter writer = new FileWriter("users.txt");

            for (User user : users) {
                writer.write(user.getName() + "\t" + user.getLevel() + "\n");
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while saving users.");
        }
    }
}
