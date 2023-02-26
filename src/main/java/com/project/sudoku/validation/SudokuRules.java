package com.project.sudoku.validation;

import java.util.List;

public interface SudokuRules {
    public boolean lineHasDuplicates(List<Integer> line);
    public boolean unitHasDuplicates(int[][] puzzle);

}
