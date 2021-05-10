/**
 * This interface represents a random ChessPiece. It is the super-type for any given chess piece
 * from the chess game.
 */
public interface ChessPiece {

  /**
   * The ChessPiece class initialize a chess piece on the chessboard; this method takes the chess
   * piece and return the row that the chess piece is initially positioned.
   *
   * @return an int value as the row number from the chessboard.
   */
  int getRow();

  /**
   * The ChessPiece class initialize a chess piece on the chessboard; this method takes the chess
   * piece and return the column that the chess piece is initially positioned.
   *
   * @return an int value as the column number from the chessboard.
   */
  int getColumn();

  /**
   * The ChessPiece class initialize a chess piece on the chessboard; this method takes the chess
   * piece and return the color of that the chess piece.
   *
   * @return an enum value indicating the color of the chess piece.
   */
  Color getColor();

  /**
   * This method takes a row and a column value on the chess board and test whether the current
   * chess piece can move to the given cell position. The exceptions will be thrown when pass on the
   * row and col value to the new Cell class. Therefore, no need to throw an exception here.
   *
   * @param row an int value indicating the row position on the chessboard.
   * @param col an int value indicating the column position on the chessboard.
   * @return true if the current piece can move to the new cell, false if it cannot move to the new
   *     cell.
   */
  boolean canMove(int row, int col);

  /**
   * This method takes a new ChessPiece object, the current chess piece can kill the new chess piece
   * when it can move to the new piece's cell and the new piece is an opponent’s piece; otherwise
   * return false.
   *
   * @param piece a new ChessPiece object that the current ChessPiece tries to kill.
   * @return true when the current ChessPiece can move to the new piece's cell and the new piece is
   *     in the opposite color.
   */
  boolean canKill(ChessPiece piece);


}
