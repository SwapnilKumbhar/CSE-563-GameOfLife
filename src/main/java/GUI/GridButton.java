package GUI;

import javax.swing.*;
import java.awt.*;

public class GridButton {
    private JButton btn;

    public GridButton() {
        btn = new JButton("");
        btn.setPreferredSize(new Dimension(15, 15));
        btn.setEnabled(false);
    }

    public JButton get() {
        return this.btn;
    }

    public void setActive() {
        //
    }
}
