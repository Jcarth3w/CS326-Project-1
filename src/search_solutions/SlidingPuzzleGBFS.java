package search_solutions;

import core_search.BaseSearch;
import core_search.Node;
import core_search.SortedQueue;
import search_problems.SlidingTilePuzzle;

import java.util.ArrayList;
import java.util.Comparator;

public class SlidingPuzzleGBFS extends BaseSearch<ArrayList<Integer>, String>
{
    public SlidingPuzzleGBFS()
    {
        super(new SlidingTilePuzzle(),
                new SortedQueue<>(new CompareMissingTiles(new SlidingTilePuzzle())));
    }

    public SlidingPuzzleGBFS(SlidingTilePuzzle a) {
        super(a, new SortedQueue<>(new SlidingPuzzleAStar.CompareMissingTiles(a)));
    }

    public static void main(String[] args) {
        SlidingPuzzleGBFS agent = new SlidingPuzzleGBFS();
        agent.search();
    }

    public static class CompareMissingTiles implements Comparator<Node<ArrayList<Integer>, String>>
    {
        private final SlidingTilePuzzle problem;
        public CompareMissingTiles(SlidingTilePuzzle problem){
            this.problem = problem;
        }

        @Override
        public int compare(Node<ArrayList<Integer>, String> o1, Node<ArrayList<Integer>, String> o2)
        {
            if(problem.misplacedTiles(o1.getState())< problem.misplacedTiles(o2.getState()))
            {
                return -1;
            }
            else if (problem.misplacedTiles(o1.getState()) == problem.misplacedTiles(o2.getState()))
            {
                return 0;
            }
            else{
                return 1;
            }
        }
    }
}

