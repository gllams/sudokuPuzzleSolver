package com.project.sudoku.externalresourcemanagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.String.valueOf;

public class PuzzleFileReader {
    String filePath;
    int [][] puzzle = new int[9][9];

    public PuzzleFileReader(String filePath) {
        this.filePath= filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public int[][] retrievePuzzleFromSource() {

       try{
           int i=0;
           String result = "";
           File puzzleFile =new File(filePath);
           Scanner fileReader = new Scanner(puzzleFile);

           while(fileReader.hasNextLine()){

               String line =fileReader.nextLine().replace(",","");
               char[] charArray =line.toCharArray();

                for (int y=0;y<9;y++){
                    puzzle[i][y]=Character.getNumericValue(charArray[y]);
                }
               i++;
           }
           fileReader.close();
       } catch (FileNotFoundException exception) {
           System.out.println(exception.getStackTrace());
       }finally {
           return puzzle;
       }

    }

    @Override
    public String toString() {
        return "ReadPuzzleFile{" +
                "filePath='" + filePath + '\'' +
                ", puzzle=" + Arrays.deepToString(puzzle) +
                '}';
    }
}
