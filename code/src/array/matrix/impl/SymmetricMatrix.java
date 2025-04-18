package array.matrix.impl;

public class SymmetricMatrix extends LowerTriangularMatrix{

    public SymmetricMatrix(int rowOrColSize){
        super(rowOrColSize);
    }

    @Override
    public void display() {
        for (int row = 1; row <= this.getRowOrColSize(); row++) {
            for (int col = 1; col <= this.getRowOrColSize() ; col++) {
                int index;
                if (row >= col){
                    index = row * (row - 1) / 2 + (col - 1);
                } else {
                    index = col * (col - 1) / 2 + (row - 1);
                }
                System.out.print(elements[index] + " ");
            }
            System.out.println();
        }
    }
}
