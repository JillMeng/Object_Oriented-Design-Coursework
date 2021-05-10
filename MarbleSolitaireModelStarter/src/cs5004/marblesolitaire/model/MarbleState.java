package cs5004.marblesolitaire.model;

/**
 * A enum class that represents the state of the position for the game.
 */
public enum MarbleState {
  MARBLE, EMPTY, SPACE;

  /**
   * A to String method that prints the String representation of the Marble status on the board.
   * @return a String representation of the Marble.
   */
  public String toString() {
    if (this == MarbleState.MARBLE) {
      return "O";
    } else if (this == MarbleState.EMPTY) {
      return "_";
    } else {
      return " ";
    }
  }
}

