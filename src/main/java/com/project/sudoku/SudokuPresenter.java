package com.project.sudoku;

import com.project.sudoku.externalresourcemanagement.ExternalFileWriter;
import com.project.sudoku.externalresourcemanagement.PuzzleFileReader;
import com.project.sudoku.utils.Algorithms;

import java.util.Arrays;

public class SudokuPresenter {
    String filePath;
    SudokuModel sudokuModel;

    PuzzleFileReader puzzleFileReader;
    ExternalFileWriter externalFileWriter;
    int[][] puzzle;
    PuzzleCalculate puzzleCalc;
    SudokuModel sudokuModelObject;

    public SudokuPresenter(){
        sudokuModel = new SudokuModel();


    }
    public SudokuPresenter(String filePath){
        this.filePath=filePath;
        this.puzzleFileReader = new PuzzleFileReader(filePath);
        this.externalFileWriter = new ExternalFileWriter(filePath);
        this.puzzle=retrievePuzzleFromFile();
        this.puzzleCalc= new PuzzleCalculate(puzzle);
        this.sudokuModelObject = new SudokuModel(puzzle);

        calculate();

    }


    public String getPuzzleToSolve(){
        return sudokuModel.generatePuzzle();

    }
    public boolean verifyCandidate(int row,int column,int candidate){
        return sudokuModel.verifyCandidate(row, column,candidate);
    }

    public boolean verifySolved(){
        return sudokuModel.verifySolved();
    }
    public  void calculate(){

        int[][] puzzle1;
        Algorithms algorithms = new Algorithms();

            puzzle1= new int[][]{
                    {0,0,0,2,6,0,7,0,1},
                    {6,8,0,0,7,0,0,9,0},
                    {1,9,0,0,0,4,5,0,0},
                    {8,2,0,1,0,0,0,4,0},
                    {0,0,4,6,0,2,9,0,0},
                    {0,5,0,0,0,3,0,2,8},
                    {0,0,9,3,0,0,0,7,4},
                    {0,4,0,0,5,0,0,3,6},
                    {7,0,3,0,1,8,0,0,0}};
        int[][] result = algorithms.backtracking(puzzle1);
        System.out.println("solution :" +Arrays.deepToString(result));
    }
    public int[][] retrievePuzzleFromFile(){
        int[][] puzzle= puzzleFileReader.retrievePuzzleFromSource();
        System.out.println(Arrays.deepToString(puzzle));
        return puzzle;
    }
    public String getUpdatePuzzle(){
        return sudokuModel.getFormattedPuzzle();
    }

    public void modifyPuzzleFileWithSolution(){
        //writeToPuzzleFile();
    }


}