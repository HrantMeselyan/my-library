package com.example.authorBookServlet.util;

import java.util.regex.Pattern;

public final class EmailUtil {
    private EmailUtil() {
    }

    private static final String REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    public static boolean patternMatches(String emailAddress) {
        return Pattern.compile(REGEX)
                .matcher(emailAddress)
                .matches();
    }
}
