package leetcode.concurrency;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;

/**
 * https://leetcode.com/problems/print-in-order/
 * 1114. Print in Order
 *
 */
class Print_in_Order_1114 {

    public Print_in_Order_1114() {
        
    }

    static volatile AtomicReference<Object> ref = new AtomicReference<Object>();

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        ref.set(new Integer(1));
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while(!new Integer(1).equals(ref.get()));
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        ref.set(new Integer(2));
    }

    public void third(Runnable printThird) throws InterruptedException {
        while(!new Integer(2).equals(ref.get()));
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}