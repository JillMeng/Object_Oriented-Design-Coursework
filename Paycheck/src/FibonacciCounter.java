/**
 * The class FibonacciCounter represents a single Fibonacci counter and calculate the Fibonacci
 * value of the corresponding counter. It also includes methods to increment and decrement the
 * Fibonacci counter.
 */
public class FibonacciCounter {

  private int count;
  private double fibValue;

  /**
   * Construct a FibonacciCounter with a count value, and initialize the Fib value of the 'nth'
   * Fibonacci number using Binet’s formula.
   *
   * @param count an int number which correspond to the 'nth' Fibonacci number.
   * @throws IllegalArgumentException if the count number is less than 0
   */
  public FibonacciCounter(int count) {
    if (count < 0) {
      throw new IllegalArgumentException("Count number cannot be less than 0.");
    }
    this.count = count;

    /*Calculate the value of the Fibonacci value for the nth number*/
    this.fibValue = (1 / Math.sqrt(5)) * (Math.pow(((1 + Math.sqrt(5)) / 2), this.count)
            - Math.pow(((1 - Math.sqrt(5)) / 2), this.count));
  }

  /**
   * Increment a FibonacciCounter object by 1.
   *
   * @return returns a FibonacciCounter object with its count incremented by 1.
   */
  public FibonacciCounter increment() {
    FibonacciCounter incrementFib = new FibonacciCounter(count + 1);
    return incrementFib;
  }

  /**
   * Decrease a FibonacciCounter object by 1. If it cannot be decremented (count is less than 0), it
   * will return the object with the same count.
   *
   * @return returns a FibonacciCounter object with its count decremented by 1, or return a
   * FibonacciCounter object with the same count when the count cannot be decremented.
   */
  public FibonacciCounter decrement() {
    FibonacciCounter decrementFib;
    if (count - 1 > 0) {
      decrementFib = new FibonacciCounter(count - 1);
    } else {
      decrementFib = new FibonacciCounter(count);
    }
    return decrementFib;
  }

  /**
   * Get the current count of the counter.
   *
   * @return the current int value of counter
   */
  public int getCount() {

    return this.count;
  }

  /**
   * A method that gets the Fibonacci number corresponding to the current count.
   *
   * @return the Fibonacci number corresponding to the current count value.
   */
  public double getFibValue() {

    return this.fibValue;
  }

}
