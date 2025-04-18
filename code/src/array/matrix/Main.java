package array.matrix;

import array.matrix.impl.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of row / column: ");
        int n = sc.nextInt();

//        DiagonalMatrix dm = new DiagonalMatrix(n);

//        System.out.println("Enter the elements: ");
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//
//                int e = sc.nextInt();
//                if (i != j) {
//                    continue;
//                }
//                dm.insert(i + 1, j + 1, e);
//            }
//        }
//
//        dm.display();

//        LowerTriangularMatrix ltm = new LowerTriangularMatrix(n);
//
//        System.out.println("Enter the elements: ");
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                int e = sc.nextInt();
//                if (i >= j) {
//                    ltm.insert(i + 1, j + 1, e);
//                }
//            }
//        }
//
//        ltm.display();

//        UpperTriangularMatrix utm = new UpperTriangularMatrix(n);
//
//        System.out.println("Enter the elements: ");
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                int e = sc.nextInt();
//                if (j >= i) {
//                    utm.insert(i + 1, j + 1, e);
//                }
//            }
//        }
//
//        utm.display();

//        SymmetricMatrix utm = new SymmetricMatrix(n);
//
//        System.out.println("Enter the elements: ");
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                int e = sc.nextInt();
//                if (i >= j) {
//                    utm.insert(i + 1, j + 1, e);
//                }
//            }
//        }
//
//        utm.display();

//        TriDiagonalMatrix tdm = new TriDiagonalMatrix(n);
//
//        System.out.println("Enter the elements: ");
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                int e = sc.nextInt();
//                if (i - j == -1 || i - j == 0 || i - j == 1) {
//                    tdm.insert(i + 1, j + 1, e);
//                }
//            }
//        }
//
//        tdm.display();

//

        int rowSize = sc.nextInt();
        int colSize = sc.nextInt();

        SparseMatrix sm = new SparseMatrix(rowSize, colSize);

        System.out.println("Enter the elements: ");
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                int e = sc.nextInt();

                sm.insert(i + 1, j + 1, e);

            }
        }

        sm.display();
    }
}
