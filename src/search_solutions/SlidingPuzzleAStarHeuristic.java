package search_solutions;

import core_search.*;
import search_problems.SlidingTilePuzzle;

import java.util.ArrayList;
import java.util.Comparator;

public class SlidingPuzzleAStarHeuristic extends BaseSearch<ArrayList<Integer>, String>
{
    public SlidingPuzzleAStarHeuristic()
    {
        super(new SlidingTilePuzzle(),
                new SortedQueue<>(new CompareSum(new SlidingTilePuzzle())));
    }

    public static void main(String[] args) {
        SlidingPuzzleAStarHeuristic agent = new SlidingPuzzleAStarHeuristic();
        agent.search();
    }


    public static class CompareSum implements Comparator<Node<ArrayList<Integer>, String>>
    {
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
