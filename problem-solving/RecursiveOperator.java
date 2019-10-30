/*
    Given two functions: succesor(x) that return the succesor of x [succesor(1) = 2]
    and predecesor(x) that returns the predecesor of x [predecesor(1) = -1]
    write a class that implements all other operations.
    
    Constraints: 
    * Only the given methods and any other created from them can be utilized
    * No built-in arithmetic operator can be used except from
    * Only use recursion. No new variable should be created
    
    Asumptions:
    * Only natural numbers are considered
    * Only integer division is supported
 */
 
public class RecursiveOperator {
    public static final byte ZERO = 0;
    public static final byte ONE = 1;
    public static final byte TWO = 2;
    private static int count = 0;
    
    public static int succesor(int x) {
        return (-(~x));
    }
    
    public static int predecesor(int x) {
        return ((x << ONE) + (~x));
    }
    
    /* start code here */
    
    public static int add(int x, int y) {
        if (x == ZERO) return y;
        return add(predecesor(x), succesor(y));
    }
    
    public static int subtract(int x, int y) {
        if (y == ZERO) return x;
        return subtract(predecesor(x), predecesor(y));
    }
    
    public static int multiply(int x, int y) {
        if (x == ZERO) return ZERO;
        return add(x, multiply(predecesor(y), x));
    }
    // TODO: implement division
    public static int divide(int x, int y) {
    //    count++;
    //    System.out.println(count);
        if (x == ZERO) return ZERO;
        if (y == ZERO) throw new ArithmeticException("Division by zero");
        return subtract(x, divide(predecesor(x), succesor(y)));
    //    return x / y;
    }
    
	// TODO: implement mod
    public static int mod(int x, int y) {
        return x % y;
    }
    
    public static int power(int x, int y) {
        if (x == ZERO) {
            return ZERO;
        } else if (y == ZERO) {
          return ONE;
        } else if (y == ONE) {
            return x;
        } else if (mod(y, TWO) == ZERO) {
            return multiply(multiply(x,x), divide(y, TWO));
        } else {
            return multiply(x, multiply(multiply(x,x), divide(y, TWO)));
        }
    }
}