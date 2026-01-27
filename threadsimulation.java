class GameLoading extends Thread {

    @Override
    public void run() {
        System.out.println("Game loading started");
        try {
            Thread.sleep(2000); // Simulates long loading task
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Game loading completed");
    }
}

public class threadsimulation {
    public static void main(String[] args) {

        GameLoading game = new GameLoading();

        // Start game loading in background thread
        game.start();

        // Main thread continues execution
        System.out.println("Main application continues running");
    }
}