package vn.iotstar.webcourse.util;

import java.util.regex.Pattern;

public class ValidationUtil {
    private static final Pattern EMAIL_REGEX = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    private static final Pattern PHONE_REGEX = Pattern.compile("^0\\d{9}$");
    private static final Pattern USERNAME_REGEX = Pattern.compile("^[A-Za-z0-9_]{4,30}$");

    public static boolean isBlank(String val) {
        return val == null || val.trim().isEmpty();
    }

    public static boolean isValidEmail(String email) {
        return !isBlank(email) && EMAIL_REGEX.matcher(email.trim()).matches();
    }

    public static boolean isValidPhone(String phone) {
        return !isBlank(phone) && PHONE_REGEX.matcher(phone.trim()).matches();
    }

    public static boolean isValidUsername(String username) {
        return !isBlank(username) && USERNAME_REGEX.matcher(username.trim()).matches();
    }

    public static boolean isValidPassword(String password) {
        return password != null && password.length() >= 6;
    }
}