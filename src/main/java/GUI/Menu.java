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
    public JFrame jframe;

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
            //File pdfFile = new File("Desktop\\script.txt");
            @Override
            public void actionPerformed(ActionEvent e) {
                Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
                try {
                    desktop.browse(new URI("https://tinyurl.com/5bw8pt63"));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Source is available on GitHub at:\nhttps://github.com/SwapnilKumbhar/CSE-563-GameOfLife", "Source", JOptionPane.INFORMATION_MESSAGE);
                }
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