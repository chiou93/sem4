package geekbrains;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Task1 {
    static final int[][] DIRECTIONS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int[][] updateMatrix(int[][] mat) {

        Queue<int[]> q = new LinkedList<>();

        int[][] ans = new int[mat.length][mat[0].length];
        for (int[] num : ans) {
            Arrays.fill(num, -1);
        }

        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[0].length; col++) {
                if (mat[row][col] == 0) {
                    q.add(new int[] { row, col });
                    ans[row][col] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] curPoint = q.poll();
            int curRow = curPoint[0];
            int curCol = curPoint[1];

            for (int[] direction : DIRECTIONS) {
                int newRow = curRow + direction[0];
                int newCol = curCol + direction[1];
                if (check(newRow, newCol, mat.length, mat[0].length)
                        && ans[newRow][newCol] == -1) {
                    q.add(new int[] { newRow, newCol });
                    ans[newRow][newCol] = ans[curRow][curCol] + 1;
                }
            }
        }
        return ans;
    }

    public boolean check(int i, int j, int m, int n) {
        return (i >= 0 && j >= 0 && i < m && j < n);
    }
}

/*
 * class Solution {
 * public int[][] updateMatrix(int[][] mat) {
 * int m = mat.length;
 * int n = mat[0].length;
 * int[][] res = new int[m][n];
 * for (int i = 0; i < m; i++) {
 * for (int j = 0; j < n; j++) {
 * if (mat[i][j] == 0) {
 * res[i][j] = 0;
 * } else {
 * res[i][j] = Integer.MAX_VALUE;
 * }
 * }
 * }
 * for (int i = 0; i < m; i++) {
 * for (int j = 0; j < n; j++) {
 * if (i > 0) {
 * res[i][j] = Math.min(res[i][j], res[i - 1][j] + 1);
 * }
 * if (j > 0) {
 * res[i][j] = Math.min(res[i][j], res[i][j - 1] + 1);
 * }
 * }
 * }
 * for (int i = m - 1; i >= 0; i--) {
 * for (int j = n - 1; j >= 0; j--) {
 * if (i < m - 1) {
 * res[i][j] = Math.min(res[i][j], res[i + 1][j] + 1);
 * }
 * if (j < n - 1) {
 * res[i][j] = Math.min(res[i][j], res[i][j + 1] + 1);
 * }
 * }
 * }
 * return res;
 * }
 * }
 */
