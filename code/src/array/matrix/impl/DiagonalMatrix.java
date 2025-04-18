package array.matrix.impl;

public class DiagonalMatrix implements Matrix {
    private int length;
    private int[] elements;

    public DiagonalMatrix(int noOfRow){
        this.length = noOfRow;
        this.elements = new int[this.length];
    }

    @Override
    public void insert(int row, int col, int element){
        if (row == 0 || col == 0 || row > length  || col > length){
            throw new IllegalArgumentException("Row and Column value must be in the range");
        }

        if (row == col){
            elements[row - 1] = element;
        }
    }

    @Override
    public void display(){
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i == j){
                    System.out.print(elements[i] + " ");
                } else {
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }
    }

}
