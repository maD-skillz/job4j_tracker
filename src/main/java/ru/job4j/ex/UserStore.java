package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        if (login.equals(users)) {
                return null;
            } else {
            throw new UserNotFoundException("User not found!");
        }
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user.isValid()) {
            return true;
        } else if (user.length < 3) {
            throw new UserInvalidException("User invalid!");
        } else {
            throw new UserInvalidException("User invalid!");
        }
    }


    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            if (UserStore.findUser(users, "Vlad") > users.length(3)) {
                validate(users);
        }
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        } catch (UserInvalidException e) {
            e.printStackTrace();
        }
      /*  User user = findUser(users, "Petr Arsentev");
        if (validate(user)) {
            System.out.println("This user has an access");
        } */
    }
}