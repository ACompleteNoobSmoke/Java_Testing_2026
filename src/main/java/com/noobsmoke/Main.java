package com.noobsmoke;

import com.github.javafaker.Faker;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Faker faker = new Faker();
        System.out.println(faker.name().name());
        System.out.println(faker.address().cityName());
    }
}
