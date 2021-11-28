package Entry;

import javax.swing.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("Game of Life.");
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setTitle("Game of Life");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
