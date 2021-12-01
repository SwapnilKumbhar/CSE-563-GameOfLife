package Entry;

import GUI.GameFrame;

public class Application {
    public static void main(String[] args) {
        System.out.println("Game of Life.");
        GameFrame gameFrame = new GameFrame();
        gameFrame.showFrame();
    }
}
