import static org.junit.Assert.assertEquals;

import cs3500.tictactoe.ConsoleTicTacToeController;
import cs3500.tictactoe.MockTicTacToeView;
import cs3500.tictactoe.TicTacToe;
import cs3500.tictactoe.TicTacToeController;
import cs3500.tictactoe.TicTacToeModel;
import org.junit.Test;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Test cases for the TicTacToe controller, using mocks for readable and
 * appendable.
 */
public class TicTacToeControllerTest {

  // ADDITIONAL TEST CASES TO IMPLEMENT:
  // Play game to completion, where there is a winner
  // Input where the q comes instead of an integer for the row
  // Input where the q comes instead of an integer for the column
  // Input where non-integer garbage comes instead of an integer for the row
  // Input where non-integer garbage comes instead of an integer for the column
  // Input where the move is integers, but outside the bounds of the board
  // Input where the move is integers, but invalid because the cell is occupied
  // Multiple invalid moves in a row of various kinds
  // Input including valid moves interspersed with invalid moves, game is played
  // to completion
  // What happens when the input ends "abruptly" -- no more input, but not quit,
  // and game not over
  // THIS IS NOT AN EXHAUSTIVE LIST

  /** Testing the single valid move. */
  @Test
  public void testSingleValidMove() {
    TicTacToe m = new TicTacToeModel();
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new ConsoleTicTacToeController(new StringReader("2 2 q"), gameLog, m);
    c.playGame();
    assertEquals("   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n" + "Enter a move for X:\n" + "   |   |  \n" + "-----------\n"
        + "   | X |  \n" + "-----------\n" + "   |   |  \n" + "Enter a move for O:\n"
        + "Game quit! Ending game state:\n" + "   |   |  \n" + "-----------\n" + "   | X |  \n"
        + "-----------\n" + "   |   |  \n", gameLog.toString());
  }

  /** Testing row value that is bogus. */
  @Test
  public void testBogusInputAsRow() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("!#$ 2 q");
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new ConsoleTicTacToeController(input, gameLog, m);
    c.playGame();
    // split the output into an array of lines
    String[] lines = gameLog.toString().split("\n");
    // check that it's the correct number of lines
    assertEquals("Number of lines of output does not match", 13, lines.length);
    // check that the last 6 lines are correct
    String lastMsg = String.join("\n", Arrays.copyOfRange(lines, lines.length - 6, lines.length));
    assertEquals(
        "Last six lines of output not as expected", "Game quit! Ending game state:\n"
            + "   |   |  \n" + "-----------\n" + "   |   |  \n" + "-----------\n" + "   |   |  ",
        lastMsg);
    // note no trailing \n here, because of the earlier split
  }

  /** Testing a tied game. */
  @Test
  public void testTieGame() {
    TicTacToe m = new TicTacToeModel();
    // note the entire sequence of user inputs for the entire game is in this one
    // string:
    StringReader input = new StringReader("2 2 1 1 3 3 1 2 1 3 2 3 2 1 3 1 3 2");
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new ConsoleTicTacToeController(input, gameLog, m);
    c.playGame();
    String[] lines = gameLog.toString().split("\n");
    assertEquals("Number of lines of output not as expected", 60, lines.length);
    assertEquals("Last line of output not as expected", "Game is over! Tie game.",
        lines[lines.length - 1]);
  }

  /** Testing bad input. */
  @Test(expected = IllegalStateException.class)
  public void testFailingAppendable() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("2 2 1 1 3 3 1 2 1 3 2 3 2 1 3 1 3 2");
    Appendable gameLog = new FailingAppendable();
    TicTacToeController c = new ConsoleTicTacToeController(input, gameLog, m);
    c.playGame();
  }

  /** Testing abrupt end in the input. */
  @Test(expected = IllegalStateException.class)
  public void testAbruptInputEnd() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("2 2 1 1 3 3 1 2 1 3 2 3 2 1 3 1 3");
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new ConsoleTicTacToeController(input, gameLog, m);
    c.playGame();
    System.out.println(gameLog.toString());
  }

  /** Testing visual controller. */
  @Test
  public void testVisualController() {
    List<String> log = new ArrayList<>();
    new MockTicTacToeView(log);
    // set up controller, but give it Mock View
    // call controller method: actionPerformed, pause, whatever
    assertEquals(Arrays.asList("refresh was called", "addClickListener was called"), log);
  }

}
