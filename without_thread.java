// without_thread.java

class GameLoading {
    void loadGame() {
        try {
            System.out.println("Game loading started...");
            Thread.sleep(20000); // 20 seconds
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

public class without_thread {
    public static void main(String[] args) {

        GameLoading g = new GameLoading();
        MusicLoading m = new MusicLoading();

        g.loadGame(); // Takes 20 seconds (blocks main thread)
        m.loadMusic(); // Runs only after game loading finishes
    }
}