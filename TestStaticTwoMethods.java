class Printer {

    static synchronized void printHello() {
        System.out.println(
                "Start Hello - " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
        System.out.println(
                "End Hello - " + Thread.currentThread().getName());
    }

    static synchronized void printWorld() {
        System.out.println(
                "Start World - " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
        System.out.println(
                "End World - " + Thread.currentThread().getName());
    }
}

public class TestStaticTwoMethods {
    public static void main(String[] args) {

        Thread t1 = new Thread(
                () -> Printer.printHello(), "Thread-A");
        Thread t2 = new Thread(
                () -> Printer.printWorld(), "Thread-B");

        t1.start();
        t2.start();
    }
}
