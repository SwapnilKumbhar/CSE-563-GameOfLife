package Core;

import GUI.Grid;

public class CellSimulation {

    boolean[][] current_cell_status;
    boolean[][] next_cell_status;

    public CellSimulation(boolean[][] initialState) {
        //TODO: Pad the grid borders
        //TODO: Send initial state
        current_cell_status = initialState;
        // Initialise default array
        next_cell_status = new boolean[52][52];
    }

    //Add a function to take in the currentState work on the simulation and return the nextState back. This is all we will need from Qihao's
    public boolean[][] nextIterationProvider()
    {
        // current_cell_status = currentState;
        simulate();
        return getNextState();
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
                if(current_cell_status[i-1][j+1]==true){ counter++; }

                if(current_cell_status[i][j-1]==true){ counter++; }
                if(current_cell_status[i][j+1]==true){ counter++; }

                if(current_cell_status[i+1][j-1]==true){ counter++; }
                if(current_cell_status[i+1][j]==true){ counter++; }
                if(current_cell_status[i+1][j+1]==true){ counter++; }

                //Simluate the next generation*
                if(current_cell_status[i][j]==true){

                    if(2<=counter && counter<=3){ next_cell_status[i][j]=true; }

                }
                else{
                    if(counter == 3){ next_cell_status[i][j]=true; }
                }

            }
            //System.out.println(current_cell_status[i][0]); //test
        }

        //update the current cell status
        current_cell_status = next_cell_status;
    }

    public boolean[][] getNextState() {
        // TODO: Return new grid. The next generation.
        current_cell_status = next_cell_status;
        return next_cell_status;
    }
}
