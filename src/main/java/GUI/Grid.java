package GUI;

import java.util.ArrayList;
import java.util.List;

class Grid {

    private int rows = 0;
    private int cols = 0;
    List<List<GridButton>> gridButtons;

    public Grid(int rows, int cols) {

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
}
