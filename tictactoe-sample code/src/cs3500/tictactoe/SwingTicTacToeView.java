package cs3500.tictactoe;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

/**
 * Visual view for TicTacToe using Java Swing.
 */
public class SwingTicTacToeView extends JFrame implements TicTacToeView {
  /** Generated serial version unique id required for JFrame. */
  private static final long serialVersionUID = 492024387006612963L;

  private final TicTacToePanel panel;

  /**
   * Construct the view, giving it a readonly model so it can access the latest game state.
   * @param windowTitle the title of the main window
   * @param m the game model
   */
  public SwingTicTacToeView(String windowTitle, ReadonlyTicTacToeModel m) {
    super(windowTitle);

    setSize(500, 400);
    setLocation(200, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    panel = new TicTacToePanel(m);
    this.add(panel);
  }

  @Override
  public void addClickListener(TicTacToeController l) {
    MouseListener ml = new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        int row = (e.getY() - TicTacToePanel.OFFSET) / TicTacToePanel.CELL_DIM;
        int col = (e.getX() - TicTacToePanel.OFFSET) / TicTacToePanel.CELL_DIM;
        l.handleCellClick(row, col);
      }
    };
    panel.addMouseListener(ml);
  }

  @Override
  public void refresh() {
    this.repaint();
  }

  @Override
  public void makeVisible() {
    this.setVisible(true);
  }
}
