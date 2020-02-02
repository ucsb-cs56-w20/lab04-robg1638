package edu.ucsb.cs56.ratcalc.model;
/** A class to represent a rational number
  with a numerator and denominator

  @author P. Conrad for CS56 F16

*/

public class Rational {

	private int num;
	private int denom;

	/** 
	  greatest common divisor of a and b
	  @param a first number
	  @param b second number
	  @return gcd of a and b
	  */
	public static int gcd(int a, int b) {
		if (a==0)
			return b;
		else if (b==0)
			return a;
		else
			return gcd(b%a, a);
	}

	public Rational() {
		this.num = 1;
		this.denom = 1;
	}

	public Rational(int num, int denom) {
		if (denom== 0) {
			throw new IllegalArgumentException("denominator may not be zero");
		}
		this.num = num;
		this.denom = denom;
		if (num != 0) {
			int gcd = Rational.gcd(num,denom);
			this.num /= gcd;
			this.denom /= gcd;
		}
		if(this.denom < 0){
			this.num *= -1;
			this.denom *= -1;
		}
	}

	public String toString() {
		if (denom == 1 || num == 0)
			return "" + num;
		return num + "/" + denom;
	}

	public int getNumerator() { return this.num; }
	public int getDenominator() { return this.denom; }

	public Rational times(Rational r) {
		return new Rational(this.num * r.num,
				this.denom * r.denom);
	}

	public static Rational product(Rational a, Rational b) {
		return new Rational(a.num * b.num,
				a.denom * b.denom);
	}


	/** 
	  For testing getters.  
	  @param args unused
	  */

	public static void main (String [] args) {
		Rational r = new Rational(5,7);
		System.out.println("r.getNumerator()=" + r.getNumerator());
		System.out.println("r.getDenominator()=" + r.getDenominator());
	}

	public static int lcm(int a, int b){

		return (Math.abs(a*b)/gcd(a,b));
	}

	public Rational plus(Rational r){
		int lcmDenom = lcm(this.denom, r.denom);

		int newNum = this.num * lcmDenom / this.denom;
		int rNum = r.num * lcmDenom / r.denom;
		//	else if(this.denom > 0 && r.denom < 0){
		//  	rNum *= -1;
		//}
		newNum = newNum + rNum;
		return new Rational(newNum, lcmDenom);
	}

	public static Rational sum(Rational a, Rational b){

		return a.plus(b);
	}

	public Rational minus(Rational r){

		return this.plus(new Rational(-1 * r.num, r.denom));
	}

	public static Rational difference(Rational a, Rational b){

		return a.minus(b);
	}

	public Rational reciprocalOf(){
		if(this.num == 0){
			throw new java.lang.ArithmeticException();
		}
		return new Rational(denom, num);
	}

	public Rational dividedBy(Rational r){

		return this.times(r.reciprocalOf());
	}

	public static Rational quotient(Rational a, Rational b){

		return a.dividedBy(b);
	}

}
