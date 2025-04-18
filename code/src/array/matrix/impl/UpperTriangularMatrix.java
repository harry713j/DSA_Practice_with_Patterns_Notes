package array.matrix.impl;

public class UpperTriangularMatrix implements Matrix {
    private int length;
    private int rowOrColSize;
    private int[] elements;


    public UpperTriangularMatrix(int rowOrColSize){
        this.rowOrColSize = rowOrColSize;
        this.length = this.rowOrColSize * (this.rowOrColSize + 1) / 2;
        this.elements = new int[this.length];
    }

    @Override
    public void insert(int row, int col, int element){
        // Row-Major
        if (row == 0 || col == 0 || row > length || col > length){
            throw new IllegalArgumentException("Row and Column value must be in the range");
        }

        // Assuming we are going to pass row and col starting from 1.

        int index = rowOrColSize * (row - 1) - ((row - 1 ) * (row - 2) / 2) + (col - row);

        elements[index] = element;
    }

    @Override
    public void display(){
        for (int row = 1; row <= rowOrColSize; row++) {
            for (int col = 1; col <= rowOrColSize; col++) {
                int index = rowOrColSize * (row - 1) - ((row - 1 ) * (row - 2) / 2) + (col - row);
                if (row <= col){
                    System.out.print(elements[index] + " ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }

}
