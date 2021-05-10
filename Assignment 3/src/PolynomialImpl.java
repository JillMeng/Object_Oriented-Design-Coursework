/**
 * The PolynomialImpl class implements the methods that are represented from Polynomial interface.
 */
public class PolynomialImpl implements Polynomial {

  private PolynomialList head;

  /**
   * Construct a Polynomial list with EmptyNode.
   */
  public PolynomialImpl() {
    head = new EmptyNode();
  }

  /**
   * Construct a Polynomial list by converting the given string to a list of terms.
   *
   * @param polynomial the string value of polynomial that needs to be converted.
   * @throws IllegalArgumentException when the string given is empty.
   */
  public PolynomialImpl(String polynomial) {
    if (polynomial.equals("")) {
      throw new IllegalArgumentException("The String is empty!");
    }
    this.head = new EmptyNode();

    String[] termList = polynomial.split(" ");
    for (String term : termList) {
      term = term.replace("x^", " ");
      String[] termComb = term.split(" ");
      int coefficient = Integer.parseInt(termComb[0]);

      int power;
      if (termComb.length > 1) {
        power = Integer.parseInt(termComb[1]);
      } else {
        power = 0;
      }
      this.head = head.addTerm(coefficient, power);
    }
  }

  @Override
  public void addTerm(int coefficient, int power) {
    if (power < 0) {
      throw new IllegalArgumentException("Negative power does not exist");
    }
    this.head = head.addTerm(coefficient, power);
  }


  @Override
  public void removeTerm(int power) {
    if (power < 0) {
      throw new IllegalArgumentException("Negative power does not exist");
    }
    this.head = head.remove(power);
  }

  @Override
  public int getDegree() {
    return this.head.getDegree();
  }

  @Override
  public int getCoefficient(int power) {
    if (power < 0) {
      throw new IllegalArgumentException("Negative power does not exist");
    }
    return head.getCoefficient(power);
  }


  @Override
  public double evaluate(double x) {
    return this.head.evaluate(x);
  }

  @Override
  public String toString() {
    String str = head.toString();
    if (str.startsWith("+")) {
      return str.substring(1,str.length()-1);
    }
    return str.substring(0,str.length()-1);
  }

  @Override
  public Polynomial add(Polynomial other) {
    if (!(other instanceof Polynomial)) {
      throw new IllegalArgumentException("The add part is not a Polynomial class");
    }
    String otherStr = other.toString();
    String thisStr = this.toString();

    String newPolyStr = otherStr + " " + thisStr;
    return new PolynomialImpl(newPolyStr);
  }
}
