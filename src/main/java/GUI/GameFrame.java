package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.List;

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

        // Set up grid
        int rows = 50;
        int cols = 50;
        gridLayout = new GridLayout(rows, cols, 0, 0);
        grid = new Grid(rows, cols);

        gamePanel = new JPanel();
        gamePanel.setSize(700, 700);
        gamePanel.setLayout(gridLayout);
        gamePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Add buttons to the grid
        List<List<GridButton>> buttons = grid.getGridButtons();
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                gamePanel.add(buttons.get(r).get(c).get());
            }
        }

        jframe.add(gamePanel);
    }

    public void showFrame() {
        jframe.setVisible(true);
    }


    public void refreshGrid() {

    }
}