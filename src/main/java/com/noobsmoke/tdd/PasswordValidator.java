package com.noobsmoke.tdd;

import java.util.function.Predicate;

public class PasswordValidator implements Predicate<String> {


    @Override
    public boolean test(String s) {
        return s != null && !s.isBlank();
    }
}
