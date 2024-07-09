package com.zzm.hot100.eighty;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100.eighty
 * @Author: zzm
 * @CreateTime: 2024-02-22  16:41
 * @Description: TODO
 * @Version: 1.0
 */
//79.单词搜索
public class SeventyNine {
    public static void main(String[] args) {
        SeventyNine seventyNine = new SeventyNine();
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println(seventyNine.exist(board, word));
    }
    public boolean exist(char[][] board, String word) {
        //思路：从board中的第一个起始位置开始，看是否能找到word的第一个字符。
        //如果找到了，则看这个字符的上下左右是否有word的下一个字符的位置，如果有则从这个位置开始继续找，如果没有则回溯到上一个位置。
        //如果找到了word的最后一个字符，则返回true，否则返回false。
        int row = board.length;
        int col = board[0].length;
        boolean[][] flag = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //从board中的每一个位置开始找
                if (dfs(board, word, i, j, 0, flag)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int i1, boolean[][] flag) {
        //flag[i][j]:表示board[i][j]是否已经被访问过
        //能通过该if语句的条件：1.没有访问过 2.在board的范围内 3.当前位置的字符等于word的第i1个字符
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || flag[i][j] || board[i][j] != word.charAt(i1)) {
            return false;
        }
        if (i1 == word.length() - 1) {
            return true;
        }
        flag[i][j] = true;//标记以为访问过
        if (
            dfs(board, word, i + 1, j, i1 + 1, flag) ||
            dfs(board, word, i - 1, j, i1 + 1, flag) ||
            dfs(board, word, i, j + 1, i1 + 1, flag) ||
            dfs(board, word, i, j - 1, i1 + 1, flag)
            )
        {
            return true;
        }
        flag[i][j] = false;//回溯
        //如果上下左右都没有找到word的下一个字符，则返回false
        return false;
    }
}
