package ru.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (User value : users) {
            if (value.getUsername().equals(login)) {
                return value;
            }
        }
        throw new UserNotFoundException("Пользователь не найден");
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid()) {
            throw new UserInvalidException("Пользователь не валидный");
        }
        if (user.getUsername().length() < 3) {
            throw new UserInvalidException("Имя пользователя короче 3 символов.");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {new User("Иванов Иван", true)};
        try {
            User user = findUser(users, "Иванов Иван");
            if (validate(user)) {
                System.out.println("Пользователь имеет доступ");
            }
        } catch (UserInvalidException en) {
            en.printStackTrace();
        } catch (UserNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
