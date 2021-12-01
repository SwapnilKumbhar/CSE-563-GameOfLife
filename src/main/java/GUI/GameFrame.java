package GUI;

import javax.swing.*;
import java.awt.*;

public class GameFrame {

    private JFrame jframe;
    private JPanel gamePanel;
    private GridLayout gridLayout;
    private Grid grid;

    public GameFrame() {
        this.jframe = new JFrame();
        jframe.setTitle("Game of Life");
        jframe.setSize(new Dimension(800, 800));
        jframe.setResizable(false);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gridLayout = new GridLayout(5, 1, 0, 0);

        gamePanel = new JPanel();
        gamePanel.setSize(700, 700);
        gamePanel.setLayout(gridLayout);

        jframe.add(gamePanel);
    }

    public void showFrame() {
        jframe.setVisible(true);
    }


    public void refreshGrid() {

    }
}