package pl.tw.leetCode.concurrent;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class FizzBuzz {

    private int n;
    private int currentIteration = 1;
    private boolean done = false;


    private Semaphore fizzSemaphore = new Semaphore(0);
    private Semaphore buzzSemaphore = new Semaphore(0);
    private Semaphore fizzBuzzSemaphore = new Semaphore(0);
    private Semaphore numberSemaphore = new Semaphore(1);


    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (true) {
            fizzSemaphore.acquireUninterruptibly();
            if (done) break;
            printFizz.run();
            unlockNextSemaphore();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (true) {
            buzzSemaphore.acquireUninterruptibly();
            if (done) break;
            printBuzz.run();
            unlockNextSemaphore();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (true) {
            fizzBuzzSemaphore.acquireUninterruptibly();
            if (done) break;
            printFizzBuzz.run();
            unlockNextSemaphore();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            numberSemaphore.acquireUninterruptibly();
            if (done) break;
            printNumber.accept(currentIteration);
            unlockNextSemaphore();
        }
    }

    private void unlockNextSemaphore() {
        if (currentIteration == n) {
            done = true;
            fizzBuzzSemaphore.release();
            fizzSemaphore.release();
            buzzSemaphore.release();
            numberSemaphore.release();
            return;
        }
        currentIteration++;

        if (currentIteration % 3 == 0 && currentIteration % 5 == 0) {
            fizzBuzzSemaphore.release();
        } else if (currentIteration % 3 == 0) {
            fizzSemaphore.release();
        } else if (currentIteration % 5 == 0) {
            buzzSemaphore.release();
        } else {
            numberSemaphore.release();
        }
    }

    public static void main(String[] args) {
        FizzBuzz fooBar = new FizzBuzz(200);
        new Thread(() -> {
            try {
                fooBar.fizz(() -> System.out.println("fizz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                fooBar.buzz(() -> System.out.println("buzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                fooBar.fizzbuzz(() -> System.out.println("fizzBuzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                fooBar.number(System.out::println);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
