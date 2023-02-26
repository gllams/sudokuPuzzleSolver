package com.project.sudoku;

import com.project.sudoku.utils.Functions;
import com.project.sudoku.validation.RuleChecks;

import java.util.*;


/**
 * A unit of a sudoku puzzle is defined to be a 3 x 3 grid of numbers.
 * The units are numbered as below.
 *
 *
 * unit 0  unit 1  unit 2
 * unit 3  unit 4  unit 5
 * unit 6  unit 7  unit 8
 *
 * We use 0 as a placeholder for unsolved boxes.
 *
 *
 *  This class contains methods used to infer the solutions.
 */
public class PuzzleCalculate extends Functions {
    int[][] puzzle;

    RuleChecks rules = new RuleChecks();
    Map<Integer,List<Integer>> missingNumbersFromRows = new HashMap<>();
    Map <Integer,List<Integer>> missingNumbersFromColumns = new HashMap();



    public PuzzleCalculate(int[][] puzzle){
        this.puzzle = puzzle;
        //solve();

    }
    public void solve(){
        identifyMissingNumbers();
        scanSinglePosition();
    }

    public void identifyUnits(){
        List<Integer> unitMembers = new ArrayList<>();
        Map<Map<Integer,Integer>,List<Integer>> units = new HashMap<>();
        Map<Integer,Integer> coordinate = new HashMap<>();

        for(int i=0; i<3;i++){
            for (int column=0;column< 3;column++){
                System.out.println("column"+ column);

                for(int row=0;row<3;row++){

                    ///I want to do something here
                    System.out.println("column"+ column);
                    System.out.println("row"+ row);
                }
            }

        }

        System.out.println("coordinate new"+ coordinate);
    }

    public Map <Map<Integer,Integer>,List<Integer>> findCandidatesForAllSquares(){
        Map <Map<Integer,Integer>,List<Integer>>  squaresAndTheirCandidates = new HashMap<>();
        Map<Integer,Integer> currentCoordinate;
        List<Integer> candidatesForSquare;
        Map <Map<Integer,Integer>,List<Integer>>   columnResult = new HashMap<>();
        //check rows
        for (Integer rowNumber: missingNumbersFromRows.keySet()){
            for(Integer missingNumber:  missingNumbersFromRows.get(rowNumber)){
                for (int columnNumber=0;columnNumber< puzzle.length ;columnNumber++) {
                    candidatesForSquare= new ArrayList<>();
                    currentCoordinate=new HashMap<>();
                    if (puzzle[rowNumber][columnNumber]==0&&missingNumbersFromColumns.get(columnNumber).contains(missingNumber)){
                        currentCoordinate.put(rowNumber,columnNumber);
                        if (squaresAndTheirCandidates.containsKey(currentCoordinate)) {
                            candidatesForSquare = squaresAndTheirCandidates.get(currentCoordinate);
                        }
                        candidatesForSquare.add(missingNumber);
                        squaresAndTheirCandidates.put(currentCoordinate,candidatesForSquare);
                    }
                }
            }
        }

        System.out.println("squaresAndTheirCandidates"+squaresAndTheirCandidates);
        System.out.println("columnResult"+columnResult);
        return squaresAndTheirCandidates;
    }
    public boolean checklineContainsNumber(int lineNumber, int numberToCheck,boolean isRow){
        boolean lineContainsNumber= false;

        if (isRow){
            if (!missingNumbersFromRows.get(lineNumber).contains(numberToCheck)){
                lineContainsNumber =true;
            }

        }else {
            if (!missingNumbersFromColumns.get(lineNumber).contains(numberToCheck)){
                lineContainsNumber =true;
            }
        }


        return lineContainsNumber;
    }
    /**
     * I check how many places each missing number can potentially go.
     * If it is only one square, the missing number must belong to there.
     *
     */
    public void scanSinglePosition(){
        Map <Map<Integer,Integer>,List<Integer>> squaresAndTheirCandidates= findCandidatesForAllSquares();
        boolean numberCanBePlacedInMoreThanOneRow;
        boolean numberCanBePlacedInMoreThanOneColumn;

        if (squaresAndTheirCandidates.isEmpty()){
            return;
        }
        for (Map<Integer,Integer> coordinate :squaresAndTheirCandidates.keySet() ){
            int rowNumber =coordinate.keySet().iterator().next();
            int columnNumber =coordinate.get(rowNumber);
            List<Integer> potentialNumbersForSquare = squaresAndTheirCandidates.get(coordinate);

            if (potentialNumbersForSquare.size()==1){
                puzzle[rowNumber][columnNumber]=potentialNumbersForSquare.get(0);
                System.out.printf("adding rowNumber, %d columnNumber %d potentialNumbersForSquare.get(0) %d \n",rowNumber, columnNumber, potentialNumbersForSquare.get(0));
            }


            for (Integer candidate : potentialNumbersForSquare){
                numberCanBePlacedInMoreThanOneRow= false;
                numberCanBePlacedInMoreThanOneColumn= false;

                if (rowNumber%3==0){
                    if(!(checklineContainsNumber(rowNumber+1,candidate,true)&&checklineContainsNumber(rowNumber+2,candidate,true))){

                        numberCanBePlacedInMoreThanOneRow=true;
                    }
                } else if (rowNumber%3==1) {

                    if(!(checklineContainsNumber(rowNumber+1,candidate,true)&&checklineContainsNumber(rowNumber-1,candidate,true))){
                        numberCanBePlacedInMoreThanOneRow=true;
                    }
                }

                else {
                    if(!(checklineContainsNumber(rowNumber-1,candidate,true)&&checklineContainsNumber(rowNumber-2,candidate,true))){
                        numberCanBePlacedInMoreThanOneRow=true;
                    }
                }

                if (columnNumber%3==0){
                    if(!(checklineContainsNumber(columnNumber+1,candidate,false)&&checklineContainsNumber(columnNumber+2,candidate,false))){
                        numberCanBePlacedInMoreThanOneColumn=true;
                    }
                } else if (columnNumber%3==1) {

                    if(!(checklineContainsNumber(columnNumber+1,candidate,false)&&checklineContainsNumber(columnNumber-1,candidate,false))){
                        numberCanBePlacedInMoreThanOneColumn=true;
                    }

                } else {
                    if(!(checklineContainsNumber(columnNumber-1,candidate,false)&&checklineContainsNumber(columnNumber-2,candidate,false))){
                        numberCanBePlacedInMoreThanOneColumn=true;
                    }
                }
                if(!numberCanBePlacedInMoreThanOneColumn&& !numberCanBePlacedInMoreThanOneRow){
                    System.out.printf("x %d, y %d, candidate %d \n",rowNumber,columnNumber,candidate);
                    checkRepetitionInUnit(coordinate, candidate);
                }
            }

        }





        //check columns
//        for (Integer columnNumber: missingNumbersFromColumns.keySet()){
//            for(Integer missingNumber:  missingNumbersFromColumns.get(columnNumber)){
//                for (int rowNumber=0;rowNumber< puzzle.length ;rowNumber++) {
//                    candidatesForSquare= new ArrayList<>();
//                    currentCoordinate=new HashMap<>();
//                    if (puzzle[rowNumber][columnNumber]==0&&missingNumbersFromRows.get(rowNumber).contains(missingNumber)){
//                        currentCoordinate.put(rowNumber,columnNumber);
//                        if (columnResult.containsKey(currentCoordinate)) {
//                            candidatesForSquare = columnResult.get(currentCoordinate);
//                        }
//                        candidatesForSquare.add(missingNumber);
//                        columnResult.put(currentCoordinate,candidatesForSquare);
//                    }
//                }
//            }
//        }


        //check units
//        for (int row=0;row<puzzle.length;row++){
//            for (int column=0;column<puzzle.length;column++){
//                //get units
//            }
//        }

    }

