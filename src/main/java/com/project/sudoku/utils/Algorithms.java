package com.project.sudoku.utils;

import com.project.sudoku.validation.RuleChecks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Algorithms {

    RuleChecks ruleChecks = new RuleChecks();

    /**
     * I implement the backTracking algorithm . I check if any of the candidates are valid for the cell.
     * If so, I proceed to the next cell and repeat.
     * If not I return to the last known correct cell.
     */
//    public boolean backtracking(int[][] puzzle){
//
//        for(int x=0;x<9;x++){
//
//            for(int y=0;y<9;y++){
//                if(puzzle[x][y]==0) continue;
//
//                for (int k=1;k<10;k++){
//                    puzzle[x][y]=k;
//                    if (isValid(puzzle)){
//                        if (backtracking(puzzle)){
//                            break;
//                        }
//                    }else{
//                        puzzle[x][y]=0;
//                    }
//                }
//                if(puzzle[x][y]==0){
//                    return false ;
//                }
//            }
//        }
//        return true;
//    }

    public int[][] backtracking(int[][] puzzle){

        for(int rowPosition=0;rowPosition<9;rowPosition++){


            for(int columnPosition=0;columnPosition<9;columnPosition++){

                if(puzzle[rowPosition][columnPosition]!=0) continue;

                for (int candidate=1;candidate<10;candidate++){
                    puzzle[rowPosition][columnPosition]=candidate;
                    if (isValid(puzzle)){
                        if (backtracking(puzzle)!=null){
                            break;
                        }
                    }else{
                        puzzle[rowPosition][columnPosition]=0;
                    }
                }
                if(puzzle[rowPosition][columnPosition]==0){
                    return null ;
                }
            }
        }
        return puzzle;
    }
    public boolean isValid(int[][] x){

        return ruleChecks.validatePuzzle(x);
    }

}
