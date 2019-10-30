/*
    Given two functions: succ(x) that return the succ of x [succ(1) = 2]
    and pred(x) that returns the pred of x [pred(1) = -1]
    write a class that implements all other operations.
    
    Constraints: 
    * Only the given methods and any other created from them can be utilized
    * No built-in arithmetic operator can be used except from
    * Only use recursion. No new variable should be created
    
    Asumptions:
    * Only natural numbers are considered
    * Only integer division is supported
 */
 
public class Arithmetic {
    public static final byte ZERO = 0;
    public static final byte ONE = 1;
    public static final byte TWO = 2;
    private static int steps = 0;
    
    public static int succ(int x) {
        return (-(~x));
    }
    
    public static int pred(int x) {
        return ((x << ONE) + (~x));
    }
    
    /* start code here */
    
    public static int add(int x, int y) {
        if (x == ZERO) return y;
        return add(pred(x), succ(y));
    }
    
    public static int sub(int x, int y) {
        if (y == ZERO) return x;
        return sub(pred(x), pred(y));
    }
    
	// X * Y = X + (Y - 1) * X
    public static int mul(int x, int y) {
        if (x == ZERO) return ZERO;
        return add(x, mul(pred(y), x));
    }
	
	// X / Y = (X - Y) / Y + 1
    public static int div(int x, int y) {
        if (x < y) return ZERO;
        if (y == ZERO) throw new ArithmeticException("Division by 0");
        return add(div(sub(x, y), y), ONE);
    }
    
	// X % Y = X - (X / Y) * Y
    public static int mod(int x, int y) {
        return sub(x, mul(div(x, y), y));
    }
	
	// if Y is even: X^Y = X^(Y/2) * X^(Y/2)
	// if Y is odd : X^Y = X^(Y/2) * X^(Y/2) * X
    public static int exp(int x, int y) {
        if (x == ZERO) {
            return ZERO;
        } else if (y == ZERO) {
          return ONE;
        } else if (y == ONE) {
            return x;
        } else if (mod(y, TWO) == ZERO) {
            return mul(mul(x,x), div(y, TWO));
        } else {
            return mul(x, mul(mul(x,x), div(y, TWO)));
        }
    }
	
	// X! = X * (X-1) * (X-2) * ... * 2 * 1
	public static int fact(int x) {
		if (x == 0) return ONE;
		return mul(x, fact(pred(x)));
	}
}