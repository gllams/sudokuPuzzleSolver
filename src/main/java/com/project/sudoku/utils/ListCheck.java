package com.project.sudoku.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListCheck {
    List <Integer> candidates = new ArrayList<>() ;
    int numberOfRows;

    public ListCheck(){

    }

    public ListCheck(List<Integer> puzzleRow, int numberOfRows){
        for ( int i=1; i < numberOfRows ; i++) {
            candidates.add(i);
        }
    }



    /*
    Identify missing numbers in a row
     */
    public List<Integer> identifyMissingNumbers(List<Integer> sudokuRow){
        System.out.println("sudokuRow"+sudokuRow);
        List<Integer> missingNumbers = new ArrayList<Integer>();

        for(int  x : candidates){
            if (!sudokuRow.contains(x)){

                missingNumbers.add(x);
                System.out.println("missingNumbers"+missingNumbers);
            }
        }
        return missingNumbers;
    }


    public boolean rowHasRepeatEntries(List<Integer> row){
        boolean rowHasRepeatEntries =false;
        List<Integer> numbersInRow = new ArrayList<Integer>();
        numbersInRow =row;
        Collections.sort(numbersInRow);
        System.out.println("numbersInRow"+numbersInRow);
        for (int i = 0; i<numbersInRow.size()-1; i++) {
            if(numbersInRow.get(i)==numbersInRow.get(i+1)){
                rowHasRepeatEntries=true;
            }

        }


        return rowHasRepeatEntries;
    }
    public void setCandidates(List<Integer> candidates){
        this.candidates=candidates;
    }
    public void setNumberOfRows(int numberOfRows){
        this.numberOfRows=numberOfRows;
    }

}
