import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * This class contains all the unit test for methods listed in ChessPiece that live in the
 * Knight class and also extended from AbstractChessPiece class.
 */
public class KnightTest {

  private Knight cp1;
  private Knight cp2;


  @Before
  public void setUp() {
    cp1 = new Knight(0,1,Color.WHITE);
    cp2 = new Knight(4,3,Color.BLACK);
  }

  /**
   * Test whether the Knight piece can move as L pattern.
   */
  @Test
  public void canMoveTest() {
    assertTrue(cp1.canMove(2,2));
    assertTrue(cp1.canMove(1,3));
    assertTrue(cp2.canMove(5,5));
    assertTrue(cp2.canMove(2,2));

    assertFalse(cp1.canMove(2,3));
    assertFalse(cp1.canMove(2,5));
    assertFalse(cp2.canMove(3,4));
    assertFalse(cp2.canMove(2,1));
  }

  /**
   * Test whether the canKill function operates properly when an opponent’s piece is on the L shape
   * position.
   */
  @Test
  public void canKillTest() {
    assertTrue(cp1.canKill(new Bishop(1,3,Color.BLACK)));
    assertTrue(cp1.canKill(new Queen(2,0,Color.BLACK)));
    assertTrue(cp2.canKill(new Knight(3,1,Color.WHITE)));
    assertTrue(cp2.canKill(new Rook(6,2,Color.WHITE)));

    assertFalse(cp1.canKill(new Knight(1,3,Color.WHITE)));
    assertFalse(cp1.canKill(new Queen(1,2,Color.BLACK)));
    assertFalse(cp2.canKill(new Pawn(3,1,Color.BLACK)));
    assertFalse(cp2.canKill(new Rook(5,6,Color.WHITE)));
  }

}