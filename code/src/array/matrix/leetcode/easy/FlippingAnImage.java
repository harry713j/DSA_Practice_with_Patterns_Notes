package array.matrix.leetcode.easy;

import java.util.Arrays;

public class FlippingAnImage {
    // https://leetcode.com/problems/flipping-an-image/description/
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;

        for(int[] row: image){
            for (int i = 0; i < (n + 1 ) / 2; i++){
                int temp = row[i] ^ 1;
                row[i] = row[n - 1 - i] ^ 1;
                row[n - 1 - i] = temp;
            }
        }

        return image;
        // Time: O(n ^ 2)
        // Space: O(1)
    }

    public static void main(String[] args) {
        FlippingAnImage fi = new FlippingAnImage();
        int[][] image = new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};

        image = fi.flipAndInvertImage(image);

        for(int[] a : image)
            System.out.println(Arrays.toString(a));
    }
}
