package site.twofish.DP.No221;

/**
 * @author:ganggang
 * @create:2020-05-08
 * @description:第221题，最大正方形
 **/

// 朴素算法，暴力破解，遍历每个点，如果为1 就以该点为正方形左上角，往右往下找最长的正方形。
class Solution1 {
    public int maximalSquare(char[][] matrix) {
        int rowNum = matrix.length;
        if (rowNum == 0) {
            return 0;
        }
        int colNum = matrix[0].length;
        int maxLength = 0;
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                if (matrix[i][j] == '1') {
                    boolean flag = true;
                    int maxLoop = rowNum - 1 - i < colNum - 1 - j ? rowNum - 1 - i : colNum - 1 - j;
                    for (int l = 1; l <= maxLoop && flag; l++) {
                        for (int x = 0; x <= l && flag; x++) {
                            if (matrix[i + l][j + x] != '1') {
                                maxLength = l > maxLength ? l : maxLength;
                                flag = false;
                            }
                        }
                        for (int y = 0; y <= l && flag; y++) {
                            if (matrix[i + y][j + l] != '1') {
                                maxLength = l > maxLength ? l : maxLength;
                                flag = false;
                            }
                        }
                    }
                    if (flag) {
                        maxLength = maxLoop + 1 > maxLength ? maxLoop + 1 : maxLength;
                    }
                }

            }
        }
        return maxLength * maxLength;
    }
}

/**
 * 动态规划--d[i][j],表示以ij为右下角的正方形的最大边长
 * 最佳子问题
 * 状态转移方程
 * 记录子问题的结果，避免重复计算子问题，大问题通过子问题的结果得到
 */
class Solution2 {

    public int maximalSquare(char[][] matrix) {
        int rowNum = matrix.length;
        if (rowNum == 0) {
            return 0;
        }
        int colNum = matrix[0].length;
        if (colNum == 0) {
            return 0;
        }
        int[][] d = new int[rowNum][colNum];
        for (int i = 0; i < rowNum; i++) {
            d[i][0] = matrix[i][0] == '1' ? 1 : 0;
        }
        for (int j = 0; j < colNum; j++) {
            d[0][j] = matrix[0][j] == '1' ? 1 : 0;
        }
        for (int i = 1; i < rowNum; i++) {
            for (int j = 1; j < colNum; j++) {
                if (matrix[i][j] == '1') {
                    d[i][j] = Math.min(Math.min(d[i - 1][j], d[i][j - 1]), d[i - 1][j - 1]) + 1;
                } else {
                    d[i][j] = 0;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                max = d[i][j] > max ? d[i][j] : max;
            }
        }
        return max * max;
    }
}

public class No221 {

    public static void main(String[] args) {
        /*char[][] matrix = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};*/
        char[][] matrix = new char[][]{{'1'}};
        Solution2 solution = new Solution2();
        solution.maximalSquare(matrix);
    }
}
