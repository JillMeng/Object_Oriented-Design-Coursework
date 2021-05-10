import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * This class contains all the unit test for methods listed in ChessPiece that live in the Queen
 * class and also extended from AbstractChessPiece class.
 */
public class QueenTest {

  private Queen cp1;
  private Queen cp2;


  @Before
  public void setUp() {
    cp1 = new Queen(1, 3, Color.WHITE);
    cp2 = new Queen(5, 5, Color.BLACK);
  }

  /**
   * Test whether the Queen piece can move horizontally, vertically and diagonally.
   */
  @Test
  public void canMoveTest() {
    assertTrue(cp1.canMove(5, 3));
    assertTrue(cp1.canMove(1, 5));
    assertTrue(cp2.canMove(4, 6));
    assertTrue(cp2.canMove(6, 5));

    assertFalse(cp1.canMove(0, 5));
    assertFalse(cp1.canMove(3, 4));
    assertFalse(cp2.canMove(2, 6));
    assertFalse(cp2.canMove(7, 4));
  }

  /**
   * Test whether the canKill function operates properly when the Queen move horizontally,
   * vertically and diagonally, and then kill an opponent’s piece.
   */
  @Test
  public void canKillTest() {
    assertTrue(cp1.canKill(new Bishop(3, 5, Color.BLACK)));
    assertTrue(cp1.canKill(new Queen(1, 0, Color.BLACK)));
    assertTrue(cp2.canKill(new Knight(1, 5, Color.WHITE)));
    assertTrue(cp2.canKill(new Rook(2, 2, Color.WHITE)));

    assertFalse(cp1.canKill(new Knight(3, 3, Color.WHITE)));
    assertFalse(cp1.canKill(new Queen(0, 1, Color.BLACK)));
    assertFalse(cp2.canKill(new Pawn(2, 5, Color.BLACK)));
    assertFalse(cp2.canKill(new Rook(3, 6, Color.WHITE)));
  }

}