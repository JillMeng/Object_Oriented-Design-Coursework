import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * This class contains all the unit test for methods listed in ChessPiece that live in the Pawn
 * class and also extended from AbstractChessPiece class.
 */
public class PawnTest {

  private Pawn cp1;
  private Pawn cp2;


  @Before
  public void setUp() {
    cp1 = new Pawn(1, 3, Color.WHITE);
    cp2 = new Pawn(5, 5, Color.BLACK);
  }

  /**
   * Test whether the Pawn piece can only move one place forward.
   */
  @Test
  public void canMoveTest() {
    assertTrue(cp1.canMove(2, 3));
    assertTrue(cp2.canMove(4, 5));

    assertFalse(cp1.canMove(1, 4));
    assertFalse(cp1.canMove(0, 3));
    assertFalse(cp2.canMove(3, 5));
    assertFalse(cp2.canMove(6, 5));
  }

  /**
   * Test whether the canKill function operates properly when the Pawn move forward diagonally and
   * kill an opponent’s piece.
   */
  @Test
  public void canKillTest() {
    assertTrue(cp1.canKill(new Bishop(2, 4, Color.BLACK)));
    assertTrue(cp1.canKill(new Queen(2, 2, Color.BLACK)));
    assertTrue(cp2.canKill(new Knight(4, 4, Color.WHITE)));
    assertTrue(cp2.canKill(new Rook(4, 6, Color.WHITE)));

    assertFalse(cp1.canKill(new Knight(2, 4, Color.WHITE)));
    assertFalse(cp1.canKill(new Queen(0, 1, Color.BLACK)));
    assertFalse(cp2.canKill(new Bishop(4, 4, Color.BLACK)));
    assertFalse(cp2.canKill(new Rook(3, 6, Color.WHITE)));
  }

}