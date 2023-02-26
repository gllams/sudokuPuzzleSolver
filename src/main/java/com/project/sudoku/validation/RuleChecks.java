package com.project.sudoku.validation;

import java.util.*;

public class RuleChecks implements SudokuRules {

    public boolean validatePuzzle(int[][] puzzle){
        boolean isValid =true ;
        isValid&=!rowsOrColumnsHaveDuplicates( puzzle,false);
        isValid&=!rowsOrColumnsHaveDuplicates(puzzle, true);
        isValid&=!unitHasDuplicates(puzzle);

        return isValid;
    }

    @Override
    public boolean unitHasDuplicates(int[][] puzzle) {

        List<Integer> unit;

        //possibly better to use if statements rather than the 4 loops below.
        //implemented this way out of curiosity  .
        for (int i=0;i<7;i+=3){
            for (int j=0;j<7;j+=3){
                if(i%3==0&&j%3==0){
                    unit= new ArrayList<>();
                    for (int k=i;k<i+3;k++){
                        for (int m=j;m<j+3;m++){
                            unit.add(puzzle[k][m]);
                        }
                    }
                    if(lineHasDuplicates(unit)) return true;
                }
            }

        }
        return false;
    }


    public boolean rowsOrColumnsHaveDuplicates(int[][] puzzle, boolean checkRow) {
        List<Integer> line;
        for (int x=0;x<9;x++){
            line =new ArrayList<>();
            for (int y=0;y<9;y++){
                line.add(checkRow?puzzle[x][y]:puzzle[y][x]);
            }
            if(lineHasDuplicates(line)) return true;
        }
        return false;
    }

    /**
     * I check for duplicates within a list. I ignore zeros.
     * @param line is a row or column from the puzzle
     * @return true if the line input has non zero duplicates.
     */

    @Override
    public boolean lineHasDuplicates(List<Integer> line) {

        Collections.sort(line);
        for (int i = 0; i<line.size()-1; i++) {
            if(line.get(i)==0) continue;
            if(line.get(i)==line.get(i+1)) return true;
        }
        return false;
    }

    public boolean isPuzzleSolved(int[][] puzzle){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if (puzzle[i][j]==0) return false;
            }
        }


        return validatePuzzle(puzzle);
    }
}
