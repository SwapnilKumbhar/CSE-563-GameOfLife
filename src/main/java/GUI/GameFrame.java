package GUI;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class GameFrame {

    private JFrame jframe;
    private JPanel gamePanel;
    private GridLayout gridLayout;
    private Grid grid;
    private Menu gameMenu;
    private GameLoop gameLoop;

    // Actions
    private StartAction startAction;
    private StopAction stopAction;
    private ClearAction clearAction;
    private IncreaseSpeedAction increaseSpeedAction;
    private DecreaseSpeedAction decreaseSpeedAction;
    private NextAction nextAction;

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

        gameLoop = new GameLoop(grid);

        gamePanel = new JPanel();
        gameMenu = new Menu(grid, this);
        gamePanel.setSize(700, 700);
        gamePanel.setLayout(gridLayout);
        gamePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Setup listeners
        startAction = new StartAction();
        stopAction = new StopAction();
        clearAction = new ClearAction();
        nextAction = new NextAction();
        increaseSpeedAction = new IncreaseSpeedAction();
        decreaseSpeedAction = new DecreaseSpeedAction();

        gamePanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('a'), "StartSimulation");
        gamePanel.getActionMap().put("StartSimulation", startAction);

        gamePanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('s'), "StopSimulation");
        gamePanel.getActionMap().put("StopSimulation", stopAction);

        gamePanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('d'), "NextSimulation");
        gamePanel.getActionMap().put("NextSimulation", nextAction);

        gamePanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('z'), "IncreaseSpeed");
        gamePanel.getActionMap().put("IncreaseSpeed", increaseSpeedAction);

        gamePanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('x'), "DecreaseSpeed");
        gamePanel.getActionMap().put("DecreaseSpeed", decreaseSpeedAction);

        gamePanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('c'), "Clear");
        gamePanel.getActionMap().put("Clear", clearAction);


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

    public void startGame() {
        gameLoop.start();
    }

    public void stopGame() {
        gameLoop.stop();
    }

    public void runSingleSimulation() {
        grid.resetCellSimulator();
        grid.refreshGrid();
    }

    public void increaseSpeed() {
        gameLoop.increaseSpeed();
    }

    public void decreaseSpeed() {
        gameLoop.decreaseSpeed();
    }

    public void showFrame() {
        jframe.setVisible(true);
    }


    // Action Classes
    class StartAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            gameLoop.start();
        }
    }
    class StopAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            gameLoop.stop();
        }
    }
    class ClearAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            grid.resetGrid();
        }
    }
    class IncreaseSpeedAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            gameLoop.increaseSpeed();
        }
    }

    class DecreaseSpeedAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            gameLoop.decreaseSpeed();
        }
    }

    class NextAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            grid.resetCellSimulator();
            grid.refreshGrid();
        }
    }
}
