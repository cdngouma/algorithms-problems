/**
 * https://leetcode.com/problems/rotate-image/
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 */

class Solution {
    public void rotate(int[][] matrix) {
        int N = matrix.length;
        for(int r = 0; r < N / 2 ; r++) {
            for(int c = r; c < N - r - 1; c++) {
                int tmp = matrix[r][c];
                matrix[r][c] = matrix[N-1-c][r];
                matrix[N-1-c][r] = matrix[N-1-r][N-1-c];
                matrix[N-1-r][N-1-c] = matrix[c][N-1-r];
                matrix[c][N-1-r] = tmp;
            }
        }
    }
}