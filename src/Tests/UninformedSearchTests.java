package Tests;

import org.junit.jupiter.api.Test;
import search_problems.SlidingTilePuzzle;
import search_solutions.SlidingPuzzleBFS;
import search_solutions.SlidingPuzzleDFS;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UninformedSearchTests
{
    @Test
    public void dfsSearch9Test()
    {
        SlidingPuzzleDFS a = new SlidingPuzzleDFS();
        assertTrue(a.search());
    }

    @Test
    public void dfsSearch15Test()
    {
        SlidingTilePuzzle s = new SlidingTilePuzzle(new ArrayList<>(List.of(12,1,2,15, 11,6,5,8, 7,10,9,4, 0,13,14,3)),
                new ArrayList<>(List.of(1,2,3,4, 5,6,7,8 ,9,10,11,12, 13,14,15)));
        SlidingPuzzleDFS a = new SlidingPuzzleDFS();
        assertTrue(a.search());
    }


    @Test
    public void bfsSearch9Test()
    {
        SlidingPuzzleBFS a = new SlidingPuzzleBFS();
        assertTrue(a.search());
    }

    @Test
    public void bfsSearch15Test()
    {
        SlidingTilePuzzle s = new SlidingTilePuzzle(new ArrayList<>(List.of(12,1,2,15, 11,6,5,8, 7,10,9,4, 0,13,14,3)),
                new ArrayList<>(List.of(1,2,3,4, 5,6,7,8 ,9,10,11,12, 13,14,15)));
        SlidingPuzzleBFS a = new SlidingPuzzleBFS(s);
        assertTrue(a.search());
    }

}
