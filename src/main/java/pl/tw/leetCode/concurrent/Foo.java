package pl.tw.leetCode.concurrent;

import java.util.concurrent.Semaphore;

class Foo {

    private final Semaphore firstLock = new Semaphore(1);
    private final Semaphore secondLock = new Semaphore(0);
    private final Semaphore thirdLock = new Semaphore(0);

    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        firstLock.acquireUninterruptibly();
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        secondLock.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        secondLock.acquireUninterruptibly();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        thirdLock.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        thirdLock.acquireUninterruptibly();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        firstLock.release();
    }

    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();

        new Thread(() -> {
            try {
                foo.second(() -> System.out.println("second"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                foo.third(() -> System.out.println("third"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                foo.first(() -> System.out.println("first"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        new Thread(() -> {
            try {
                foo.first(() -> System.out.println("first"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                foo.second(() -> System.out.println("second"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                foo.third(() -> System.out.println("third"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}