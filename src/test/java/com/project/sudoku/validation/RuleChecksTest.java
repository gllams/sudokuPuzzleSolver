package com.project.sudoku.validation;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class RuleChecksTest {
    RuleChecks ruleChecks;
    List<Integer> line;
    List<Integer> line1;
    List<Integer> line2 ;
    List<Integer> line3 ;
    List<Integer> line4 ;
    List<Integer> line5 ;
    List<Integer> line6 ;
    int[][]puzzleA;
    int[][]puzzleB;
    int[][]puzzleC;
    int[][]puzzleD;
    int[][] solvedPuzzle;
    int[][] solvedPuzzleB;
    int[][] puzzleE;
    int[][] puzzleF;
    int[][] puzzleG;
    @Before
    public void setup(){
        ruleChecks = new RuleChecks();
        line = Arrays.asList(8,1,2,3,4,5,6,7,8);
        line1 = Arrays.asList(7,1,2,7,4,6,7,0,5);
        line2=Arrays.asList(1,1,2,3,4,6,9,0,5);
        line3=Arrays.asList(1,2,3,4,5,6,9,7,8);
        line4=Arrays.asList(1,2,3,4,5,6,7,8,8);
        line5=Arrays.asList(1,1);
        line6=Arrays.asList(1,0,3);


        solvedPuzzleB =new int[][]{
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9},
        };
        solvedPuzzle =new int[][]{
                {4,8,3,9,2,1,6,5,7},
                {9,6,7,3,4,5,8,2,1},
                {2,5,1,8,7,6,4,9,3},
                {5,4,8,1,3,2,9,7,6},
                {7,2,9,5,6,4,1,3,8},
                {1,3,6,7,9,8,2,4,5},
                {3,7,2,6,8,9,5,1,4},
                {8,1,4,2,5,3,7,6,9},
                {6,9,5,4,1,7,3,8,2},
        };

        puzzleG =new int[][]{
                {0,8,3,9,2,1,6,5,7},
                {9,0,7,3,4,5,8,2,1},
                {2,5,1,8,7,6,4,9,3},
                {5,4,8,1,3,2,9,7,6},
                {7,2,9,5,6,4,1,3,8},
                {0,3,6,7,9,6,2,4,5},
                {3,7,2,6,8,9,5,1,4},
                {8,1,4,2,5,3,7,6,9},
                {6,9,5,4,1,7,3,8,2},
        };
        puzzleE =new int[][]{
                {4,8,3,9,2,1,6,5,7},
                {9,6,7,3,4,5,8,2,1},
                {2,5,1,8,7,6,4,9,3},
                {5,4,8,1,3,2,9,7,6},
                {7,2,9,5,6,4,1,3,8},
                {1,3,6,7,9,8,2,4,5},
                {3,7,2,6,8,9,5,1,4},
                {8,1,4,2,5,3,7,6,6},
                {6,9,5,4,1,7,3,8,2},
        };

        puzzleF =new int[][]{
                {4,8,3,9,2,1,6,5,7},
                {9,6,7,3,4,5,8,2,1},
                {2,5,4,8,7,6,4,9,3},
                {5,4,8,1,3,2,9,7,6},
                {7,2,9,5,6,4,1,3,8},
                {1,3,6,7,9,8,2,4,5},
                {3,7,2,6,8,9,5,1,4},
                {8,1,4,2,5,3,7,6,9},
                {6,9,5,4,1,7,3,8,2},
        };


        puzzleA = new int [][]{
                {1, 2, 3, 4,5, 6, 7, 8,9},
                {1, 2, 3, 4,5, 6, 7, 8,9},
                {1, 2, 3, 4,5, 6, 7, 8,9},
                {1, 2, 3, 4,5, 6, 7, 8,9},
                {1, 2, 3, 4,5, 6, 7, 8,9},
                {1, 2, 3, 4,5, 6, 7, 8,9},
                {1, 2, 3, 4,5, 6, 7, 8,9},
                {1, 2, 3, 4,5, 6, 7, 8,9},
                {1, 2, 3, 4,5, 6, 7, 8,9}
        };

        puzzleB = new int[][]{
                {1, 2, 3, 4,5, 6, 7, 8,9},
                {1, 2, 3, 4,5, 6, 7, 8,1},// number '1' is a duplicate on this line
                {1, 2, 3, 4,5, 6, 7, 8,9},
                {1, 2, 3, 4,5, 6, 7, 8,9},
                {1, 2, 3, 4,5, 6, 7, 8,9},
                {1, 2, 3, 4,5, 6, 7, 8,9},
                {1, 2, 3, 4,5, 6, 7, 8,9},
                {1, 2, 3, 4,5, 6, 7, 8,9},
                {1, 2, 3, 4,5, 6, 7, 8,9}
        };

        puzzleC = new int [][]{
                {1, 2, 3, 4,5, 6, 7, 8,9},
                {1, 2, 3, 4,5, 6, 7, 8,9},
                {1, 2, 3, 4,5, 6, 7, 8,9},
                {1, 2, 3, 4,5, 6, 7, 8,9},
                {1, 2, 3, 4,5, 6, 7, 8,9},
                {1, 2, 3, 4,5, 6, 7, 8,9},
                {1, 2, 3, 4,5, 6, 7, 8,9},
                {1, 2, 3, 4,5, 6, 7, 8,9},
                {1, 2, 3, 4,5, 6, 7, 9,9}// number '0' is a duplicate on this line
        };

        puzzleD = new int[][]{
                {1, 2, 3, 4,5, 6, 7, 8,9},
                {1, 2, 3, 4,5, 6, 7, 8,9},
                {1, 2, 3, 4,5, 6, 7, 8,9},
                {1, 2, 3, 4,5, 6, 7, 8,9},
                {1, 2, 3, 4,5, 6, 7, 8,9},
                {1, 2, 3, 4,5, 6, 7, 8,9},
                {1, 2, 3, 4,5, 6, 7, 8,9},
                {1, 2, 3, 4,5, 6, 7, 5,9},// number '5' is a duplicate on this line
                {1, 2, 3, 4,5, 6, 7, 8,9}
        };

    }
    @Test
    public void verifyPuzzleColumnsHaveDuplicates(){

        for (int i=0;i<9;i++){
            for (int y=0;y<9;y++){
                puzzleA[y][i]=y;
                puzzleB[y][i]=y;
                puzzleC[y][i]=y;
                puzzleD[y][i]=y;

            }
        }
        puzzleB[0][2]=4;
        puzzleC[8][7]=5;
        puzzleD[1][1]=2;

        assertFalse (ruleChecks.rowsOrColumnsHaveDuplicates(puzzleA,false));
        assertTrue (ruleChecks.rowsOrColumnsHaveDuplicates(puzzleB,false));
        assertTrue (ruleChecks.rowsOrColumnsHaveDuplicates(puzzleC,false));
        assertTrue (ruleChecks.rowsOrColumnsHaveDuplicates(puzzleD,false));


    }
    @Test
    public void verifyPuzzleRowsHaveDuplicates(){
        assertEquals (false,ruleChecks.rowsOrColumnsHaveDuplicates(puzzleA,true));
        assertEquals (true,ruleChecks.rowsOrColumnsHaveDuplicates(puzzleB,true));
        assertEquals (true,ruleChecks.rowsOrColumnsHaveDuplicates(puzzleC,true));
        assertEquals (true,ruleChecks.rowsOrColumnsHaveDuplicates(puzzleD,true));

    }

    @Test
    public void lineHasDuplicatesTest(){

        assertEquals (true,ruleChecks.lineHasDuplicates(line));
        assertEquals (true,ruleChecks.lineHasDuplicates(line1));
        assertEquals (true,ruleChecks.lineHasDuplicates(line2));
        assertEquals (false,ruleChecks.lineHasDuplicates(line3));
        assertEquals (true,ruleChecks.lineHasDuplicates(line4));
        assertEquals (true,ruleChecks.lineHasDuplicates(line5));
        assertEquals (false,ruleChecks.lineHasDuplicates(line6));

    }

    @Test
    public void unitHasDuplicates(){
        assertEquals (true,ruleChecks.unitHasDuplicates(puzzleA));
        assertEquals (true,ruleChecks.unitHasDuplicates(puzzleB));
        assertEquals (true,ruleChecks.unitHasDuplicates(puzzleC));
        assertEquals (true,ruleChecks.unitHasDuplicates(puzzleD));
        assertEquals (true,ruleChecks.unitHasDuplicates(puzzleE));
        assertEquals (true,ruleChecks.unitHasDuplicates(puzzleF));
        assertEquals (true,ruleChecks.unitHasDuplicates(puzzleG));
        assertEquals (false,ruleChecks.unitHasDuplicates(solvedPuzzle));
        assertEquals (false,ruleChecks.unitHasDuplicates(solvedPuzzleB));
    }

    @Test
    public void validatePuzzle(){
        assertTrue (ruleChecks.validatePuzzle(solvedPuzzleB));
        assertTrue (ruleChecks.validatePuzzle(solvedPuzzle));
        assertFalse (ruleChecks.validatePuzzle(puzzleA));
        assertFalse (ruleChecks.validatePuzzle(puzzleE));
        assertFalse (ruleChecks.validatePuzzle(puzzleF));
        assertFalse (ruleChecks.validatePuzzle(puzzleG));
    }

}
