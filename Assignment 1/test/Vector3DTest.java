import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * A Junit test for all the methods that are listed in Vector3D class.
 */
public class Vector3DTest {

  private Vector3D vectorO;
  private Vector3D vectorA;
  private Vector3D vectorB;
  private Vector3D vectorC;
  private Vector3D vectorD;


  @Before
  public void setUp() {
    vectorO = new Vector3D(0.00, 0.00, 0.00);
    vectorA = new Vector3D(3.00, 4.00, 5.00);
    vectorB = new Vector3D(3.00, 4.00, 0.00);
    vectorC = new Vector3D(3.00, 4.00, -5.00);
    vectorD = new Vector3D(-2.50, -2.50, -2.50);
  }

  @Test
  public void constructorTest() {
    assertEquals(0.00, vectorO.getX(), 0.01);
    assertEquals(0.00, vectorO.getY(), 0.01);
    assertEquals(0.00, vectorO.getZ(), 0.01);

    assertEquals(3.00, vectorA.getX(), 0.01);
    assertEquals(4.00, vectorA.getY(), 0.01);
    assertEquals(5.00, vectorA.getZ(), 0.01);

    assertEquals(-2.50, vectorD.getX(), 0.01);
    assertEquals(-2.50, vectorD.getY(), 0.01);
    assertEquals(-2.50, vectorD.getZ(), 0.01);
  }

  @Test
  public void toStringTest() {
    assertEquals("(0.00,0.00,0.00)", vectorO.toString());
    assertEquals("(3.00,4.00,5.00)", vectorA.toString());
    assertEquals("(3.00,4.00,0.00)", vectorB.toString());
    assertEquals("(3.00,4.00,-5.00)", vectorC.toString());
    assertEquals("(-2.50,-2.50,-2.50)", vectorD.toString());
  }

  @Test
  public void getMagnitudeTest() {
    assertEquals(0.00, vectorO.getMagnitude(), 0.01);
    assertEquals(7.07, vectorA.getMagnitude(), 0.01);
    assertEquals(5.00, vectorB.getMagnitude(), 0.01);
    assertEquals(4.33, vectorD.getMagnitude(), 0.01);
  }

  @Test
  public void normalizeTest() {
    assertEquals("(0.60,0.80,0.00)", vectorB.normalize().toString());
    assertEquals("(0.42,0.57,-0.71)", vectorC.normalize().toString());
    assertEquals("(-0.58,-0.58,-0.58)", vectorD.normalize().toString());
  }

  @Test(expected = IllegalStateException.class)
  public void illegalNormalizeTest() throws IllegalStateException {
    vectorO.normalize();
  }


  @Test
  public void addTest() {
    assertEquals("(6.00,8.00,5.00)", vectorA.add(vectorB).toString());
    assertEquals("(0.50,1.50,-7.50)", vectorC.add(vectorD).toString());
    assertEquals("(6.00,8.00,0.00)", vectorA.add(vectorC).toString());
  }

  @Test
  public void multiply() {
    assertEquals("(0.00,0.00,0.00)", vectorO.multiply(1.5).toString());
    assertEquals("(6.00,8.00,10.00)", vectorA.multiply(2.0).toString());
    assertEquals("(3.75,3.75,3.75)", vectorD.multiply(-1.5).toString());
  }

  @Test
  public void dotProductTest() {
    assertEquals(0.00, vectorO.dotProduct(vectorA), 0.01);
    assertEquals(25.00, vectorB.dotProduct(vectorC), 0.01);
    assertEquals(0, vectorA.dotProduct(vectorC), 0.01);
  }

  @Test
  public void angleBetweenTest() {
    assertEquals(45, vectorA.angleBetween(vectorB), 0.01);
    assertEquals(90, vectorA.angleBetween(vectorC), 0.01);
  }

  @Test(expected = IllegalStateException.class)
  public void illegalAngleBetween() throws IllegalStateException {
    vectorA.angleBetween(vectorO);
    vectorO.angleBetween(vectorB);
  }
}
