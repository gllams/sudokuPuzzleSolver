package com.project.sudoku;


import com.project.sudoku.utils.ListCheck;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class GeneralFunctionsTest {
    ListCheck listCheck = new ListCheck();

    List<Integer> puzzleRowA = new ArrayList<Integer>();
    List<Integer> puzzleRowB = new ArrayList<Integer>();
    List<Integer> expected = new ArrayList<>();

    @Before
    public void init(){


        puzzleRowA.add(1);
        puzzleRowA.add(0);
        puzzleRowA.add(3);
        puzzleRowA.add(4);
        puzzleRowA.add(9);
        puzzleRowA.add(6);
        puzzleRowA.add(7);
        puzzleRowA.add(0);
        puzzleRowA.add(8);

        for (int i=1;i<10;i++){
            puzzleRowB.add(i);
        }
        listCheck.setCandidates(puzzleRowB);
        listCheck.setNumberOfRows(1);
    }


    @After
    public void destroy(){
        puzzleRowA.clear();
        puzzleRowB.clear();
        expected.clear();
    }

    @Test
    public void rowHasRepeatEntriesTest(){
        assertTrue(listCheck.rowHasRepeatEntries(puzzleRowA));
        assertTrue(!listCheck.rowHasRepeatEntries(puzzleRowB));
    }
    @Test
    public void identifyMissingNumbersTestA(){
        expected.add(2);
        expected.add(5);
        List<Integer>result = listCheck.identifyMissingNumbers(puzzleRowA);
        Collections.sort(result);
        assertTrue(result.equals(expected));

    }
    @Test
    public void identifyMissingNumbersTestB(){
        List<Integer>result = listCheck.identifyMissingNumbers(puzzleRowB);
        assertTrue(result.equals(expected));

    }


}
