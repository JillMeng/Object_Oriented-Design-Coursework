import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * This class contains all the unit test for methods listed in ChessPiece that live in the Bishop
 * class and also extended from AbstractChessPiece class.
 */
public class BishopTest {

  private Bishop cp1;
  private Bishop cp2;


  @Before
  public void setUp() {
    cp1 = new Bishop(0, 2, Color.WHITE);
    cp2 = new Bishop(5, 6, Color.BLACK);
  }

  /**
   * Test initial illegal ChessPiece setup and throw IllegalArgumentExceptions.
   *
   * @throws IllegalArgumentException when the row initialization is more than 7.
   */
  @Test(expected = IllegalArgumentException.class)
  public void IllegalSetUp1() throws IllegalArgumentException {
    Bishop illegalC1 = new Bishop(8, 0, Color.BLACK);
  }

  /**
   * Test initial illegal ChessPiece setup and throw IllegalArgumentExceptions.
   *
   * @throws IllegalArgumentException when the row initialization is less than 0.
   */
  @Test(expected = IllegalArgumentException.class)
  public void IllegalSetUp2() throws IllegalArgumentException {
    Bishop illegalC2 = new Bishop(-1, 0, Color.BLACK);
  }

  /**
   * Test initial illegal ChessPiece setup and throw IllegalArgumentExceptions.
   *
   * @throws IllegalArgumentException when the column initialization is more than 7.
   */
  @Test(expected = IllegalArgumentException.class)
  public void IllegalSetUp3() throws IllegalArgumentException {
    Bishop illegalC3 = new Bishop(0, 9, Color.BLACK);
  }

  /**
   * Test initial illegal ChessPiece setup and throw IllegalArgumentExceptions.
   *
   * @throws IllegalArgumentException when the column initialization is less than 0.
   */
  @Test(expected = IllegalArgumentException.class)
  public void IllegalSetUp4() throws IllegalArgumentException {
    Bishop illegalC4 = new Bishop(0, -1, Color.BLACK);
  }

  /**
   * Test the ChessPiece constructors assign values properly via testing the getter methods.
   */
  @Test
  public void getterTest() {
    assertEquals(0, cp1.getRow());
    assertEquals(2, cp1.getColumn());
    assertEquals(Color.WHITE, cp1.getColor());

    assertEquals(5, cp2.getRow());
    assertEquals(6, cp2.getColumn());
    assertEquals(Color.BLACK, cp2.getColor());
  }

  /**
   * Test whether illegalArgument will be thrown when the move to position is not on the chessboard
   * range.
   *
   * @throws IllegalArgumentException when the move to position is out of range.
   */
  @Test(expected = IllegalArgumentException.class)
  public void IllegalCell1() throws IllegalArgumentException {
    cp1.canMove(-1, -3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void IllegalCell2() throws IllegalArgumentException {
    cp1.canMove(8, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void IllegalCell3() throws IllegalArgumentException {
    cp1.canMove(0, -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void IllegalCell4() throws IllegalArgumentException {
    cp1.canMove(-1, 1);
  }

  /**
   * Test whether the Bishop piece can move diagonally.
   */
  @Test
  public void bishopCanMoveTest() {
    assertTrue(cp1.canMove(2, 4));
    assertTrue(cp1.canMove(1, 1));
    assertTrue(cp2.canMove(3, 4));
    assertTrue(cp2.canMove(6, 7));

    assertFalse(cp1.canMove(5, 5));
    assertFalse(cp1.canMove(2, 5));
    assertFalse(cp2.canMove(4, 6));
    assertFalse(cp2.canMove(7, 5));
  }

  /**
   * Test if illegalArgument will be thrown when the other chess piece is not on the board.
   *
   * @throws IllegalArgumentException when the given new chess piece is out of board range.
   */
  @Test
  public void chessPieceNotOnBoard() {
    try {
      cp1.canKill(new Rook(-1, 0, Color.BLACK));
      fail("An exception should be thrown here");
    } catch (IllegalArgumentException e) {
      System.out.println("The chess piece is not on the board");
    }

    try {
      cp1.canKill(new Bishop(5, 9, Color.BLACK));
      fail("An exception should be thrown here");
    } catch (IllegalArgumentException e) {
      System.out.println("The chess piece is not on the board");
    }

    try {
      cp1.canKill(new Knight(-1, 4, Color.BLACK));
      fail("An exception should be thrown here");
    } catch (IllegalArgumentException e) {
      System.out.println("The chess piece is not on the board");
    }

    try {
      cp1.canKill(new Queen(1, -4, Color.WHITE));
      fail("An exception should be thrown here");
    } catch (IllegalArgumentException e) {
      System.out.println("The chess piece is not on the board");
    }
  }

  /**
   * Test whether the canKill function operates properly when an opponent’s piece is on the diagonal
   * position.
   */
  @Test
  public void canKillTest() {
    assertTrue(cp1.canKill(new Bishop(2, 4, Color.BLACK)));
    assertTrue(cp1.canKill(new Queen(3, 5, Color.BLACK)));
    assertTrue(cp2.canKill(new Knight(4, 7, Color.WHITE)));
    assertTrue(cp2.canKill(new Rook(3, 4, Color.WHITE)));

    assertFalse(cp1.canKill(new Knight(2, 4, Color.WHITE)));
    assertFalse(cp1.canKill(new Queen(1, 2, Color.BLACK)));
    assertFalse(cp2.canKill(new Pawn(4, 7, Color.BLACK)));
    assertFalse(cp2.canKill(new Rook(5, 5, Color.WHITE)));
  }
}
