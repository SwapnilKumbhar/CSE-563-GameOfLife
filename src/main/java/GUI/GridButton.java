package GUI;

import javax.swing.*;
import java.awt.*;

public class GridButton {
    private JButton btn;
    private boolean isActive;
    private static final Color activeColor = Color.BLUE;
    private static final Color inactiveColor = Color.WHITE;

    public GridButton() {
        btn = new JButton("");
        btn.setPreferredSize(new Dimension(15, 15));
        btn.setEnabled(true);
        btn.setBackground(inactiveColor);
        btn.setOpaque(true);
        isActive = false;

        // Handler for grid
        btn.addActionListener(event -> {
            toggleActive();
        });
    }

    public JButton get() {
        return this.btn;
    }

    public void toggleActive() {
        isActive = !isActive;
        if (isActive) {
            btn.setBackground(activeColor);
        }
        else {
            btn.setBackground(inactiveColor);
        }
    }

    public boolean getIsActive() {
        return isActive;
    }

}
