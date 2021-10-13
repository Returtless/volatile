package com.company;

public class Box extends Thread {
    public static int TIMEOUT = 100;
    public int counter = 10;

    volatile boolean isEnabled;

    @Override
    public void run() {
        while (counter > 0) {
            if (isEnabled) {
                try {
                    Thread.sleep(TIMEOUT);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.isEnabled = false;
                System.out.println("Коробка сменила состояние на ВЫКЛЮЧЕН\n");
            }
        }
    }

    public void decCounter() {
        this.counter--;
    }
}
