/**
 * This abstract class contains the operations/methods that are in common for all the five
 * ChessPiece; it is implemented from ChessPiece Interface and avoids code repetition for its
 * subclasses.
 */
public abstract class AbstractChessPiece implements ChessPiece {

  protected int row;
  protected int col;
  protected Color color;

  /**
   * Initialize a ChessPiece on the chess board given its row, column and color, and throw
   * exceptions when the cell initialization is out of range.
   *
   * @param row   initialize the row of on the chessboard for the piece
   * @param col   initialize the column of on the chessboard for the piece
   * @param color initialize the color of the chess piece.
   * @throws IllegalArgumentException when the position is out of range.
   */
  public AbstractChessPiece(int row, int col, Color color) {
    if (row > 7 || col > 7 || row < 0 || col < 0) {
      throw new IllegalArgumentException("This is a invalid position.");
    }
    this.row = row;
    this.col = col;
    this.color = color;
  }

  @Override
  public int getRow() {
    return this.row;
  }

  @Override
  public int getColumn() {
    return this.col;
  }

  @Override
  public Color getColor() {
    return this.color;
  }

  @Override
  public boolean canKill(ChessPiece piece) {
    return canMove(piece.getRow(), piece.getColumn())
            && this.getColor() != piece.getColor();
  }
}


