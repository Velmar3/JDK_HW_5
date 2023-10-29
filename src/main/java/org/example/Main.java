package org.example;
/**
 * Есть пять философов (потоки), которые могут либо обедать либо размышлять.
 * Каждый философ должен пообедать три раза. Каждый прием пищи длиться 500 миллисекунд
 * После каждого приема пищи философ должен размышлять
 * Не должно возникнуть общей блокировки
 * Философы не должны есть больше одного раза подряд
 */

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    static AtomicInteger philosopherA = new AtomicInteger(); // 0 - Обедает, 1 - Размышляет
    static AtomicInteger philosopherB = new AtomicInteger();
    static AtomicInteger philosopherC = new AtomicInteger();
    static AtomicInteger philosopherD = new AtomicInteger();
    static AtomicInteger philosopherE = new AtomicInteger();

    public static void main(String[] args) {

        philosopherA.set(0);
        philosopherB.set(0);
        philosopherC.set(0);
        philosopherD.set(0);
        philosopherE.set(0);

        Date date = new Date();

        Thread philosophA = new Thread(() -> {
            try {
                for (int i = 0; i < 3; i++) {
                    System.out.println(date + " Филосов 1 обедает");
                    Thread.sleep(500);
                    philosopherA.set(1);
                    System.out.println(date + " Филосов 1 размышляет");
                    Thread.sleep(3000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread philosophB = new Thread(() -> {
            try {
                for (int i = 0; i < 3; i++) {
                    System.out.println(date + " Филосов 2 обедает");
                    Thread.sleep(500);
                    philosopherA.set(1);
                    System.out.println(date + " Филосов 2 размышляет");
                    Thread.sleep(3000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread philosophC = new Thread(() -> {
            try {
                for (int i = 0; i < 3; i++) {
                    System.out.println(date + " Филосов 3 обедает");
                    Thread.sleep(500);
                    philosopherA.set(1);
                    System.out.println(date + " Филосов 3 размышляет");
                    Thread.sleep(3000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread philosophD = new Thread(() -> {
            try {
                for (int i = 0; i < 3; i++) {
                    System.out.println(date + " Филосов 4 обедает");
                    Thread.sleep(500);
                    philosopherA.set(1);
                    System.out.println(date + " Филосов 4 размышляет");
                    Thread.sleep(3000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread philosophE = new Thread(() -> {
            try {
                for (int i = 0; i < 3; i++) {
                    System.out.println(date + " Филосов 5 обедает");
                    Thread.sleep(500);
                    philosopherA.set(1);
                    System.out.println(date + " Филосов 5 размышляет");
                    Thread.sleep(3000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        philosophA.start();
        philosophB.start();
        philosophC.start();
        philosophD.start();
        philosophE.start();

    }
}