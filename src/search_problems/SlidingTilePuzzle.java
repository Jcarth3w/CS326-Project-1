package search_problems;

import core_search.Problem;
import core_search.Tuple;

import java.util.ArrayList;
import java.util.List;

public class SlidingTilePuzzle implements Problem<ArrayList<Integer>, String>
{
    private final int SIZE;
    //empty cell is 0
    private final ArrayList<Integer> INITIAL_STATE = new ArrayList<>(List.of(7,2,4, 5,0,6, 8,3,1));

    private final ArrayList<Integer> GOAL_STATE = new ArrayList<>(List.of(0,1,2,3,4,5,6,7,8));

    public SlidingTilePuzzle(){
        SIZE = (int)(Math.sqrt(INITIAL_STATE.size()));
    }

    public ArrayList<Tuple<ArrayList<Integer>, String>> execution(ArrayList<Integer> currentState)
    {
        int emptyCellPosition = -1;
        ArrayList<Tuple<ArrayList<Integer>, String>> possibleStates = new ArrayList<>();


        for(int i=0; i<currentState.size(); i++)
        {
            if(currentState.get(i) == 0)
            {
                emptyCellPosition = i;
                break;
            }
        }

        int r = emptyCellPosition / SIZE;
        int c = emptyCellPosition % SIZE;

        //can move up
        if(r > 0)
        {
            ArrayList<Integer> newState = new ArrayList<>(currentState);
            String moveUp = "up";
            Tuple<ArrayList<Integer>, String> newStateAction;

            int upIndex = emptyCellPosition - SIZE;
            int numInUpIndex = currentState.get(upIndex);

            newState.set(upIndex, 0);
            newState.set(emptyCellPosition, numInUpIndex);
            newStateAction = new Tuple<>(newState, moveUp, 1);
            possibleStates.add(newStateAction);
        }

        //can move down
        if(r < SIZE - 1)
        {
            ArrayList<Integer> newState = new ArrayList<>(currentState);
            String moveDown = "down";
            Tuple<ArrayList<Integer>, String> newStateAction;

            int downIndex = emptyCellPosition + SIZE;
            int numInDownIndex = currentState.get(downIndex);

            newState.set(downIndex, 0);
            newState.set(emptyCellPosition, numInDownIndex);
            newStateAction = new Tuple<>(newState, moveDown, 1);
            possibleStates.add(newStateAction);

        }

        //can move left
        if(c > 0)
        {
            ArrayList<Integer> newState = new ArrayList<>(currentState);
            String moveLeft = "left";
            Tuple<ArrayList<Integer>, String> newStateAction;

            int leftIndex = emptyCellPosition - 1;
            int numInLeftIndex = currentState.get(leftIndex);

            newState.set(leftIndex, 0);
            newState.set(emptyCellPosition, numInLeftIndex);
            newStateAction = new Tuple<>(newState, moveLeft, 1);
            possibleStates.add(newStateAction);
        }
        //can move right
        if(c < SIZE - 1)
        {
            ArrayList<Integer> newState = new ArrayList<>(currentState);
            String moveRight = "right";
            Tuple<ArrayList<Integer>, String> newStateAction;

            int rightIndex = emptyCellPosition + 1;
            int numInRightIndex = currentState.get(rightIndex);
            newState.set(rightIndex, 0);
            newState.set(emptyCellPosition, numInRightIndex);

            newStateAction = new Tuple<>(newState, moveRight, 1);
            possibleStates.add(newStateAction);

        }

        return possibleStates;

    }

    public void printState (ArrayList<Integer> state){
        for(int i = 0; i<state.size(); i++)
        {
            if(state.get(i) != 0)
            {
                System.out.printf("%3s", state.get(i)+" ");
            }
            else{
                System.out.print("   ");
            }

            if(i % SIZE == SIZE - 1)
            {
                System.out.println();
            }
        }
    }


    @Override
    public ArrayList<Integer> initialState() {
        return INITIAL_STATE;
    }

    public ArrayList<Integer> goalState() {
        return GOAL_STATE;
    }

    public int misplacedTiles(ArrayList<Integer> s)
    {
        int count = 0;

        for(int i=0; i<s.size(); i++)
        {
            if(s.get(i) == 0){
                continue;
            }
            else if (s.get(i) != GOAL_STATE.get(i))
            {
                count++;
            }
        }
        return count;
    }

    public int sumOfDistance(ArrayList<Integer> state)
    {
        int totalDistance = 0;
        for(int tile : state)
        {
            int goal_state = getTileGoalPosition(tile);
            int current_position = state.indexOf(tile);
            totalDistance += Math.abs(getRowNumber(current_position) - getRowNumber(goal_state));
            totalDistance += Math.abs(getColumnNumber(current_position) - getColumnNumber(goal_state));
        }
        return totalDistance;
    }

    private int getTileGoalPosition(int tile)
    {
        return goalState().indexOf(tile);
    }

    private int getColumnNumber(int tile)
    {
        return tile % SIZE;
    }

    private int getRowNumber(int tile)
    {
        return tile / SIZE;
    }


}
