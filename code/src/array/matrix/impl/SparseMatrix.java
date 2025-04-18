package array.matrix.impl;

import java.util.ArrayList;
import java.util.List;

public class SparseMatrix implements Matrix{
    // It is a type of matrix which have more number of zero elements than non-zero elements
    // We can store it in 1-D arrays, we need three 1-D arrays,
    // 1. For storing row number, 2. For storing Column number, 3. For storing the corresponding element

    private int rowSize;
    private int colSize;
    private int length; // number of non-zero elements
    private List<Integer> rowIndices;
    private List<Integer> colIndices;
    private List<Integer> elements;

    public SparseMatrix(int rowSize, int colSize){
        this.rowSize = rowSize;
        this.colSize = colSize;

        this.length = (this.rowSize * this.colSize) / 2;
        this.rowIndices = new ArrayList<>(this.length);
        this.colIndices = new ArrayList<>(this.length);
        this.elements = new ArrayList<>(this.length);


    }

    @Override
    public void insert(int row, int col, int element) {
        if (row == 0 || col == 0 || row > rowSize || col > colSize){
            throw new IllegalArgumentException("Row and Column should be in the range");
        }

        if (element != 0){
            rowIndices.add(row);
            colIndices.add(col);
            elements.add(element);

        }

    }

    @Override
    public void display() {
        int index = 0;
        for (int i = 1; i <= rowSize; i++) {
            for (int j = 1; j <= colSize; j++) {
                // need to show the matrix
                if (rowIndices.contains(i - 1) && colIndices.contains(j - 1)){
                    System.out.print(elements.get(index++) + "  ");
                } else {
                    System.out.print(0 + "  ");
                }
            }
            System.out.println();
        }
    }
}
