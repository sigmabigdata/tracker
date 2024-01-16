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
        if (user.isValid() && user.getUsername().length() > 3) {
            return true;
        }
        throw new UserInvalidException("Пользователь не валидный или имя менее 3 символов");
    }

    public static void main(String[] args) {
        try {
            User[] users = {new User("ivan ivanov", true)};
            User user = findUser(users, "ivan ivanov");
            if (validate(user)) {
                System.out.println("Пользователь имеет доступ");
            }
        } catch (UserNotFoundException ex) {
            ex.printStackTrace();
        } /*catch (UserInvalidException en) {
            en.printStackTrace();
        }*/
    }
}
