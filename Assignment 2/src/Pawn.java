/**
 * This class represents a Pawn piece, and it extends from AbstractChessPiece and contains all the
 * methods mandated by the ChessPiece interface.
 */
public class Pawn extends AbstractChessPiece {

  private Cell currentCell;
  private Cell nextCell;

  public Pawn(int row, int col, Color color) {
    super(row, col, color);
  }

  @Override
  public boolean canMove(int row, int col) {
    currentCell = new Cell(this.getRow(), this.getColumn());
    nextCell = new Cell(row, col);
    if (this.color == Color.WHITE) {
      return currentCell.moveUpward(nextCell);
    }
    return currentCell.moveDownward(nextCell);
  }

  @Override
  public boolean canKill(ChessPiece piece) {
    currentCell = new Cell(this.getRow(), this.getColumn());
    nextCell = new Cell(piece.getRow(), piece.getColumn());
    if (this.getColor() == Color.WHITE && piece.getColor() == Color.BLACK) {
      return currentCell.moveUpDiagonally(nextCell);
    } else if (this.getColor() == Color.BLACK && piece.getColor() == Color.WHITE) {
      return currentCell.moveDownDiagonally(nextCell);
    }
    return false;
  }
}
