package leetcode.concurrency;

import java.util.concurrent.Semaphore;

/**
 * https://leetcode.com/problems/print-in-order/
 * 1114. Print in Order
 *
 */
class Print_in_Order_1114 {
    /**
     * Conceptually, a semaphore maintains a set of permits.
     * Each acquire blocks if necessary until a permit is available, and then takes it.
     * Each release adds a permit, potentially releasing a blocking acquirer.
     */
    Semaphore run2, run3;
    public Print_in_Order_1114() {
        run2 = new Semaphore(0);
        run3 = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        run2.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        run2.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        run3.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        run3.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

    public static void main(String[] args) throws InterruptedException {
        Print_in_Order_1114 app = new Print_in_Order_1114();
        Thread t2 = new Thread() {
            @java.lang.Override
            public void run() {
                System.out.println("second");
            }
        };
        Thread t3 = new Thread() {
            @java.lang.Override
            public void run() {
                System.out.println("third");
            }
        };
        Thread t1 = new Thread() {
            @java.lang.Override
            public void run() {
                System.out.println("first");
            }
        };
        app.second(t2);
        Thread.sleep(500);
        app.third(t3);
        Thread.sleep(500);
        app.first(t1);

        t2.start();
        t3.start();
        t1.start();
    }
}