package GUI;

import java.util.concurrent.atomic.AtomicBoolean;

public class GameLoop implements Runnable {
    private final Grid gameGrid;
    private int refreshSpeed;
    private final AtomicBoolean running = new AtomicBoolean(false);

    @Override
    public void run() {
        running.set(true);
        while(running.get()) {
            gameGrid.resetCellSimulator();
            gameGrid.refreshGrid();
            try {
                Thread.sleep(refreshSpeed);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public GameLoop(Grid grid) {
        gameGrid = grid;
        refreshSpeed = 1200;
    }

    public void increaseSpeed() {
        // Shove off 0.3 second
        // 0.3 second limit.
        if (refreshSpeed - 300 < 300)
            return;
        refreshSpeed -= 300;
    }

    public void stop() {
        running.set(false);
    }

    public void decreaseSpeed() {
        if (refreshSpeed + 300 > 2000)
            return;
        refreshSpeed += 300;
    }

    public void start() {
        Thread gameThread = new Thread(this);
        gameThread.start();
    }
}
