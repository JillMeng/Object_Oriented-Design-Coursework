package cs3500.tictactoe;

/**
 * Controller for TicTacToe: handle user clicks by making the corresponding
 * moves.
 */
public class SwingTicTacToeController implements TicTacToeController {
  private final TicTacToeView view;
  private final TicTacToe model;

  /**
   * Construct the controller by giving it the view.
   * 
   * @param v the view
   * @param m a non-null TicTacToe Model
   */
  public SwingTicTacToeController(TicTacToeView v, TicTacToe m) {
    // check for null
    this.view = v;
    this.model = m;
  }

  @Override
  public void playGame() {
    view.addClickListener(this);
    view.makeVisible();
  }

  @Override
  public void handleCellClick(int row, int col) {
    try {
      model.move(row, col);
      view.refresh();
    } catch (IllegalArgumentException | IllegalStateException e) {
      // purposely do nothing if move was illegal
    }
  }
}
