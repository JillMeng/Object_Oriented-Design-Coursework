/**
 * This class represents a Knight piece, and it extends from AbstractChessPiece and contains all the
 * methods mandated by the ChessPiece interface.
 */
public class Knight extends AbstractChessPiece {

  public Knight(int row, int col, Color color) {
    super(row, col, color);
  }

  @Override
  public boolean canMove(int row, int col) {
    Cell currentCell = new Cell(this.getRow(),this.getColumn());
    Cell nextCell = new Cell(row,col);
    return currentCell.moveLPattern(nextCell);
  }
}

