// multithreading.java

class GameLoading extends Thread {
    public void run() {
        try {
            System.out.println("Game loading started...");
            Thread.sleep(5000); // 5 seconds
            System.out.println("Game loading completed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MusicLoading {
    void loadMusic() {
        System.out.println("Music loading started");
    }
}

public class multithreading {
    public static void main(String[] args) {

        GameLoading g = new GameLoading();
        MusicLoading m = new MusicLoading();

        g.start(); // Runs game loading in background thread
        m.loadMusic(); // Runs immediately in main thread
    }
}