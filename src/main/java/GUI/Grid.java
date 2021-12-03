package GUI;

import java.util.ArrayList;
import java.util.List;

public class Grid {

    private int rows;
    private int cols;
    List<List<GridButton>> gridButtons;

    public Grid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        gridButtons = new ArrayList<>();
        for(int row = 0; row < rows; row++) {
            List<GridButton> currentList = new ArrayList<>();
            for(int col = 0; col < cols; col++)
                currentList.add(new GridButton());
            gridButtons.add(currentList);
        }
    }

    List<List<GridButton>> getGridButtons() {
        return this.gridButtons;
    }

    void setCellActive(int row, int col) {
        if (row < rows && col < cols)
            this.gridButtons
                    .get(row)
                    .get(col)
                    .toggleActive();
    }

    void resetGrid() {
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                this.gridButtons
                        .get(row)
                        .get(col)
                        .setInactive();

            }
        }
    }
}
