package search_solutions;

import core_search.BaseSearch;
import core_search.Node;
import core_search.SortedQueue;
import search_problems.SlidingTilePuzzle;

import java.util.ArrayList;
import java.util.Comparator;

public class SlidingPuzzleGBFSHeuristic extends BaseSearch<ArrayList<Integer>, String>
{

    public SlidingPuzzleGBFSHeuristic()
    {
        super(new SlidingTilePuzzle(),
                new SortedQueue<>(new CompareSum(new SlidingTilePuzzle())));
    }

    public SlidingPuzzleGBFSHeuristic(SlidingTilePuzzle s) {
        super(s, new SortedQueue<>(new CompareSum(s)));
    }

    public static void main(String[] args) {
        SlidingPuzzleGBFSHeuristic agent = new SlidingPuzzleGBFSHeuristic();
        agent.search();
    }


    public static class CompareSum implements Comparator<Node<ArrayList<Integer>, String>> {
        private final SlidingTilePuzzle problem;
        public CompareSum (SlidingTilePuzzle problem){
            this.problem = problem;
        }

        @Override
        public int compare(Node<ArrayList<Integer>, String> o1, Node<ArrayList<Integer>, String> o2)
        {
            if(problem.sumOfDistance(o1.getState()) + o1.getPathCost() < problem.sumOfDistance(o2.getState()) + o2.getPathCost())
            {
                return -1;
            }
            else if (problem.sumOfDistance(o1.getState()) + o1.getPathCost() == problem.sumOfDistance(o2.getState()) + o2.getPathCost())
            {
                return 0;
            }
            else{
                return 1;
            }
        }
    }
}
