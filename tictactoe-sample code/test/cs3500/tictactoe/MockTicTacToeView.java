package cs3500.tictactoe;

import java.util.List;

/**
 * Mock for the view so that we can test that the controller does the right
 * thing.
 */
public class MockTicTacToeView implements TicTacToeView {
  private List<String> log;

  /**
   * Constructor.
   * 
   * @param log the log for testing
   */
  public MockTicTacToeView(List<String> log) {
    this.log = log;
  }

  @Override
  public void addClickListener(TicTacToeController listener) {
    log.add("addClickListener was called");
  }

  @Override
  public void refresh() {
    log.add("refresh was called");
  }

  @Override
  public void makeVisible() {
    log.add("makeVisible was called");
  }
}
