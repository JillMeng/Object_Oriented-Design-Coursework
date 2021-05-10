import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This is a test for the method that are listed in the Polynomial interface.
 */
public class PolynomialTest {

  private Polynomial terms;

  @Before
  public void setUp() {
    terms = new PolynomialImpl();
    terms.addTerm(4, 3);
    terms.addTerm(3, 1);
    terms.addTerm(-5, 0);
  }

  /**
   * Test the if the second constructor can turn the method to a polynomial list.
   */
  @Test
  public void PolynomialImplConstructorTest() {
    assertEquals(3, new PolynomialImpl("4x^3 +3x^1 -5").getDegree());
    assertEquals("-5x^3 +3x^1 -5", new PolynomialImpl("-5x^3 +3x^1 -5").toString());
    assertEquals("3x^3", new PolynomialImpl("3x^3").toString());
    assertEquals("-2x^3 +4x^2", new PolynomialImpl("-2x^3 +4x^2").toString());
  }

  /**
   * Test when pass on the empty string to the string constructor.
   *
   * @throws IllegalArgumentException when an empty string is passed onto the constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalPolynomialImplConstructorTest() throws IllegalArgumentException {
    new PolynomialImpl("");
  }


  /**
   * test if it can add terms properly and whether the same power of terms can be added up.
   */
  @Test
  public void addTermTest() {
    terms.addTerm(-6, 3);
    assertEquals("-2x^3 +3x^1 -5", terms.toString());
    terms.addTerm(3, 1);
    assertEquals("-2x^3 +6x^1 -5", terms.toString());
  }

  /**
   * Throw exceptions when the power is negative value.
   *
   * @throws IllegalArgumentException when the power we took is a negative value.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalAddTermTest() throws IllegalArgumentException {
    terms.addTerm(3, -1);
  }

  /**
   * Test if the removeTerm method works properly.
   */
  @Test
  public void removeTest() {
    terms.removeTerm(3);
    assertEquals("3x^1 -5", terms.toString());
  }

  /**
   * Test if the getDegree method works properly.
   */
  @Test
  public void getDegreeTest() {
    assertEquals(3, terms.getDegree());
  }

  /**
   * Test if the the user can get the corresponding coefficient with the given power.
   */
  @Test
  public void getCoefficientTest() {
    assertEquals(3, terms.getCoefficient(1));
    assertEquals(-5, terms.getCoefficient(0));
  }

  /**
   * Test if the polynomial calculates correctly with a given double value for the term.
   */
  @Test
  public void evaluateTest() {
    assertEquals(2, terms.evaluate(1), 0.01);
    assertEquals(33, terms.evaluate(2), 0.01);
  }

  /**
   * Test is the user can turn the polynomial to a formated string with space in between.
   */
  @Test
  public void toStringTest() {
    assertEquals("4x^3 +3x^1 -5", terms.toString());
  }

  /**
   * Test whether the add method can take in a polynomial and add to the current polynomial
   * properly.
   */
  @Test
  public void addTest() {

    Polynomial otherTerms;
    otherTerms = new PolynomialImpl();
    otherTerms.addTerm(-4, 3);
    otherTerms.addTerm(-3, 1);
    otherTerms.addTerm(4, 0);
    assertEquals("-1", terms.add(otherTerms).toString());

    assertEquals("8x^3 +6x^1 -10", terms.add(terms).toString());
  }

  /**
   * Throw exceptions when the add method is not add in a Polynomial object.
   *
   * @throws IllegalArgumentException when invalid type is passed on.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalAddTest() throws IllegalArgumentException {
    terms.add(null);
  }
}