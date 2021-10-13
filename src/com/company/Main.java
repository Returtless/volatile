package com.company;

public class Main {

    public static void main(String[] args) {
        Box box = new Box();
        User user = new User(box);

        new Thread(box).start();
        new Thread(user).start();
    }
}
