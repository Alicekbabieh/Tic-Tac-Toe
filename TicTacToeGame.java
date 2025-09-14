package alicekbabieh.projects.tictactoegame;

import java.util.*;
public class TicTacToeGame {

    public static void main(String[] args) {
       TicTacToe game = new TicTacToe();
        Scanner in = new Scanner (System.in); 
        System.out.println("You have entered a tickTackToe game");
        game.printBoard();

        while(!game.isGameOver()) {
            System.out.println("Player " + game.getCurrentPlayer() + " , enter your move (row and column, 1-3): ");
            int row = in.nextInt() - 1; 
            int column = in.nextInt() - 1;
            
            if(!game.makeMove(row, column)) {
                System.out.println("Incorrect move. Please try again. ");
                continue;
            }
            game.printBoard();
            
            if(game.checkWin()) {
                 System.out.println("Player " + game.getCurrentPlayer() + " wins!"); 
                 return;
            }
            if(game.checkTie()) {
                 System.out.println("It is a tie game!"); 
                 return;
            }
            game.switchPlayer();
        }
        in.close();
    }
}
