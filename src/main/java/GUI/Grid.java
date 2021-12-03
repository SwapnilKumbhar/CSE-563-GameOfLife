package GUI;

import java.util.ArrayList;
import java.util.List;

import Core.CellSimulation;

public class Grid {

    private int rows;
    private int cols;
    public CellSimulation cell;
    public List<List<GridButton>> gridButtons;
    private boolean gamePlayState;

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
        gamePlayState = false;
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

    public void resetCellSimulator() {

        boolean[][] currentState = new boolean[52][52];
        for(int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (gridButtons.get(row).get(col).getIsActive()) {
                    currentState[row + 1][col + 1] = true;
                }
            }
        }

        this.cell = new CellSimulation(currentState);
    }

    public void refreshGrid() {

        this.resetGrid();

        //call nextIterationProvider();

        boolean[][] booleanListOfCells = this.cell.nextIterationProvider();
        for(int i = 1; i < 51; i++)
        {
            for(int j = 1; j < 51; j++)
            {
                if(booleanListOfCells[i][j] == true)
                {
                    this.setCellActive(i - 1, j - 1);
                }
            }
        }
        //grid updated
    }


}
