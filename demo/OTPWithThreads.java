package demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OTPWithThreads {

    // 🔴 3 THREADS DECLARED HERE
    private static final ExecutorService executor = Executors.newFixedThreadPool(3);

    public static void main(String[] args) {

        System.out.println("User clicked SEND OTP");

        processOTP();

        System.out.println("User moves to OTP verification screen");

        // Graceful shutdown
        executor.shutdown();
    }

    static void processOTP() {

        // 🔴 All three tasks run in BACKGROUND THREADS
        executor.submit(() -> generateOTP());
        executor.submit(() -> storeOTP());
        executor.submit(() -> sendOTP());
    }

    static void generateOTP() {
        sleep(500);
        System.out.println("OTP generated");
    }

    static void storeOTP() {
        sleep(1000);
        System.out.println("OTP stored in database");
    }

    static void sendOTP() {
        sleep(3000);
        System.out.println("OTP sent to user");
    }

    static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}