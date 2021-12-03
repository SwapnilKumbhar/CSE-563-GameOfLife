package GUI;

import javax.swing.*;
import java.awt.*;
import java.net.URI;

public class Menu extends JMenuBar {
    public JMenuBar jMenu;
    public JMenu jHelp, jPattern, jGame;
    public JMenuItem jExp, jAbout, jCode, jClear;
    public JMenuItem jP1, jP2, jP3;
    public JMenuItem jStart, jStop, jNext, jIncreaseSpeed, jDecreaseSpeed;
    public Grid grid;
    private GameFrame gameFrame;

    public String explanationText = """
<html>
<body>
    <section>
        <h2>Game of Life rules</h2>
        <summary>For a space that is populated:</summary>
        <ol>
                  <li>Each cell with one or no neighbors dies, as if by solitude.</li>
                  <li>Each cell with four or more neighbors dies, as if by overpopulation.</li>
                  <li>Each cell with two or three neighbors survives.</li>
        </ol>
        <summary>For a space that is empty or unpopulated:</summary>
        <ol>
             <li>Each cell with three neighbors becomes populated.</li>
         </ol>
    </section>
    <section>
        <p><b>The Controls<b></p>
	<ul>
        <li>Click on various cells of the grid to initialise the living cells in Generation 0</li>
        <li>Click on Game->Start to start the game</li>
        <li>Click on Game->Stop to stop the game</li>
        <li>Click on Game->Next to step one generation</li>
        <li>Click on Game->Speed to change the speed of generations</li>
	<ul>
    </section>
    
    <section>
        <p><b>KeyBindings<b></p>
	<ul>
	    <li>a -> Start Game </li>
	    <li>s -> Stop Game </li>
	    <li>d -> Next Simulation </li>
	    <li>z -> Decrease Speed </li>
	    <li>x -> Increase Speed </li>
	    <li>c -> Clear Grid </li>
	<ul>
    </section>

</body>
</html>
            """;

    public Menu(Grid grid, GameFrame gameFrame)
    {
        this.grid = grid;
        jMenu = new JMenuBar();
        jGame = new JMenu("Game");
        this.gameFrame = gameFrame;

        jMenu.add(jGame);
        jPattern = new JMenu("Choose Pattern");
        jMenu.add(jPattern);
        jClear = new JMenuItem("Clear");
        jMenu.add(jClear);
        jHelp = new JMenu("Help");
        jMenu.add(jHelp);

        jExp = new JMenuItem("Explanation");
        jAbout = new JMenuItem("About");

        jCode = new JMenuItem("Code");
        jP1 = new JMenuItem("Elbow");
        jP2 = new JMenuItem("Diamond");
        jP3 = new JMenuItem("Random Fill");

        jStart = new JMenuItem("Start");
        jStop = new JMenuItem("Stop");

        jNext = new JMenuItem("Next");
        jIncreaseSpeed = new JMenuItem("Increase Speed");
        jDecreaseSpeed = new JMenuItem("Decrease Speed");

        jHelp.add(jExp);
        jHelp.add(jAbout);
        jHelp.add(jCode);

        jPattern.add(jP1);
        jPattern.add(jP2);
        jPattern.add(jP3);

        jGame.add(jStart);
        jGame.add(jStop);
        jGame.add(jNext);
        jGame.add(jIncreaseSpeed);
        jGame.add(jDecreaseSpeed);

        jClear.addActionListener(e -> grid.resetGrid());

        jP1.addActionListener(e -> {
            grid.resetGrid();
            grid.gridButtons.get(10).get(10).toggleActive();
            grid.gridButtons.get(11).get(11).toggleActive();
            grid.gridButtons.get(12).get(9).toggleActive();
            grid.gridButtons.get(12).get(10).toggleActive();
            grid.gridButtons.get(12).get(11).toggleActive();
            grid.resetCellSimulator();
        });

        jP2.addActionListener(e -> {
            grid.resetGrid();
            for(int c = 23; c < 27; c++) {
                grid.gridButtons.get(21).get(c).toggleActive();
                grid.gridButtons.get(29).get(c).toggleActive();
            }
            for(int c = 21; c < 29; c++) {
                grid.gridButtons.get(23).get(c).toggleActive();
                grid.gridButtons.get(27).get(c).toggleActive();
            }
            for(int c = 19; c < 31; c++) {
                grid.gridButtons.get(25).get(c).toggleActive();
            }
            grid.resetCellSimulator();
        });

        jP3.addActionListener(e -> {
            grid.resetGrid();
            for (int i=0; i<50; i++) {
                for (int j=0; j<50; j++) {
                    if (Math.random()*100 < 10) {
                        grid.gridButtons
                                .get(i)
                                .get(j)
                                .toggleActive();
                    }
                }
            }
            grid.resetCellSimulator();
        });

        jExp.addActionListener(e -> {
            // Show the explanation pane
            String finalExplanationHTML = explanationText.replace('\n',' ');
            JOptionPane.showMessageDialog(null, finalExplanationHTML);
        });

        jAbout.addActionListener(e -> JOptionPane.showMessageDialog(null, "Game of life\nThis Java Swing based implementation is developed by\n\nPrakhar Bajpayee\nSwapnil Kumbhar\nJaya Shankar Nalanagula\nQihao Qin\nManvi Sheri\n\nas a part of CSE-563 coursework"));

        jCode.addActionListener(e -> {
            Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
            try {
                desktop.browse(new URI("https://github.com/SwapnilKumbhar/CSE-563-GameOfLife"));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Source is available on GitHub at:\nhttps://github.com/SwapnilKumbhar/CSE-563-GameOfLife", "Source", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        jStart.addActionListener(e -> {
            gameFrame.startGame();
        });

        jStop.addActionListener(e -> {
            gameFrame.stopGame();
        });

        jNext.addActionListener(e -> {
            gameFrame.runSingleSimulation();
        });

        jIncreaseSpeed.addActionListener(e -> {
            gameFrame.increaseSpeed();
        });

        jDecreaseSpeed.addActionListener(e -> {
            gameFrame.decreaseSpeed();
        });
    }

    public JMenuBar getMenuBar() {
        return jMenu;
    }

}