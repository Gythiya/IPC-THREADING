public class PriorityDemo extends Thread {

    @Override
    public void run() {
        System.out.println(
                Thread.currentThread().getName() +
                        " with priority " +
                        Thread.currentThread().getPriority());
    }

    public static void main(String[] args) {

        PriorityDemo t1 = new PriorityDemo();
        PriorityDemo t2 = new PriorityDemo();
        PriorityDemo t3 = new PriorityDemo();

        t1.setName("Thread-A");
        t2.setName("Thread-B");
        t3.setName("Thread-C");

        t1.setPriority(10); // highest
        t2.setPriority(5); // normal
        t3.setPriority(1); // lowest

        t1.start();
        t2.start();
        t3.start();
    }
}