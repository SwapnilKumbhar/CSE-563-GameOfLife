package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URI;

public class Menu extends JMenuBar {
    public JMenuBar jMenu;
    public JMenu jHelp, jPattern, jGame;
    public JMenuItem jExp, jAbout, jCode;
    public JMenuItem jP1, jP2, jP3;
    public JMenuItem jStart, JStop, JNext, JSpeed;

    //public String explanationText = "<html><ul><li>First</li><li>Second</li></ul></html>";
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

</body>
</html>
            """;

    public Menu()
    {
        jMenu = new JMenuBar();
        jGame = new JMenu("Game");
        jMenu.add(jGame);
        jPattern = new JMenu("Choose Pattern");
        jMenu.add(jPattern);
        jHelp = new JMenu("Help");
        jMenu.add(jHelp);
        jExp = new JMenuItem("Explanation");
        jAbout = new JMenuItem("About");
        jCode = new JMenuItem("Code");
        jP1 = new JMenuItem("Pattern 1");
        jP2 = new JMenuItem("Pattern 2");
        jP3 = new JMenuItem("Pattern 3");
        jStart = new JMenuItem("Start");
        JStop = new JMenuItem("Stop");
        JNext = new JMenuItem("Next");
        JSpeed = new JMenuItem("Speed");
        jHelp.add(jExp);
        jHelp.add(jAbout);
        jHelp.add(jCode);
        jPattern.add(jP1);
        jPattern.add(jP2);
        jPattern.add(jP3);
        jGame.add(jStart);
        jGame.add(JStop);
        jGame.add(JNext);
        jGame.add(JSpeed);
        jExp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show the explanation pane
                String finalExplanationHTML = explanationText.replace('\n',' ');
                JOptionPane.showMessageDialog(null, finalExplanationHTML);
            }
        });
        jAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Game of life\nThis Java Swing based implementation is developed by\n\nPrakhar Bajpayee\nSwapnil Kumbhar\nJaya Shankar Nalanagula\nQihao Qin\nManvi Sheri\n\nas a part of CSE-563 coursework");
            }
        });
        jCode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
                try {
                    desktop.browse(new URI("https://github.com/SwapnilKumbhar/CSE-563-GameOfLife"));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Source is available on GitHub at:\nhttps://github.com/SwapnilKumbhar/CSE-563-GameOfLife", "Source", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    public JMenuBar getMenuBar() {
        return jMenu;
    }
}