package search_solutions;

import core_search.BaseSearch;
import core_search.FIFOQueue;
import search_problems.SlidingTilePuzzle;

import java.util.ArrayList;

public class SlidingPuzzleBFS extends BaseSearch<ArrayList<Integer>, String>
{
    public SlidingPuzzleBFS()
    {
        super(new SlidingTilePuzzle(), new FIFOQueue<>());
    }

    public SlidingPuzzleBFS(SlidingTilePuzzle s) {
        super(s, new FIFOQueue<>());
    }

    public static void main(String[] args) {
        SlidingPuzzleBFS s = new SlidingPuzzleBFS();
        s.search();
    }
}
