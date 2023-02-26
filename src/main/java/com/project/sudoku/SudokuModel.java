package com.project.sudoku;

import com.project.sudoku.validation.RuleChecks;

import java.util.*;

public class SudokuModel {
    int[][] puzzle;
    RuleChecks ruleChecks = new RuleChecks();
    Map<Integer,List<Integer>> units= new HashMap<>();
    //missing rows.

    public SudokuModel(int[][] puzzle){
        this.puzzle=puzzle;
    }
    public SudokuModel(){
    }


    //TODO: write algorithm to create a puzzle
    public String generatePuzzle(){
        int[][] puzzle = new int[][]{
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

        this.puzzle=puzzle;
        return getFormattedPuzzle();
    }


    public boolean verifyCandidate(int row,int column,int candidate){
        int tmp = puzzle[row-1][column-1];
        puzzle[row-1][column-1]=candidate;
        if(!ruleChecks.validatePuzzle(puzzle)){
            puzzle[row-1][column-1]=tmp;
            return false;
        }
        return true;
    }
    public boolean verifySolved (){
        return ruleChecks.isPuzzleSolved(puzzle);
    }

    public String getFormattedPuzzle() {
        String result = Arrays.deepToString(puzzle);
        if(result.contains("0")){
            result=result.replaceAll("0"," ");
        }
        result =result.substring(1,result.length()-1);
        String formattedPuzzle="";
        while(result.contains("[")){
            int endOfRow =result.indexOf("]");
            formattedPuzzle+=result.substring(result.indexOf("["),endOfRow+1)+"\n";
            result=result.substring(endOfRow+1);
        }
        return formattedPuzzle;
    }
}
