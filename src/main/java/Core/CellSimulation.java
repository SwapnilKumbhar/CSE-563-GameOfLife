package Core;

import GUI.Grid;

public class CellSimulation {

    boolean[][] current_cell_status;
    boolean[][] next_cell_status;

    public CellSimulation(boolean[][] initialState) {
        //TODO: Pad the grid borders
        //TODO: Send initial state
        current_cell_status = initialState;
    }


    public void simulate() {

        for(int i=1;i<51;i++)
        {
            for(int j=1;j<51;j++)
            {
                int counter = 0;

                //Padding the real grid
                if(current_cell_status[i-1][j-1]==true){ counter++; }
                if(current_cell_status[i-1][j]==true){ counter++; }
                if(current_cell_status[i][j+1]==true){ counter++; }

                if(current_cell_status[i][j-1]==true){ counter++; }
                if(current_cell_status[i][j+1]==true){ counter++; }

                if(current_cell_status[i+1][j-1]==true){ counter++; }
                if(current_cell_status[i+1][j]==true){ counter++; }
                if(current_cell_status[i+1][j+1]==true){ counter++; }

                //Simluate the next generation*
                if(current_cell_status[i][j]==true){

                    if(2<=counter && counter<=3){ next_cell_status[i][j]=true; }
                    else{ next_cell_status[i][j]=false; }
                }
                else{
                    if(counter == 3){ next_cell_status[i][j]=true; }
                    else{ next_cell_status[i][j]=false; }
                }

            }
            //System.out.println(current_cell_status[i][0]); //test
        }

        //update the current cell status
        current_cell_status=next_cell_status;
    }

    public boolean[][] getNextState() {
        // TODO: Return new grid. The next generation.
        return next_cell_status;
    }
}
