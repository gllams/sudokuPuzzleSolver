package com.project.sudoku.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UsefulGeneralFunctions {

    /*
    Converts a string of numbers to a list of integers
     */
    public List<Integer> convertStringToIntegerList(String myNumbers){

        List<String> numbersInStringFormat = new ArrayList<String>(Arrays.asList(myNumbers.split(",")));

        List<Integer> myList = new ArrayList<>();

        for (String number: numbersInStringFormat){
            int numberConverted = Integer.parseInt(number);
            myList.add(numberConverted);
        }

        return myList;
    }
}
