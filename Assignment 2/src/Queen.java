/**
 * This class represents a Queen piece, and it extends from AbstractChessPiece and contains all the
 * methods mandated by the ChessPiece interface.
 */
public class Queen extends AbstractChessPiece {

  public Queen(int row, int col, Color color) {
    super(row, col, color);
  }

  @Override
  public boolean canMove(int row, int col) {
    Cell currentCell = new Cell(this.getRow(), this.getColumn());
    Cell nextCell = new Cell(row, col);
    return currentCell.moveDiagonally(nextCell) || currentCell.moveHorizontally(nextCell)
            || currentCell.moveVertically(nextCell);
  }
}
