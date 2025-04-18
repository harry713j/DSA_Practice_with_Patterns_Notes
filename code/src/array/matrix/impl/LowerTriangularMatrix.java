package array.matrix.impl;

public class LowerTriangularMatrix implements Matrix{
    private int length;
    protected int[] elements;
    private int rowOrColSize;


    public LowerTriangularMatrix(int noOfRowOrCol){
        this.rowOrColSize = noOfRowOrCol;
        this.length = this.rowOrColSize * (this.rowOrColSize + 1) / 2;
        this.elements = new int[this.length];
    }

    public int getRowOrColSize() {
        return rowOrColSize;
    }

    @Override
    public void insert(int row, int col, int element) {
        // Row-Major
        if (row == 0 || col == 0 || row > length || col > length){
            throw new IllegalArgumentException("Row and Column value must be in the range");
        }

        // Assuming we are going to pass row and col starting from 1.

        int index = (row * (row - 1) / 2) + col - 1;
        elements[index] = element;

    }

    @Override
    public void display() {
        for (int i = 1; i <= rowOrColSize; i++) {
            for (int j = 1; j <= rowOrColSize; j++) {
                if (i >= j){
                    int index = (i * (i - 1) / 2) + j - 1;
                    System.out.print(elements[index] + " ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }
}
