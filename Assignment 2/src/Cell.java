import static java.lang.Math.abs;

/**
 * This class represents a given cell position on the chessboard.
 */
public class Cell {

  private int row;
  private int col;

  /**
   * Construct a cell position on the chessboard with a given row and column value, and throw
   * exceptions when the cell position is out of range.
   *
   * @param row an int value initialize the row position on the chessboard
   * @param col an int value initialize the column position on the chessboard
   * @throws IllegalArgumentException when the given cell position is out of range.
   */
  public Cell(int row, int col) {
    if (row > 7 || col > 7 || row < 0 || col < 0) {
      throw new IllegalArgumentException("This is an invalid cell.");
    }
    this.row = row;
    this.col = col;
  }

  /**
   * A boolean expression to indicate whether the moving pattern is diagonal from the current cell
   * to a new cell.
   *
   * @param other the new cell object that indicates the position of the new cell.
   * @return true if the moving pattern is diagonal, otherwise return false.
   */
  public boolean moveDiagonally(Cell other) {
    return abs(this.row - other.row) == abs(this.col - other.col) && (this.row - other.row != 0);
  }

  /**
   * A boolean expression to indicate whether the moving pattern is L shape from the current cell to
   * a new cell.
   *
   * @param other the new cell object that indicates the position of the new cell.
   * @return true if the moving pattern is L shape, otherwise return false.
   */
  public boolean moveLPattern(Cell other) {
    return (abs(this.col - other.col) == 2 && abs(this.row - other.row) == 1) ||
            (abs(this.row - other.row) == 2 && abs(this.col - other.col) == 1);
  }

  /**
   * A boolean expression to indicate whether the moving pattern is horizontal from the current cell
   * to a new cell.
   *
   * @param other the new cell object that indicates the position of the new cell.
   * @return true if the moving pattern is horizontal, otherwise return false.
   */
  public boolean moveHorizontally(Cell other) {
    return this.row == other.row && this.col != other.col;
  }

  /**
   * A boolean expression to indicate whether the moving pattern is vertical from the current cell
   * to a new cell.
   *
   * @param other the new cell object that indicates the position of the new cell.
   * @return true if the moving pattern is vertical, otherwise return false.
   */
  public boolean moveVertically(Cell other) {
    return this.col == other.col && this.row != other.row;
  }

  /**
   * A boolean expression to indicate whether the moving pattern is upwards from the current cell to
   * a new cell.
   *
   * @param other the new cell object that indicates the position of the new cell.
   * @return true if the moving pattern is upwards, otherwise return false.
   */
  public boolean moveUpward(Cell other) {
    return this.col == other.col && other.row - this.row == 1;
  }

  /**
   * A boolean expression to indicate whether the moving pattern is diagonally upwards from the
   * current cell to a new cell.
   *
   * @param other the new cell object that indicates the position of the new cell.
   * @return true if the cell is moving up and diagonally, otherwise return false.
   */
  public boolean moveUpDiagonally(Cell other) {
    return abs(this.col - other.col) == 1 && other.row - this.row == 1;
  }

  /**
   * A boolean expression to indicate whether the moving pattern is downwards from the current cell
   * to a new cell.
   *
   * @param other the new cell object that indicates the position of the new cell.
   * @return true if the moving pattern is downwards, otherwise return false.
   */
  public boolean moveDownward(Cell other) {
    return this.col == other.col && other.row - this.row == -1;
  }

  /**
   * A boolean expression to indicate whether the moving pattern is diagonally downwards from the
   * current cell to a new cell.
   *
   * @param other the new cell object that indicates the position of the new cell.
   * @return true if the cell is moving down and diagonally, otherwise return false.
   */
  public boolean moveDownDiagonally(Cell other) {
    return abs(this.col - other.col) == 1 && other.row - this.row == -1;
  }
}
