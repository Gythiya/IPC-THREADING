class Counter {
    static int count = 0;

    static synchronized void increment() {
        count++;
        System.out.println(
                Thread.currentThread().getName() +
                        " Count: " + count);
    }
}

public class TestStaticSync {
    public static void main(String[] args) {
        Thread t1 = new Thread(Counter::increment, "Thread-A");
        Thread t2 = new Thread(Counter::increment, "Thread-B");

        t1.start();
        t2.start();
    }
}
