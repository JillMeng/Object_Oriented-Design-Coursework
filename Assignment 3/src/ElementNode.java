/**
 * A class that represents the ElementNode of the PolynomialList; it contains all the method that
 * are listed in PolynomialList interface.
 */
class ElementNode implements PolynomialList {

  private int coefficient;
  private int power;
  private PolynomialList rest;

  /**
   * Construct an element node with a term and the rest of the list.
   * @param coefficient takes in a int value to form the current coefficient.
   * @param power takes in a int value to form the current power.
   * @param rest rest the rest of the list.
   * @throws IllegalArgumentException when the power is negative.
   * @throws IllegalArgumentException when the rest of the list is null.
   */
  public ElementNode(int coefficient, int power, PolynomialList rest) {
    if (power < 0) {
      throw new IllegalArgumentException("Power cannot be negative");
    }
    if (rest == null) {
      throw new IllegalArgumentException("The rest of the list cannot be null");
    }
    this.coefficient = coefficient;
    this.power = power;
    this.rest = rest;
  }

  @Override
  public PolynomialList addTerm(int coefficient, int power) {
    if (power < 0) {
      throw new IllegalArgumentException("Power cannot be negative");
    }

    if (power == this.power) {
      int newCoe = coefficient + this.coefficient;
      if (newCoe == 0) {
        return this.rest;
      } else {
        return new ElementNode(newCoe, power, rest);
      }

    } else if (power > this.power) {
      return new ElementNode(coefficient, power, this);
    }
    return new ElementNode(this.coefficient, this.power, rest.addTerm(coefficient, power));
  }

  @Override
  public PolynomialList remove(int power) {
    if (power < 0) {
      throw new IllegalArgumentException("Negative power does not exist.");
    }
    if (power == this.power) {
      return rest;
    }
    return new ElementNode(this.coefficient, this.power, rest.remove(power));
  }

  @Override
  public int getDegree() {
    if (this.power > this.rest.getDegree()) {
      return this.power;
    }
    return rest.getDegree();
  }

  @Override
  public int getCoefficient(int power) {
    if (power < 0) {
      throw new IllegalArgumentException("Negative power does not exist.");
    }
    if (power == this.power) {
      return this.coefficient;
    } else {
      return rest.getCoefficient(power);
    }
  }

  @Override
  public double evaluate(double x) {
    double result = 1;
    for (int i = 0; i < this.power; i++) {
      result = result * x;
    }
    return this.coefficient * result + rest.evaluate(x);
  }

  @Override
  public String toString() {
    String str;
    if (this.power == 0) {
      str = "" + this.coefficient + " ";
    } else {
      str = "" + this.coefficient + "x^" + this.power + " ";
    }

    if (this.coefficient < 0) {
      str = str + rest.toString();
    } else {
      str = "+" + str + rest.toString();
    }
    return str;
  }

}