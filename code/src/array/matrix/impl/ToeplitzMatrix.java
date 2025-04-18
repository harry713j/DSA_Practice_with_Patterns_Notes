package array.matrix.impl;

public class ToeplitzMatrix implements Matrix{
    /*
    * All the Diagonal elements are same
    *   2  3  4  5  6
    *   7  2  3  4  5
    *   8  7  2  3  4
    *   9  8  7  2  3
    *   10 9  8  7  2
    * */

    private int rowOrColSize;
    private int length;
    private int[] elements;

    public ToeplitzMatrix(int rowOrColSize){
        this.rowOrColSize = rowOrColSize;
        this.length = (2 * this.rowOrColSize) - 1;
        this.elements = new int[this.length];
    }

    @Override
    public void insert(int row, int col, int element) {
        if (row == 0 || col == 0 || row > length || col > length){
            throw new IllegalArgumentException("Row and Column value must be in the range");
        }

       int index = row <= col ? col - row : rowOrColSize + row - col - 1;

        elements[index] = element;

    }

    @Override
    public void display() {
        for (int row = 1; row <= rowOrColSize; row++) {
            for (int col = 1; col <= rowOrColSize; col++) {
                if (row <= col){
                    System.out.print(elements[col - row] + "  ");
                } else {
                    System.out.print(elements[rowOrColSize + row - col - 1] + "  ");
                }
            }
            System.out.println();
        }
    }
}
