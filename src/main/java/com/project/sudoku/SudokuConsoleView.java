package com.project.sudoku;

import java.util.Scanner;

public class SudokuConsoleView {

    int row;
    int column;
    int candidate;
    String puzzle;
    SudokuPresenter controller;
    public SudokuConsoleView(){
        controller= new SudokuPresenter();
        this.puzzle=controller.getPuzzleToSolve();
        beginSolving();
    }

    public void beginSolving(){
        boolean solved=false;
        System.out.println("Solve the below:");

        while (!solved){
            try{
                System.out.println(puzzle);
                Scanner scanner = new Scanner(System.in);
                System.out.println("enter row: ");//note that rows start at one. this needs to be taken into account in the backend.
                row =scanner.nextInt();
                System.out.println("enter column: ");
                column =scanner.nextInt();
                System.out.println("enter solution for the cell: ");
                candidate =scanner.nextInt();
            }catch (Exception e){
                System.out.println("Please enter a number as your answer.");
                continue;
            }


            if(controller.verifyCandidate(row,column,candidate)) updateView();
            if(controller.verifySolved()) solved = true;
        }
    }

    public void updateView(){
        puzzle=controller.getUpdatePuzzle();
    }

    public void setPuzzle(String puzzle) {
        this.puzzle = puzzle;
    }
}
