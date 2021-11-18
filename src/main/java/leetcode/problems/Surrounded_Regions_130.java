package leetcode.problems;

/**
 * https://leetcode.com/problems/surrounded-regions/
 * >>> MEDIUM
 * Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * Surrounded regions should not be on the border: any 'O' on the border of the board are not flipped to 'X'.
 * Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'.
 * Two cells are connected if they are adjacent cells connected horizontally or vertically.
 *
 * 1 <= m, n <= 200
 *
 * Tags:
 */
public class Surrounded_Regions_130 {

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        // skip top and bottom rows
        for (int i = 1; i <= m/2; i++) {
            // first+1
            for (int j = 1; j < n-1; j++) {
                if (board[i][j] == 'O') {
                    if (!has_O_neighborsTop(board, i, j, m, n)) {
                        board[i][j] = 'X';
                    }
                }
            }
            // last-1 column
            for (int j = 1; j < n-1; j++) {
                int idx = m-1-i;
                if (board[idx][j] == 'O') {
                    if (!has_O_neighborsBottom(board, idx, j, m, n)) {
                        board[idx][j] = 'X';
                    }
                }
            }
        }
    }

    private boolean has_O_neighborsTop(char[][] board, int i, int j, int m, int n) {
        if (j == 1) {
            if (board[i-1][j] == 'O' || board[i][0] == 'O') {
                return true;
            }
        } else if (j == n-2) {
            if (board[i-1][j] == 'O' || board[i][j+1] == 'O') {
                return true;
            }
        } else {
            if (board[i-1][j] == 'O') {
                return true;
            }
        }
        return false;
    }

    private boolean has_O_neighborsBottom(char[][] board, int i, int j, int m, int n) {
        if (j == 1) {
            if (board[i+1][j] == 'O' || board[i][0] == 'O') {
                return true;
            }
        } else if (j == n-2) {
            if (board[i+1][j] == 'O' || board[i][j+1] == 'O') {
                return true;
            }
        } else {
            if (board[i+1][j] == 'O') {
                return true;
            }
        }
        return false;
    }

    static void print(char[][] arr) {
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++)
                System.out.printf("%s", arr[row][col]);
            System.out.println(); //Makes a new row
        }
    }


    public static void main(String[] args) {
        Surrounded_Regions_130 app = new Surrounded_Regions_130();
        char[][] input = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        app.solve(input);
        print(input);
        System.out.println("---------");
        input = new char[][]{{'O','X','X','O','X'},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}};
        app.solve(input);
        print(input);
    }
}
