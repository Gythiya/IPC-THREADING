class BankAccount {
    int balance = 1000;

    synchronized void withdraw(int amount) {
        balance -= amount;
        System.out.println(
                Thread.currentThread().getName() +
                        " Balance: " + balance);
    }
}

public class TestNonStaticSync {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount();

        Thread t1 = new Thread(() -> acc.withdraw(500), "Thread-A");
        Thread t2 = new Thread(() -> acc.withdraw(500), "Thread-B");

        t1.start();
        t2.start();
    }
}
