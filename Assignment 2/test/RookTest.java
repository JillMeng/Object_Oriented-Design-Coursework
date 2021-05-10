import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * This class contains all the unit test for methods listed in ChessPiece that live in the Rook
 * class and also extended from AbstractChessPiece class.
 */
public class RookTest {

  private Rook cp1;
  private Rook cp2;


  @Before
  public void setUp() {
    cp1 = new Rook(1, 3, Color.WHITE);
    cp2 = new Rook(5, 5, Color.BLACK);
  }

  /**
   * Test whether the Rook piece can move horizontally and vertically.
   */
  @Test
  public void canMoveTest() {
    assertTrue(cp1.canMove(1, 6));
    assertTrue(cp1.canMove(3, 3));
    assertTrue(cp2.canMove(6, 5));
    assertTrue(cp2.canMove(5, 2));

    assertFalse(cp1.canMove(2, 4));
    assertFalse(cp1.canMove(3, 2));
    assertFalse(cp2.canMove(6, 4));
    assertFalse(cp2.canMove(3, 6));
  }

  /**
   * Test whether the canKill function operates properly when the Rook move horizontally and
   * vertically, and then kill an opponent’s piece.
   */
  @Test
  public void canKillTest() {
    assertTrue(cp1.canKill(new Bishop(1, 4, Color.BLACK)));
    assertTrue(cp1.canKill(new Queen(2, 3, Color.BLACK)));
    assertTrue(cp2.canKill(new Knight(1, 5, Color.WHITE)));
    assertTrue(cp2.canKill(new Pawn(5, 7, Color.WHITE)));

    assertFalse(cp1.canKill(new Knight(1, 4, Color.WHITE)));
    assertFalse(cp1.canKill(new Queen(0, 1, Color.BLACK)));
    assertFalse(cp2.canKill(new Bishop(1, 5, Color.BLACK)));
    assertFalse(cp2.canKill(new Rook(3, 6, Color.WHITE)));
  }

}