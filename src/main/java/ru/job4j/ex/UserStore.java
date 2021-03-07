package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        if (users.equals(login)) {
            return null;
        } else {
            throw new UserNotFoundException("User not found!");
        }
    }


    public static boolean validate(User user) throws UserInvalidException {
        if (user.isValid()) {
            return true;
        } else {
            throw new UserInvalidException("User invalid!");
        }
    }


    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            int len = users.length;
            for (int i = 0; i < users.length; i++) {
                if (validate(user) && len > 3) {
                    System.out.println("This user has an access");
                }
            }


        } catch (UserNotFoundException e) {
            e.printStackTrace();
        } catch (UserInvalidException e) {
            e.printStackTrace();
        }
    }
}
