package utils;

public class PasswordValidation {
    public static boolean menuLogin(String password) {
        return password.equalsIgnoreCase("!password?456");
    }
}
