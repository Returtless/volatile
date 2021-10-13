package com.company;

class User extends Thread {
    public static int TIMEOUT = 2000;
    private final Box box;

    public User(Box box) {
        this.box = box;
    }

    @Override
    public void run() {
        while (box.counter > 0) {
            if (!box.isEnabled) {
                try {
                    Thread.sleep(TIMEOUT);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                box.isEnabled = true;
                box.decCounter();
                System.out.println("Коробка сменила состояние на ВКЛЮЧЕН");
            }
        }
    }
}