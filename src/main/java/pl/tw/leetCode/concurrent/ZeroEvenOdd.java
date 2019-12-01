package pl.tw.leetCode.concurrent;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class ZeroEvenOdd {

    private int n;

    Semaphore sZero = new Semaphore(1);
    Semaphore sOdd = new Semaphore(0);
    Semaphore sEven = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            sZero.acquire();

            printNumber.accept(0);
            if ((i + 1) % 2 == 1) {
                sOdd.release();
            } else {
                sEven.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= (n + 1) / 2; i++) {
            sEven.acquire();
            printNumber.accept(i * 2);
            sZero.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n / 2; i++) {
            sOdd.acquire();
            printNumber.accept(i * 2 + 1);
            sZero.release();
        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(200);
        new Thread(() -> {
            try {
                zeroEvenOdd.zero(System.out::println);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                zeroEvenOdd.even(System.out::println);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                zeroEvenOdd.odd(System.out::println);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}