package array.matrix.impl;

public class TriDiagonalMatrix implements Matrix{

    private int rowOrColSize;
    private int length;
    private int[] elements;

    public TriDiagonalMatrix(int rowOrColSize){
        this.rowOrColSize = rowOrColSize;
        this.length = (3 * this.rowOrColSize) - 1;
        this.elements = new int[this.length];
    }

    @Override
    public void insert(int row, int col, int element) {
        if (row == 0 || col == 0 || row > length || col > length){
            throw new IllegalArgumentException("Row and Column value must be in the range");
        }
        // storing the lower diagonal first then main diagonal then upper diagonal

        if (row - col == 0) {
            int index = (rowOrColSize - 1) + (row - 1);
            elements[index] = element;
        } else if (row - col == 1) {
            elements[col - 1] = element;
        } else if (row - col == -1) {
            int index = 2 * rowOrColSize - 1 + row - 1;
            elements[index] = element;
        }

    }

    @Override
    public void display() {
        for (int row = 1; row <= rowOrColSize; row++) {
            for (int col = 1; col <= rowOrColSize; col++) {
                if (row - col == 0) {
                    int index = (rowOrColSize - 1) + (row - 1);
                    System.out.print(elements[index] + " ");
                } else if (row - col == 1) {
                    int index  = col - 1;
                    System.out.print(elements[index] + " ");
                } else if (row - col == -1) {
                    int index = 2 * rowOrColSize - 1 + row - 1;
                    System.out.print(elements[index] + " ");
                } else {
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }
    }
}
