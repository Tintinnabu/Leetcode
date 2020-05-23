package top.tinn.MultiThreading.Problem_1114;

/**
 * @ClassName Foo
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/23 20:37
 */
public class Foo {
    private int flag = 0;
    private Object lock = new Object();
    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (lock){
            while (flag != 0){
                lock.wait();
            }
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            flag = 1;
            lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock){
            while (flag != 1){
                lock.wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            flag = 2;
            lock.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock){
            while (flag != 2){
                lock.wait();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            flag = 0;
            lock.notifyAll();
        }
    }

    public static void main(String[] args) {
        Foo foo1 =  new Foo();
        Thread thread1 = new Thread(()->{
            try {
                foo1.first(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("one");
                    }
                });
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo1.second(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("two");
                        }
                    });
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo1.third(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("three");
                        }
                    });
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        thread3.start();
        thread2.start();
        thread1.start();
    }
}
