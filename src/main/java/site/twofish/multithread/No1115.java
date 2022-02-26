package site.twofish.multithread;

/**
 * @author ganggang
 * @since 2022/02/26
 * 1115. 交替打印 FooBar
 * https://leetcode-cn.com/problems/print-foobar-alternately/
 */

class FooBar {
    private int n;
    private static Object lock = new Object();
    private static volatile boolean fooed = false;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        synchronized (lock) {
            for (int i = 0; i < n; i++) {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                fooed = true;
                lock.notifyAll();
                lock.wait();
            }
            lock.notifyAll();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        synchronized (lock) {
            if (!fooed) {
                lock.wait();
            }
            for (int i = 0; i < n; i++) {
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                lock.notifyAll();
                lock.wait();
            }
            lock.notifyAll();
        }
    }
}

public class No1115 {
    public static void main(String[] args) {
        FooBar fooBar = new FooBar(2);
        Thread foo = new Thread(() -> {
            try {
                fooBar.foo(() -> {
                    System.out.println("foo");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "foo-thread");
        Thread bar = new Thread(() -> {
            try {
                fooBar.bar(() -> {
                    System.out.println("bar");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "bar-thread");
        foo.start();
        bar.start();
    }

}
