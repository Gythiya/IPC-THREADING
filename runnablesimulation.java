// Simulating a parent application module
class ApplicationModule {
    void initialize() {
        System.out.println("Application initialization completed");
    }
}

// GameLoading task runs in background
class GameLoading extends ApplicationModule implements Runnable {

    @Override
    public void run() {
        System.out.println("Game loading started in background");
        try {
            Thread.sleep(2000); // Simulates long loading task
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Game loading completed");
    }
}

public class runnablesimulation {
    public static void main(String[] args) {

        GameLoading game = new GameLoading();

        // Parent class functionality is available
        game.initialize();

        // Run game loading in a separate thread
        Thread t = new Thread(game);
        t.start();

        // Main thread continues execution
        System.out.println("Main application continues running");
    }
}