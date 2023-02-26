package com.project.sudoku.utils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Generally, this class contains the methods required to analyse individual lines(row or columns) .
 */
public class Functions {
   final List<Integer> candidates;

    public Functions(){
        candidates = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

    }


    //public List<Integer> calculateMissingNumbers(int lineReference, boolean calculateMissingNumbersFromRow){
    public List<Integer> calculateMissingNumbersInLine(List<Integer> puzzleLine){

        List<Integer> numbersInLine = new ArrayList<Integer>();

        List<Integer> missingNumbersInLine= new ArrayList<Integer>();

        for (int i=0;i<candidates.size();i++){
            if (puzzleLine.get(i)!=0){
                numbersInLine.add(puzzleLine.get(i));
            }
        }

        for (Integer num:candidates) {
            if (!numbersInLine.contains(num)){
                missingNumbersInLine.add(num);
            }

        }
        return missingNumbersInLine;
    }

    /**
     *I take a row or column of the puzzle.
     * The row or column must only have one unfilled slot.
     *
     * @param line a row or column of the puzzle
     * @return     the number to complete the row or column
     *
     */
    public int identifySingleMissingNumbersInLine(List<Integer> line ){

        if(line.contains(0)&&line.indexOf(0)==line.lastIndexOf(0)){
            for (Integer num : candidates){
                System.out.println(num);
                if(!line.contains(num)){
                    return num;
                }
            }

        }else{
            System.out.println("line has more than 1 unsolved entry");
        }


        return 0;
    }

    /**
     *I take 3 lines of the puzzle.
     *I scan these 3 lines to see if any 2 rows have identical entries.
     * This can help identify the number's position on the remaining line.
     *
     * @param lines a list of the rows or columns
     */

    public void scanRowsOrColumns(List<List<Integer>> lines){
//        try{
//            for(int i=0;i<3;i++){
//                scanRowsOrColumns(lines.get(i),lines.get(i+1),lines.get(i+2));
//                lines.add(lines.get(i));
//                lines.remove(0);
//            }
//        }catch (Exception e){
//            System.out.println(e.getStackTrace());
//        }
    }

    /**
     *
     * @param line0 a map with row number key and line as value
     */

    public Map<Integer,List<Integer>> identifySinglePositionCandidates (Map<Integer,List<Integer>> line0, Map<Integer,List<Integer>> line1, Map<Integer,List<Integer>> line2){
        int line0RowNumber = (int) line0.keySet().toArray()[0];
        int line1RowNumber = (int) line1.keySet().toArray()[0];
        int line2RowNumber = (int) line2.keySet().toArray()[0];
        List<Integer> commonNumbers;

        int lineNumber=0;
       // List<Integer> candidatesForLine= new ArrayList<>();
        Map<Integer,List<Integer>> candidatesForLine = new HashMap<>();

        int lineRef=0;

        commonNumbers= checkIfContentsOfLinesAreShared(line0.get(line0RowNumber),line1.get(line1RowNumber));
        if(!commonNumbers.isEmpty()){
            for(int i:commonNumbers){
                if(!line2.get(line2RowNumber).contains(i)){
//                    int positionOfNumberInLine0=line0.get(line0RowNumber).indexOf(i);
//                    int positionOfNumberInLine1=lnbine1.get(line1RowNumber).indexOf(i);
//                    candidatesForLine.put()

                }

            }
        }



//        for (int i: line0.get(line0RowNumber)){
//            if (i!=0){
//                if ((line1.get(line1RowNumber).contains(i)||line2.get(line2RowNumber).contains(i))&&(!(line1.get(line1RowNumber).contains(i)||line2.get(line2RowNumber).contains(i)))){
//                    matchesFoundInAnotherLine.add(i);
//                    if (line1.get(line1RowNumber).contains(i)){
//                        lineNumber=line1RowNumber;
//                    }else{
//                        lineNumber=line2RowNumber;
//                    }
//
//                }
//            }
//
//        }

       //return results;
        return candidatesForLine;



   }

    public List<Integer> checkIfContentsOfLinesAreShared(List<Integer> line0, List<Integer> line1){
        List<Integer> commonNumbers =new ArrayList<>();
        for(int i: line1){
            if(i!=0&&line0.contains(i)){
                commonNumbers.add(i);
            }
        }
        return commonNumbers;
    }
//
//    public Map<Integer,Map<Integer,Integer>> mergeMaps(Integer,Map<Integer,Integer>){
//
//    }



    public void checkUnits(Integer[][] unit){

    }

}
