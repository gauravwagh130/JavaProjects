import java.util.Arrays;
import java.util.Scanner;

public class ConnectFourGame {
    public static void main(String[] args) {
        int rows = 6;
        int columns = 7;
        char[][] board = createBoard(rows, columns);
        boolean gameOver = false;
        char currentPlayer = 'X';

        while (!gameOver) {
            printBoard(board);
            int colChoice = getValidColumnChoice(board);
            dropDisc(board, colChoice, currentPlayer);
            gameOver = checkForWin(board, colChoice, currentPlayer);
            if (isBoardFull(board) && !gameOver) {
                System.out.println("It's a draw!");
                break;
            }
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        printBoard(board);
        System.out.println(currentPlayer + " wins!");
    }

    public static char[][] createBoard(int rows, int columns) {
        char[][] board = new char[rows][columns];
        for (char[] row : board) {
            Arrays.fill(row, ' ');
        }
        return board;
    }

    public static void printBoard(char[][] board) {
        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("1 2 3 4 5 6 7");
    }

    public static int getValidColumnChoice(char[][] board) {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice < 1 || choice > board[0].length || isColumnFull(board, choice - 1)) {
            System.out.print("Player " + (board[0].length % 2 == 0 ? 'X' : 'O') + ", choose a column (1-7): ");
            choice = scanner.nextInt();
        }
        return choice - 1;
    }

    public static boolean isColumnFull(char[][] board, int col) {
        return board[0][col] != ' ';
    }

    public static void dropDisc(char[][] board, int col, char player) {
        for (int row = board.length - 1; row >= 0; row--) {
            if (board[row][col] == ' ') {
                board[row][col] = player;
                break;
            }
        }
    }

    public static boolean checkForWin(char[][] board, int col, char player) {
        int row = getLastFilledRow(board, col);
        return checkVertical(board, row, col, player) ||
                checkHorizontal(board, row, col, player) ||
                checkDiagonal(board, row, col, player);
    }

    public static int getLastFilledRow(char[][] board, int col) {
        for (int row = 0; row < board.length; row++) {
            if (board[row][col] != ' ') {
                return row;
            }
        }
        return -1;
    }

    public static boolean checkVertical(char[][] board, int row, int col, char player) {
        int count = 0;
        for (int i = row; i < board.length; i++) {
            if (board[i][col] == player) {
                count++;
                if (count == 4) {
                    return true;
                }
            } else {
                break;
            }
        }
        return false;
    }

    public static boolean checkHorizontal(char[][] board, int row, int col, char player) {
        int count = 0;

        // Check left
        for (int i = col; i >= 0; i--) {
            if (board[row][i] == player) {
                count++;
            } else {
                break;
            }
        }

        // Check right
        for (int i = col + 1; i < board[0].length; i++) {
            if (board[row][i] == player) {
                count++;
            } else {
                break;
            }
        }

        return count >= 4;
    }

    public static boolean checkDiagonal(char[][] board, int row, int col, char player) {
        return checkDiagonalUp(board, row, col, player) || checkDiagonalDown(board, row, col, player);
    }

    public static boolean checkDiagonalUp(char[][] board, int row, int col, char player) {
        int count = 1;
        int r = row - 1;
        int c = col - 1;

        while (r >= 0 && c >= 0 && board[r][c] == player) {
            count++;
            r--;
            c--;
        }

        r = row + 1;
        c = col + 1;

        while (r < board.length && c < board[0].length && board[r][c] == player) {
            count++;
            r++;
            c++;
        }

        return count >= 4;
    }

    public static boolean checkDiagonalDown(char[][] board, int row, int col, char player) {
        int count = 1;
        int r = row - 1;
        int c = col + 1;

        while (r >= 0 && c < board[0].length && board[r][c] == player) {
            count++;
            r--;
            c++;
        }

        r = row + 1;
        c = col - 1;

        while (r < board.length && c >= 0 && board[r][c] == player) {
            count++;
            r++;
            c--;
        }

        return count >= 4;
    }

    public static boolean isBoardFull(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
