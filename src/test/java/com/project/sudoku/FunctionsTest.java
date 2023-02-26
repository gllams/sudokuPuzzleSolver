package com.project.sudoku;

import com.project.sudoku.utils.Functions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FunctionsTest {

    Functions functions = new Functions();
    List<Integer> puzzleRowA = new ArrayList<Integer>();
    List<Integer> puzzleRowB = new ArrayList<Integer>();
    List<Integer> expectedA = new ArrayList<Integer>();
    List<Integer> expectedB = new ArrayList<Integer>();


    @BeforeEach
    void setUp() {
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
    }

    @AfterEach
    void tearDown() {
        puzzleRowA.clear();
        puzzleRowB.clear();
        expectedA.clear();
        expectedB.clear();
    }



    @Test
    public void calculateMissingNumbersInLineTest(){
        expectedA.add(2);
        expectedA.add(5);

        List<Integer> resultA = functions.calculateMissingNumbersInLine(puzzleRowA);
        System.out.println("resultA"+resultA);
        List<Integer> resultB = functions.calculateMissingNumbersInLine(puzzleRowB);
        System.out.println("resultB"+resultB);
        assertEquals(expectedA,resultA);
        assertEquals(expectedB,resultB);

    }

    @Test
    public void identifySingleMissingNumbersInLineTest(){
       int a=  functions.identifySingleMissingNumbersInLine(puzzleRowA);

       assertEquals(a,0);
    }
    @Test
    public void identifySingleMissingNumbersInLineTestA(){
        int b=  functions.identifySingleMissingNumbersInLine(puzzleRowB);
        assertEquals(b,0);
    }
    @Test
    public void identifySingleMissingNumbersInLineTestC(){
        puzzleRowB.remove(8);
        puzzleRowB.add(0);
        System.out.println(puzzleRowB);
        int b=  functions.identifySingleMissingNumbersInLine(puzzleRowB);
        assertEquals(9,b);
    }

    @Test
    public void identifySingleMissingNumbersInLineTestB(){
        puzzleRowB.remove(2);
        puzzleRowB.add(0);
        System.out.println(puzzleRowB);
        int b=  functions.identifySingleMissingNumbersInLine(puzzleRowB);
        assertEquals(3,b);
    }

}