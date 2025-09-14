package alicekbabieh.projects.tictactoegame;

public class TicTacToe {
    private final char[][] board = new char[3][3];
    private char currentPlayer = 'X'; 
    
    public TicTacToe() {
        // loop 
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }
    public char getCurrentPlayer() {
        return currentPlayer; 
    }
    
    public void switchPlayer() { 
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
    
    public boolean makeMove(int row, int column) {
        if(row < 0 || row > 2 || column < 0 || column > 2) return false; 
        if(board[row][column] != ' ') return false; 
        board[row][column] = currentPlayer; 
        return true; 
    }
    
    public boolean checkWin() {
        for(int i = 0; i < 3; i++) {
            if(board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) return true;
            if(board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) return true;
        }
        return (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) || (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer); 
    }
    
    public boolean checkTie() {
        for(char[] row : board) {
            for(char cell: row) {
                if(cell == ' ') return false;
            }
        } return true;
    }
    
    public boolean isGameOver() {
        return checkWin() || checkTie();
        
    }
    
    public void printBoard() {
        System.out.println("\nBoard: "); 
        for(int i = 0; i < 3; i++) {
            System.out.print(" ");
            for(int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if(j < 2) System.out.print(" | ");
            }
            System.out.println();
            if(i < 2) System.out.println("---+---+---");
        }
        System.out.println();
    }
}