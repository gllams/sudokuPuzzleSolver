package com.project.sudoku;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PuzzleCalculateTest {

    int[][] puzzleA;
    int[][] puzzleB;
    PuzzleCalculate puzzleCalculateA;
    PuzzleCalculate puzzleCalculateB;
    @Before
    public void setUp() throws Exception {

        puzzleA = new int [][]{
                {0, 0, 0, 2, 6, 0, 7, 0, 1},
                {6, 8, 0, 0, 7, 0, 0, 9, 0},
                {1, 9, 0, 0, 0, 4, 5, 0, 0},
                {8, 2, 0, 1, 0, 0, 4, 0, 0},
                {0, 0, 4, 6, 0, 2, 9, 0, 0},
                {0, 5, 0, 0, 0, 3, 0, 2, 8},
                {0, 0, 9, 3, 0, 0, 0, 7, 4},
                {0, 4, 0, 0, 5, 0, 0, 3, 6},
                {7, 0, 3, 0, 1, 8, 0, 0, 0}
        };

        puzzleB = new int[][]{
                {0, 0, 6, 0, 3, 0, 7, 0, 8},
                {0, 3, 0, 0, 0, 0, 0, 0, 1},
                {2, 0, 0, 0, 0, 0, 6, 0, 0},
                {1, 0, 0, 3, 5, 0, 0, 0, 6},
                {0, 7, 9, 0, 4, 0, 1, 5, 0},
                {5, 0, 0, 0, 1, 7, 0, 0, 4},
                {0, 0, 2, 0, 0, 0, 0, 0, 7},
                {6, 0, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 7, 0, 6, 0, 2, 0, 0}
        };

        puzzleCalculateA = new PuzzleCalculate(puzzleA);
        puzzleCalculateB = new PuzzleCalculate(puzzleB);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void scanSinglePositionTest(){
        puzzleCalculateB.identifyMissingNumbers();
        System.out.println("  puzzleCalculateB.getMissingNumbersFromColumns()"+puzzleCalculateB.getMissingNumbersFromColumns());
        System.out.println("  puzzleCalculateB.getMissingNumbersFromRows()"+puzzleCalculateB.getMissingNumbersFromRows());
        puzzleCalculateB.scanSinglePosition();

    }

    @Test
    public void identifyUnitsTest(){

        puzzleCalculateB.identifyUnits();

    }

}