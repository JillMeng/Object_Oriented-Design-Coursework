package cs3500.tictactoe;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 * A panel that can hold the actual TicTacToe game.
 */
class TicTacToePanel extends JPanel {
  /** Generated serial version uid required for JPanel. */
  private static final long serialVersionUID = 6516963047145839793L;

  private final ReadonlyTicTacToeModel model;

  public static final int CELL_DIM = 80;
  public static final int OFFSET = 80;
  public static final int FONT_SIZE = 40;
  public static final String FONT_FACE = "Helvetica";

  /**
   * Constructor for TicTacToe panel.
   * 
   * @param m the model
   */
  TicTacToePanel(ReadonlyTicTacToeModel m) {
    model = m;
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;

    // draw grid lines (2 vertical, 2 horizontal)

    // iterate over board, draw X/O in appropriate cell

    // if game is over, draw game-over message
    // else draw whose turn it is

    // g2.drawImage(ImageIO.read(new File("player.png")), 30, 20); // display an image from file
    for (int i = 1; i < 3; i++) {
      g2.drawLine(i * CELL_DIM + OFFSET, OFFSET, i * CELL_DIM + OFFSET, 3 * CELL_DIM + OFFSET);
      g2.drawLine(OFFSET, i * CELL_DIM + OFFSET, 3 * CELL_DIM + OFFSET, i * CELL_DIM + OFFSET);
    }
    g2.setFont(new Font(FONT_FACE, Font.PLAIN, FONT_SIZE));
    Player[][] board = model.getBoard();
    for (int r = 0; r < 3; r++) {
      for (int c = 0; c < 3; c++) {
        if (board[r][c] != null) {
          g2.drawString(board[r][c].toString(), Math.round((c + 0.29) * CELL_DIM + OFFSET),
              Math.round((r + 0.7) * CELL_DIM + OFFSET));
        }
      }
    }
    if (model.isGameOver()) {
      g2.drawString(
          "Game over: "
              + (model.getWinner() == null ? "tie game." : model.getWinner().toString() + " wins."),
          OFFSET, OFFSET - 4);
    } else {
      g2.drawString("Turn: " + model.getTurn().toString(), OFFSET, OFFSET - 4);
    }
  }
}
