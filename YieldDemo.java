class YieldDemo extends Thread {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(
                    Thread.currentThread().getName() + " running");
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        YieldDemo t1 = new YieldDemo();
        YieldDemo t2 = new YieldDemo();

        t1.setName("Thread-A");
        t2.setName("Thread-B");

        t1.start();
        t2.start();
    }
}