    public boolean checkRepetitionInUnit(Map<Integer,Integer> coordinate, Integer candidate){
        int rowNumber = coordinate.keySet().iterator().next();
        int columnNumber = coordinate.get(rowNumber);
        boolean unitContainsCandidate=false;

//        while(){
//
//        }

        return unitContainsCandidate;
    }

    public void identifyMissingNumbers(){
        identifyMissingNumbersInEachRow();
        identifyMissingNumbersInEachColumn();
    }

    public void identifyMissingNumbersInEachRow(){
        List<Integer> line = new ArrayList<>();
        for(int row=0;row<9;row++){
            for(int column=0;column<9;column++){
                line.add(puzzle[row][column]);
            }
            missingNumbersFromRows.put(row,calculateMissingNumbersInLine(line));

            line.clear();
        }

    }

    public void identifyMissingNumbersInEachColumn(){
        List<Integer> line = new ArrayList<>();
        for(int column=0;column<9;column++){
            for(int row=0;row<9;row++){
                line.add(puzzle[row][column]);
            }
            missingNumbersFromColumns.put(column,calculateMissingNumbersInLine(line));

            line.clear();
        }

    }


    public void bruteForce(){

    }

    public Map<Integer, List<Integer>> getMissingNumbersFromRows() {
        return missingNumbersFromRows;
    }

    public void setMissingNumbersFromRows(Map missingNumbersFromRows) {
        this.missingNumbersFromRows = missingNumbersFromRows;
    }

    public Map<Integer, List<Integer>> getMissingNumbersFromColumns() {
        return missingNumbersFromColumns;
    }

    public void setMissingNumbersFromColumns(Map missingNumbersFromColumns) {
        this.missingNumbersFromColumns = missingNumbersFromColumns;
    }



    public int[][] getPuzzle() {
        return puzzle;
    }
}
