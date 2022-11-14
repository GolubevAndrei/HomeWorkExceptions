import exeption.WrongLoginException;
import exeption.WrongPasswordException;

public class Main {
    public static void main(String[] args) throws WrongLoginException, WrongPasswordException {
        String login = "156ght";
        String pass = "DFV_156";
        String conPass = "DFV_156";
        System.out.println(acceptParametrs(login, pass, conPass));
    }

    public static boolean acceptParametrs(String login, String password, String confirmPassword) throws WrongPasswordException, WrongLoginException {
        boolean logConfir;
        boolean passConfir;
        boolean logLenght;
        boolean passLenght;
        boolean confirmPass;
        try {
            logConfir = Confirmation(login);
            passConfir = Confirmation(password);
            logLenght = LoginLenghtConfirmation(login);
            passLenght = PasswordLenghtConfirmation(password);
            confirmPass = ConfirmPasswordConfirmation(password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return logConfir && passConfir && logLenght && passLenght && confirmPass;
    }

    private static boolean Confirmation(String meaning) {
        if (meaning == null) {
            System.out.println("Введённое значение = null");
            return false;
        }
        if (meaning.matches("\\w+")) {
            return true;
        }
        System.out.println("Недопустимые символы в ведённом значении " + meaning);
        return false;
    }
    private static boolean LoginLenghtConfirmation(String login) throws WrongLoginException {
        if (login.length() > 20) {
            throw new WrongLoginException("Слишком длинный логин");
        }
        return true;
    }
    private static boolean PasswordLenghtConfirmation(String login) throws WrongPasswordException {
        if (login.length() > 19) {
            throw new WrongPasswordException("Слишком длинный пароль");
        }
        return true;
    }

    private static boolean ConfirmPasswordConfirmation(String password, String confirmPassword)  throws WrongPasswordException{
        if (password.equals(confirmPassword)) {
            return true;
        }
        throw new WrongPasswordException("Пароль и подтверждение пароля не совпадают");
    }
}