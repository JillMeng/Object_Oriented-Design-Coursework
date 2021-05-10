package cs3500.tictactoe;

import java.io.InputStreamReader;

/**
 * Run a TicTacToe game interactively on the console.
 */
public class Main {
  /**
   * Run a TicTacToe game interactively on the console.
   * 
   * @param args not used
   */
  public static void main(String[] args) {
     //new ConsoleTicTacToeController(new InputStreamReader(System.in),
     //System.out, new TicTacToeModel()).playGame();
    TicTacToe m = new TicTacToeModel();
    TicTacToeView v = new SwingTicTacToeView("Tic-Tac-Toe", m);
    TicTacToeController c = new SwingTicTacToeController(v, m);
    c.playGame();
  }
}
