import org.junit.Test;

import cs5004.marblesolitaire.model.MarbleSolitaireModel;
import cs5004.marblesolitaire.model.MarbleSolitaireModelImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * A Junit test that test all the public methods listed in the MarbleSolitaireModel interface.
 */
public class MarbleSolitaireModelImplTest {

  private MarbleSolitaireModel model;

  @Test
  public void constructor1Test() {
    model = new MarbleSolitaireModelImpl();
    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O", model.getGameState());
  }

  @Test
  public void constructor2Test() {
    model = new MarbleSolitaireModelImpl(2, 2);
    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O _ O O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O", model.getGameState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void constructor2InvalidRow() {
    model = new MarbleSolitaireModelImpl(-1, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void constructor2InvalidCol() {
    model = new MarbleSolitaireModelImpl(4, -3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void constructorBothInvalid() {
    model = new MarbleSolitaireModelImpl(-3, -3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void constructor2TopLeft() {
    model = new MarbleSolitaireModelImpl(0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void constructor2TopRight() {
    model = new MarbleSolitaireModelImpl(0, 6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void constructor2BottomLeft() {
    model = new MarbleSolitaireModelImpl(6, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void constructor2BottomRight() {
    model = new MarbleSolitaireModelImpl(6, 6);
  }

  @Test
  public void constructor3Test() {
    model = new MarbleSolitaireModelImpl(5);
    assertEquals("        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O _ O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O", model.getGameState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void constructor3WithEvenArmThickness() {
    model = new MarbleSolitaireModelImpl(4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void constructor3WithNegativeArmThickness() {
    model = new MarbleSolitaireModelImpl(-1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void constructor3WithTooSmallArmThickness() {
    model = new MarbleSolitaireModelImpl(1);
  }

  @Test
  public void constructor4Test() {
    model = new MarbleSolitaireModelImpl(3, 4, 5);
    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O O O _ O\n"
            + "    O O O\n"
            + "    O O O", model.getGameState());

  }

  @Test(expected = IllegalArgumentException.class)
  public void constructor4InvalidRow() {
    model = new MarbleSolitaireModelImpl(3, -1, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void constructor4InvalidRow2() {
    model = new MarbleSolitaireModelImpl(3, 10, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void constructor4InvalidCol() {
    model = new MarbleSolitaireModelImpl(3, 1, -2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void constructor4InvalidCol2() {
    model = new MarbleSolitaireModelImpl(3, 1, 8);
  }

  @Test(expected = IllegalArgumentException.class)
  public void constructor4InvalidCenter() {
    model = new MarbleSolitaireModelImpl(3, -1, -8);
  }

  @Test(expected = IllegalArgumentException.class)
  public void constructor4InvalidCenter2() {
    model = new MarbleSolitaireModelImpl(3, 10, 15);
  }

  @Test(expected = IllegalArgumentException.class)
  public void constructor4CenterInSpace() {
    model = new MarbleSolitaireModelImpl(5, 0, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void constructorArmThicknessInvalid() {
    model = new MarbleSolitaireModelImpl(-4, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void constructorArmThicknessInvalid1() {
    model = new MarbleSolitaireModelImpl(1, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void constructorArmThicknessInvalid2() {
    model = new MarbleSolitaireModelImpl(4, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void constructor4AllThreeInvalid() {
    model = new MarbleSolitaireModelImpl(4, 0, 0);
  }

  @Test
  public void moveTest() {
    model = new MarbleSolitaireModelImpl();
    model.move(1, 3, 3, 3);
    assertEquals("    O O O\n"
            + "    O _ O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O", model.getGameState());
    model = new MarbleSolitaireModelImpl(2, 2);
    model.move(2, 4, 2, 2);
    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O _ _ O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O", model.getGameState());
    model = new MarbleSolitaireModelImpl(5);
    model.move(6, 4, 6, 6);
    assertEquals("        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O _ _ O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O", model.getGameState());
    model = new MarbleSolitaireModelImpl(3, 3, 2);
    model.move(1, 2, 3, 2);
    assertEquals("    O O O\n"
            + "    _ O O\n"
            + "O O _ O O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O", model.getGameState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void moveTooFar() {
    model = new MarbleSolitaireModelImpl(5);
    model.move(6, 4, 6, 6);
    model.move(6, 3, 6, 6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void moveToNoneEmptySlot() {
    model = new MarbleSolitaireModelImpl();
    model.move(5, 3, 3, 3);
    model.move(1, 3, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void moveWithEmptyMiddleSlot() {
    model = new MarbleSolitaireModelImpl(3, 1, 2);
    model.move(3, 2, 1, 2);
    model.move(1, 2, 3, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void moveFromEmptySlot() {
    model = new MarbleSolitaireModelImpl(3, 1, 2);
    model.move(1, 2, 3, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void moveDiagonal() {
    model = new MarbleSolitaireModelImpl(3, 1);
    model.move(5, 3, 3, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void moveOutOfBound() {
    model = new MarbleSolitaireModelImpl(2, 1);
    model.move(3, 1, 1, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidNegativeCells() {
    model = new MarbleSolitaireModelImpl(3);
    model.move(-5, -5, -3, -3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidOutboundCells() {
    model = new MarbleSolitaireModelImpl(5);
    model.move(0, 0, 0, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidFromCell() {
    model = new MarbleSolitaireModelImpl();
    model.move(5, 3, 3, 3);
    model.move(5, 1, 5, 3);
  }

  @Test
  public void isGameOverTest() {
    model = new MarbleSolitaireModelImpl();
    model.move(5, 3, 3, 3);
    model.move(2, 3, 4, 3);
    model.move(3, 1, 3, 3);
    model.move(0, 3, 2, 3);
    assertFalse(model.isGameOver());
    model.move(3, 4, 3, 2);
    model.move(3, 6, 3, 4);
    assertTrue(model.isGameOver());
  }

  @Test
  public void getGameStateTest() {
    model = new MarbleSolitaireModelImpl(3, 4, 5);
    model.move(4,3,4,5);
    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ _ O O\n"
            + "    O O O\n"
            + "    O O O", model.getGameState());

  }

  @Test
  public void getScoreTest() {
    model = new MarbleSolitaireModelImpl();
    assertEquals(32,model.getScore());
    model.move(5, 3, 3, 3);
    assertEquals(31,model.getScore());
    model.move(4, 1, 4, 3);
    model.move(4, 4, 4, 2);
    model.move(6, 4, 4, 4);
    assertEquals(28,model.getScore());
  }

}

