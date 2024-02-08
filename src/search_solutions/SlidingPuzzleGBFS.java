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
                new SortedQueue<>(new CompareSum(new SlidingTilePuzzle())));
    }

    public SlidingPuzzleGBFS(int i)
    {
        super(new SlidingTilePuzzle(),
                new SortedQueue<>(new CompareMissingTiles(new SlidingTilePuzzle())));
    }

    public static void main(String[] args) {
        SlidingPuzzleGBFS agent = new SlidingPuzzleGBFS();
        SlidingPuzzleGBFS missingTileAgent = new SlidingPuzzleGBFS(1);
        agent.search();
        System.out.println("break");
        missingTileAgent.search();
    }

    public static class CompareSum implements Comparator<Node<ArrayList<Integer>, String>> {
        private final SlidingTilePuzzle problem;
        public CompareSum (SlidingTilePuzzle problem){
            this.problem = problem;
        }

        @Override
        public int compare(Node<ArrayList<Integer>, String> o1, Node<ArrayList<Integer>, String> o2)
        {
            if(problem.sumOfDistance(o1.getState()) + 1 < problem.sumOfDistance(o2.getState()) + 1)
            {
                return -1;
            }
            else if (problem.sumOfDistance(o1.getState()) + 1 == problem.sumOfDistance(o2.getState()))
            {
                return 0;
            }
            else{
                return 1;
            }
        }
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

