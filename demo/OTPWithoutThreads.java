package demo;

public class OTPWithoutThreads {

    public static void main(String[] args) {

        System.out.println("User clicked SEND OTP");

        generateAndSendOTP();

        System.out.println("User moves to OTP verification screen");
    }

    static void generateAndSendOTP() {
        String otp = generateOTP();
        sendOTP(otp);
    }

    static String generateOTP() {
        sleep(500);
        String otp = "123456";
        System.out.println("OTP generated: " + otp);
        return otp;
    }

    static void sendOTP(String otp) {
        System.out.println("Sending OTP...");
        sleep(3000); // simulate SMS delay
        System.out.println("OTP sent successfully: " + otp);
    }

    static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}