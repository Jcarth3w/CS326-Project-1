package search_solutions;

import core_search.BaseSearch;
import core_search.FIFOQueue;
import core_search.LIFOQueue;
import search_problems.SlidingTilePuzzle;

import java.util.ArrayList;

public class SlidingPuzzleDFS extends BaseSearch<ArrayList<Integer>, String>
{
    public SlidingPuzzleDFS()
    {
        super(new SlidingTilePuzzle(), new LIFOQueue<>());
    }

    public static void main(String[] args) {
        SlidingPuzzleDFS s = new SlidingPuzzleDFS();
        s.search();
    }
}
