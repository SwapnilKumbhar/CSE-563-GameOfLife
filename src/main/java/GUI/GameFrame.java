package GUI;

import javax.swing.*;

import Core.CellSimulation;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.Arrays;

public class GameFrame {

    private JFrame jframe;
    private JPanel gamePanel;
    private GridLayout gridLayout;
    private Grid grid;
    private Menu gameMenu;

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
        gameMenu = new Menu();
        gamePanel.setSize(700, 700);
        gamePanel.setLayout(gridLayout);
        gamePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Setup listeners
        gamePanel.setFocusable(true);
        gamePanel.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                switch(e.getKeyChar()) {
                    case 'd': // Next simulation
                        gameMenu.runSingleSimulation();
                        break;
                    case 'a': // Start simulation
                        gameMenu.startGame();
                        break;
                    case 's': // Stop simulation
                        gameMenu.stopGame();
                        break;
                    default:
                        // Do nothing
                        break;
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // Do nothing
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Do nothing
            }
        });

        // Add buttons to the grid
        List<List<GridButton>> buttons = grid.getGridButtons();
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                gamePanel.add(buttons.get(r).get(c).get());
            }
        }
        jframe.setJMenuBar(gameMenu.getMenuBar());

        jframe.add(gamePanel);

    }

    public void showFrame() {
        jframe.setVisible(true);
    }


    public void refreshGrid() {
        grid.resetGrid();

        //convert grid to bool array
        boolean[][] listOfBooleansToReturn = new boolean[52][52];
        Arrays.fill(listOfBooleansToReturn, Boolean.FALSE);
        for(int row = 0; row < grid.gridButtons.size(); row++) {
            for(int col = 0; col < grid.gridButtons.get(row).size(); col++) {
                if(grid.gridButtons.get(row).get(col).getIsActive())
                {
                    listOfBooleansToReturn[row+1][col+1] = true;
                }
            }
        }

        //call nextIterationProvider();

        boolean[][] booleanListOfCells = grid.cell.nextIterationProvider(listOfBooleansToReturn);
        for(int i = 1; i < 51; i++)
        {
            for(int j = 1; j < 51; j++)
            {
                if(booleanListOfCells[i][j] == true)
                {
                    grid.setCellActive(i, j);
                }
            }
        }
        //grid updated
    }


}