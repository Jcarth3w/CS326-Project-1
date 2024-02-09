package search_solutions;

import core_search.BaseSearch;
import core_search.Node;
import core_search.SortedQueue;
import search_problems.SlidingTilePuzzle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SlidingPuzzleAStar extends BaseSearch<ArrayList<Integer>, String>
{
    private SlidingTilePuzzle a = new SlidingTilePuzzle(new ArrayList<>(List.of(12,1,2,15, 11,6,5,8, 7,10,9,4, 0,13,14,3)), new ArrayList<>(List.of(1,2,3,4, 5,6,7,8 ,9,10,11,12, 13,14,15));
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
