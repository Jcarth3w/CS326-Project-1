package search_solutions;

import core_search.BaseSearch;
import core_search.Node;
import core_search.SortedQueue;
import search_problems.SlidingTilePuzzle;

import java.util.ArrayList;
import java.util.Comparator;

public class SlidingPuzzleAStar extends BaseSearch<ArrayList<Integer>, String>
{
    public SlidingPuzzleAStar()
    {
        super(new SlidingTilePuzzle(),
                new SortedQueue<>(new CompareMissingTiles(new SlidingTilePuzzle())));
    }

    public static void main(String[] args) {
        SlidingPuzzleAStar agent = new SlidingPuzzleAStar();
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
            if(problem.misplacedTiles(o1.getState()) + o1.getPathCost() < problem.misplacedTiles(o2.getState()) + o2.getPathCost())
            {
                return -1;
            }
            else if (problem.misplacedTiles(o1.getState()) + o1.getPathCost() == problem.misplacedTiles(o2.getState()) + o2.getPathCost())
            {
                return 0;
            }
            else{
                return 1;
            }
        }
    }
}
