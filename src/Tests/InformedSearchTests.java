package Tests;

import org.junit.jupiter.api.Test;
import search_problems.SlidingTilePuzzle;
import search_solutions.SlidingPuzzleAStar;
import search_solutions.SlidingPuzzleAStarHeuristic;
import search_solutions.SlidingPuzzleGBFS;
import search_solutions.SlidingPuzzleGBFSHeuristic;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InformedSearchTests
{
    @Test
    public void aStarSearch9Test()
    {
        SlidingPuzzleAStar a = new SlidingPuzzleAStar();

        assertTrue(a.search());

    }

    @Test
    public void aStarSearch15Test()
    {
        SlidingTilePuzzle s = new SlidingTilePuzzle(new ArrayList<>(List.of(12,1,2,15, 11,6,5,8, 7,10,9,4, 0,13,14,3)),
                new ArrayList<>(List.of(1,2,3,4, 5,6,7,8 ,9,10,11,12, 13,14,15)));
        SlidingPuzzleAStar a = new SlidingPuzzleAStar(s);

        assertTrue(a.search());

    }

    @Test
    public void aStarHeuristic9Test()
    {
        SlidingPuzzleAStarHeuristic a = new SlidingPuzzleAStarHeuristic();
        assertTrue(a.search());
    }

    @Test
    public void aStarHeuristic15Test()
    {
        SlidingTilePuzzle s = new SlidingTilePuzzle(new ArrayList<>(List.of(12,1,2,15, 11,6,5,8, 7,10,9,4, 0,13,14,3)),
                new ArrayList<>(List.of(1,2,3,4, 5,6,7,8 ,9,10,11,12, 13,14,15)));
        SlidingPuzzleAStarHeuristic a = new SlidingPuzzleAStarHeuristic(s);
        assertTrue(a.search());
    }


    @Test
    public void bfgsSearch9Test()
    {
        SlidingPuzzleGBFS a = new SlidingPuzzleGBFS();
        assertTrue(a.search());
    }


    @Test
    public void bfgsSearch15Test()
    {
        SlidingTilePuzzle s = new SlidingTilePuzzle(new ArrayList<>(List.of(12,1,2,15, 11,6,5,8, 7,10,9,4, 0,13,14,3)),
                new ArrayList<>(List.of(1,2,3,4, 5,6,7,8 ,9,10,11,12, 13,14,15)));
        SlidingPuzzleGBFS a = new SlidingPuzzleGBFS(s);
        assertTrue(a.search());
    }

    @Test
    public void bfgsHeuristic9Test()
    {
        SlidingPuzzleGBFSHeuristic a = new SlidingPuzzleGBFSHeuristic();
        assertTrue(a.search());
    }

    @Test void bfgHeuristic15Test()
    {
        SlidingTilePuzzle s = new SlidingTilePuzzle(new ArrayList<>(List.of(12,1,2,15, 11,6,5,8, 7,10,9,4, 0,13,14,3)),
            new ArrayList<>(List.of(1,2,3,4, 5,6,7,8 ,9,10,11,12, 13,14,15)));
        SlidingPuzzleGBFSHeuristic a = new SlidingPuzzleGBFSHeuristic(s);
        assertTrue(a.search());
    }





}
