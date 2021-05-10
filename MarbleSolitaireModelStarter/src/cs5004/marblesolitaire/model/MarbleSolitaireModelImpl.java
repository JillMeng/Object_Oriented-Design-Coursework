package cs5004.marblesolitaire.model;

import java.util.ArrayList;
import java.util.List;

/**
 * A MarbleSolitaireModelImpl class that implements the MarbleSolitaireModel interface which
 * contains all the methods listed in the interface.
 */
public class MarbleSolitaireModelImpl implements MarbleSolitaireModel {

  private MarbleState[][] board;
  private int armThickness = 3;
  private int emptyRow = 3;
  private int emptyCol = 3;

  /**
   * The first constructor takes no parameters, and initialize the game board with arm thickness 3
   * and the empty slot at the center.
   */
  public MarbleSolitaireModelImpl() {
    this.board = new MarbleState[7][7];
    this.setBoard(emptyRow, emptyCol);
  }

  /**
   * A second constructor takes two parameters: sRow and sCol. It initializes the game board so that
   * the arm thickness is 3 and the empty slot is at the given position. If this specified position
   * is invalid, it should throw an IllegalArgumentException with a message "Invalid empty cell
   * position (r,c)" with 𝑟 and 𝑐 replaced with the row and column passed to it.
   *
   * @param sRow an int value that specify the row of the empty slot.
   * @param sCol an int value that specify the col of the empty slot.
   * @throws IllegalArgumentException when the specified cell is out of the boundary/not valid.
   */
  public MarbleSolitaireModelImpl(int sRow, int sCol) {
    if (sRow < 0 || sCol < 0 || sRow > 3 || sCol > 3) {
      throw new IllegalArgumentException("Cell is out of the board.");
    }
    if (isOutBoundary(sRow, sCol)) {
      throw new IllegalArgumentException(String
              .format("Invalid empty cell position (%d,%d).", sRow, sCol));
    }
    this.board = new MarbleState[7][7];
    this.emptyRow = sRow;
    this.emptyCol = sCol;
    this.setBoard(sRow, sCol);
  }

  /**
   * The third constructor takes the arm thickness as its only parameter and initialize a game board
   * with the empty slot at the center. It should throw an IllegalArgumentException if the arm
   * thickness is not a positive odd number.
   *
   * @param armThickness an int value specify the armThickness.
   * @throws IllegalArgumentException when the armThickness is smaller than 3 and is not an odd
   *                                  number.
   */
  public MarbleSolitaireModelImpl(int armThickness) {
    this.armThickness = armThickness;
    if (armThickness % 2 != 1 || armThickness < 3) {
      throw new IllegalArgumentException("The arm thickness must be an odd number " +
              "and bigger than 3");
    }
    int size = 3 * armThickness - 2;
    this.board = new MarbleState[size][size];
    this.emptyRow = (size - 1) / 2;
    this.emptyCol = (size - 1) / 2;
    this.setBoard(emptyRow, emptyCol);
  }

  /**
   * A fourth constructor takes the arm thickness, row and column of the empty slot in that order.
   * It should throw an IllegalArgumentException if the arm thickness is not a positive odd number,
   * or the empty cell position is invalid.
   *
   * @param armThickness an int value initializing the arm thickness.
   * @param sRow         an int value that specifies the row of the empty slot.
   * @param sCol         an int value that specifies the col of the empty slot.
   * @throws IllegalArgumentException when the armThickness is invalid or the empty slot is out of
   *                                  boundary.
   */
  public MarbleSolitaireModelImpl(int armThickness, int sRow, int sCol) {
    this.armThickness = armThickness;
    if (armThickness % 2 != 1 || armThickness < 3) {
      throw new IllegalArgumentException("The arm thickness must be an odd number "
             + "and bigger than 3");
    }
    if (isOutBoundary(sRow, sCol)) {
      throw new IllegalArgumentException(String
              .format("Invalid empty cell position (%d,%d).", sRow, sCol));
    }
    int size = 3 * armThickness - 2;
    this.board = new MarbleState[size][size];
    this.setBoard(sRow, sCol);
  }

  private boolean isOutBoundary(int r, int c) {
    int size = 3 * armThickness - 2;
    return (r < 0 || c < 0 || r > size - 1 || c > size - 1
            || ((r < armThickness - 1) && (c < armThickness - 1))
            || ((r < armThickness - 1) && (c > 2 * armThickness - 2))
            || ((r > 2 * armThickness - 2) && (c < armThickness - 1))
            || ((r > 2 * armThickness - 2) && (c > 2 * armThickness - 2)));
  }

  private void setBoard(int emptyRow, int emptyCol) {
    int size = board.length;
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if (!isOutBoundary(i, j)) {
          board[i][j] = MarbleState.MARBLE;
        } else {
          board[i][j] = MarbleState.SPACE;
        }
        if (i == emptyRow && j == emptyCol) {
          board[i][j] = MarbleState.EMPTY;
        }
      }
    }
  }

  private boolean isEmpty(int r, int c) {
    if (isOutBoundary(r, c)) {
      return false;
    }
    return (board[r][c] == MarbleState.EMPTY);
  }

  private boolean validMove(int fromRow, int fromCol, int toRow, int toCol) {
    if (isOutBoundary(fromRow, fromCol) || isOutBoundary(toRow, toCol)) {
      return false;
    }
    int midRow = (fromRow + toRow) / 2;
    int midCol = (fromCol + toCol) / 2;
    if (!isEmpty(fromRow, fromCol) && isEmpty(toRow, toCol) &&
            !isEmpty(midRow, midCol)) {
      return (Math.abs(fromRow - toRow) == 2 && (fromCol == toCol)
              || Math.abs(fromCol - toCol) == 2 && (fromRow == toRow));
    } else {
      return false;
    }
  }

  private boolean canMove(int r, int c) {
    if (isOutBoundary(r, c)) {
      return false;
    }
    return (validMove(r, c, r + 2, c) || validMove(r, c, r - 2, c)
            || validMove(r, c, r, c + 2) || validMove(r, c, r, c - 2));
  }

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    if (isOutBoundary(fromRow, fromCol) || isOutBoundary(toRow, toCol)) {
      throw new IllegalArgumentException("Cell is out of boundary");
    }
    int midRow = fromRow + (toRow - fromRow) / 2;
    int midCol = fromCol + (toCol - fromCol) / 2;
    if (validMove(fromRow, fromCol, toRow, toCol)) {
      board[fromRow][fromCol] = MarbleState.EMPTY;
      board[toRow][toCol] = MarbleState.MARBLE;
      board[midRow][midCol] = MarbleState.EMPTY;
    } else {
      throw new IllegalArgumentException("This move is invalid.");
    }
  }

  @Override
  public boolean isGameOver() {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        if (canMove(i, j)) {
          return false;
        }
      }
    }
    return true;
  }

  @Override
  public String getGameState() {
    List<String> list = new ArrayList();
    for (int rowTh = 0; rowTh < board.length; rowTh++) {
      List<String> temp = new ArrayList();
      if (rowTh < armThickness - 1 || rowTh >= (2 * armThickness - 1)) {
        for (int i = 0; i < (2 * armThickness - 1); i++) {
          temp.add(board[rowTh][i].toString());
        }
      } else {
        for (int i = 0; i < board[rowTh].length; i++) {
          temp.add(board[rowTh][i].toString());
        }
      }
      list.add(String.join(" ", temp));
    }
    return String.join("\n", list);
  }

  @Override
  public int getScore() {
    int score = 0;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        if (board[i][j] == MarbleState.MARBLE) {
          score++;
        }
      }
    }
    return score;
  }
}



