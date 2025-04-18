package patterns;

// https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/
public class Patterns {
    static void square(int n){
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    static void rightAngleTriangle(int n){
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void rightAngleNumberedTriangle(int n){
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(col +  " ");
            }
            System.out.println();
        }
    }

    static void rightAngleNumberedTriangleTwo(int n){
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(row +  " ");
            }
            System.out.println();
        }
    }

    static void flippedRightAngleTriangle(int n){
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n - row + 1; col++) {
                System.out.print( "* ");
            }
            System.out.println();
        }
    }

    static void flippedRightAngleNumberedTriangle(int n){
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n - row + 1; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    static void isoScaleTriangle(int n){
        for (int row = 1; row <= n ; row++) {
            // for space
            for (int col = 1; col <= 2 * n + 1 - row ; col++) {
                System.out.print(" ");
            }

            // for printing *
            for (int col = 1; col <= 2 * (row - 1) + 1; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }

    }

    static void flippedIsoScaleTriangle(int n){
        for (int row = 1; row <= n ; row++) {
            // for space
            for (int col = 1; col <= 2 * (row - 1) + 1; col++) {
                System.out.print(" ");
            }

            // for printing *
            for (int col = 1; col <= 2 * n + 1 - 2 * row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void diamond(int n){
        for (int row = 1; row <= 2 * n; row++) {
            // spaces
            for (int col = 1; row <= n ? col <= n - row : col <= row - n - 1; col++) {
                System.out.print(" ");
            }
            // print *
            for (int col = 1; row <= n ? col <= row : col <= 2 * n + 1 - row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pyramid(int n){
        for (int row = 1; row <= 2 * n - 1; row++) {
            for (int col = 1; row <= n ? col <= row : col <= 2 * n - row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void binaryTriangle(int n){
        int lastStart = 1;
        for (int row = 1; row <= n; row++) {
            int num = lastStart;
            for (int col = 1 ; col <= row; col++) {
                System.out.print(num + " ");
                num ^= 1;
            }
            lastStart ^= 1;
            System.out.println();
        }
    }

    static void doubleNumberedTriangle(int n){
        for (int row = 1; row <= n; row++) {
            // first triangle
            for (int col = 1; col <= row; col++) {
                System.out.print(col + " ");
            }
            // space
            for (int col = 1; col <= 4 * (n - row); col++) {
                System.out.print(" ");
            }

            // second triangle
            for (int col = row; col >= 1 ; col--) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    static void naturalNumberTriangle(int n){
        int num = 1;
        for (int row = 1; row <= n; row++) {
            for (int col = 0; col < row; col++) {
                System.out.print(num++ + " ");
            }
            System.out.println();
        }
    }

    static void alphabetTriangle(int n){
        for (int row = 0; row < n; row++) {
            for (int col = 0; col <= row; col++) {
                System.out.print((char) ('A' + col) + " ");
            }
            System.out.println();
        }
    }

    static void flippedAlphabetTriangle(int n){
        for (int row = 0; row < n; row++) {
            for (int col = 0; col <= n - row - 1; col++) {
                System.out.print((char) ('A' + col) + " ");
            }
            System.out.println();
        }
    }

    static void alphabetTriangleTwo(int n){
        for (int row = 0; row < n; row++) {
            for (int col = 0; col <= row; col++) {
                System.out.print((char) ('A' + row) + " ");
            }
            System.out.println();
        }
    }

    static void mirroredAlphabetTriangle(int n){
        for (int row = 1; row <= n; row++) {
            // spaces
            for (int col = 1; col <= 2 * (n - row) + 1; col++) {
                System.out.print(" ");
            }
            // first-half
            for (int col = 0; col < row; col++) {
                System.out.print((char) ('A' + col) + " ");
            }
            // second half
            for (int col = 0; col < row - 1; col++) {
                System.out.print((char) ('A' + row - col - 2) + " ");
            }
            System.out.println();
        }
    }

    static void alphabetTriangleThree(int n){
        for (int row = 0; row < n; row++) {
            for (int col = 0; col <= row; col++) {
                System.out.print((char) ('A' + n - row + col - 1) + " ");
            }
            System.out.println();
        }
    }

    static void hollowDiamond(int n){
        for (int row = 1; row <= 2 * n; row++) {
            // first half
            for (int col = 1; row <= n ? col <= n - row + 1 : col <= row - n; col++) {
                System.out.print("* ");
            }
            // space
            for (int col = 1; row <= n ? col < 2 * row - 1 : col < 4 * n - 2 * row + 1 ; col++) {
                System.out.print("  ");
            }
            // second half
            for (int col = 1; row <= n ? col <= n - row + 1 : col <= row - n; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void butterfly(int n){
        for (int row = 1; row <= 2 * n - 1; row++) {
            // first half
            for (int col = 1; row <= n ? col <= row : col <= 2 * n - row ; col++) {
                System.out.print("* ");
            }
            // space
            for (int col = 1; row <= n ? col <= 2 * (n - row) : col <= 2 * (row - n) ; col++) {
                System.out.print("  ");
            }
            // second half
            for (int col = 1; row <= n ? col <= row : col <= 2 * n - row ; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void hollowSquare(int n){
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n; col++) {
                if (row == 1 || row == n || col == 1 || col == n){
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    static void concentricNumberedSquare(int n){
        for (int row = 1; row <= 2 * n - 1; row++) {
            for (int col = 1; col <= 2 * n - 1; col++) {
                // value should be the n - minimum distance between (from top, from bottom, from right and from left)
                int right = 2 * n - 1 - col;
                int left = col - 1;
                int top = row - 1;
                int bottom = 2 * n - 1 - row;

                System.out.print(n - Math.min(Math.min(right, left), Math.min(top, bottom)) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        square(5);
        rightAngleTriangle(5);
        rightAngleNumberedTriangle(5);
        rightAngleNumberedTriangleTwo(5);
        flippedRightAngleTriangle(5);
        flippedRightAngleNumberedTriangle(5);
        isoScaleTriangle(5);
        flippedIsoScaleTriangle(5);
        diamond(5);
        pyramid(5);
        binaryTriangle(5);
        doubleNumberedTriangle(5);
        naturalNumberTriangle(5);
        alphabetTriangle(5);
        flippedAlphabetTriangle(5);
        alphabetTriangleTwo(5);
        mirroredAlphabetTriangle(5);
        alphabetTriangleThree(5);
        hollowSquare(5);
        hollowDiamond(5);
        butterfly(5);
        concentricNumberedSquare(5);
    }
}
