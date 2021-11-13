package leetcode.concurrency;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

// TODO
class Fizz_Buzz_Multithreaded_1195 {
    private int n;

    public Fizz_Buzz_Multithreaded_1195(int n) {
        this.n = n;
    }

    final Semaphore fizz = new Semaphore(0);
    final Semaphore buzz = new Semaphore(0);
    final Semaphore fizzbuzz = new Semaphore(0);
    final Semaphore num = new Semaphore(1);

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        fizz.acquire();
        System.out.print("fizz");
        num.release();
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 != 0) {
                fizz.release();
            } else if (i % 3 != 0 && i % 5 == 0) {
                buzz.release();
            } else if (i % 15 == 0) {
                fizzbuzz.release();
            } else {
                num.acquire();
                System.out.print(i);
            }
        }
    }
}