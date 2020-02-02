package edu.ucsb.cs56.ratcalc.model;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Before;

public class RationalTest {

	private Rational r_5_15;
	private Rational r_24_6;
	private Rational r_3_7;  
	private Rational r_13_4;
	private Rational r_20_25;
	private Rational r_25_20;
	private Rational r_0_1; 

	@Before public void setUp() {
		r_5_15 = new Rational(5,15);
		r_24_6 = new Rational(24,6);
		r_3_7  = new Rational(3,7);
		r_13_4 = new Rational(13,4);
		r_20_25 = new Rational(20,25);
		r_0_1 = new Rational(0,1);
	}

	@Test(expected = IllegalArgumentException.class)
		public void test_denom_zero() {
			Rational r = new Rational(1,0);
		}

	@Test
		public void test_getNumerator_20_25() {
			assertEquals(4, r_20_25.getNumerator());
		}

	@Test
		public void test_getNumerator_13_4() {
			assertEquals(13, r_13_4.getNumerator());
		}

	@Test
		public void test_getDenominator_20_25() {
			assertEquals(5, r_20_25.getDenominator());
		}

	@Test
		public void test_getDenominator_13_4() {
			assertEquals(4, r_13_4.getDenominator());
		}

	@Test
		public void test_toString_5_15() {
			assertEquals("1/3",r_5_15.toString());
		}

	@Test
		public void test_toString_24_6() {
			assertEquals("4",r_24_6.toString());
		}

	@Test
		public void test_toString_3_7() {
			assertEquals("3/7",r_3_7.toString());
		}

	@Test
		public void test_toString_20_25() {
			assertEquals("4/5",r_20_25.toString());
		}

	@Test
		public void test_toString_0_1() {
			assertEquals("0",r_0_1.toString());
		}

	@Test
		public void test_gcd_5_15() {
			assertEquals(5, Rational.gcd(5,15));
		}

	@Test
		public void test_gcd_15_5() {
			assertEquals(5, Rational.gcd(15,5));
		}

	@Test
		public void test_gcd_24_6() {
			assertEquals(6, Rational.gcd(24,6));
		}

	@Test
		public void test_gcd_17_5() {
			assertEquals(1, Rational.gcd(17,5));
		}

	@Test
		public void test_gcd_1_1() {
			assertEquals(1, Rational.gcd(1,1));
		}

	@Test
		public void test_gcd_20_25() {
			assertEquals(5, Rational.gcd(20,25));
		}

	@Test
		public void test_rational_m10_m5() {
			Rational r = new Rational(-10,-5);
			assertEquals("2",r.toString());
		}

	@Test
		public void test_rational_m5_6() {
			Rational r = new Rational(-5,6);
			assertEquals("-5/6",r.toString());
		}

	@Test
		public void test_rational_7_m8() {
			Rational r = new Rational(7,-8);
			assertEquals("-7/8",r.toString());
		}

	@Test
		public void test_r_5_15_times_r_3_7() {
			Rational r = r_5_15.times(r_3_7);
			assertEquals("1/7",r.toString());
		}

	@Test
		public void test_r_3_7_times_r_13_4() {
			Rational r = r_3_7.times(r_13_4);
			assertEquals("39/28",r.toString());
		}

	@Test
		public void test_r_m3_1_times_1_m3() {
			Rational r_m3_1 = new Rational(-3,1);
			Rational r_1_m3 = new Rational(1,-3);
			Rational r = r_m3_1.times(r_1_m3);
			assertEquals("1",r.toString());
		}

	@Test
		public void test_product_of_r_5_15_and_r_3_7() {
			Rational r = Rational.product(r_5_15,r_3_7);
			assertEquals("1/7",r.toString());
		}

	@Test
		public void test_product_of_r_3_7_and_r_13_4() {
			Rational r = Rational.product(r_3_7,r_13_4);
			assertEquals("39/28",r.toString());
		}

	@Test
		public void test_product_of_r_m3_1_and_1_m3() {
			Rational r_m3_1 = new Rational(-3,1);
			Rational r_1_m3 = new Rational(1,-3);
			Rational r = Rational.product(r_m3_1,r_1_m3);
			assertEquals("1",r.toString());
		}

	@Test
		public void test_lcm_of_1_0() {
			assertEquals(0, Rational.lcm(0,1));
		}

	@Test
		public void test_lcm_of_m12_24(){
			assertEquals(-24, Rational.lcm(-12,24));
		}

	@Test
		public void test_lcm_of_23_m71(){
			assertEquals(1633, Rational.lcm(23,-71));
		}
	@Test
		public void test_plus_of_r_5_15_and_r_0_1() {
			Rational rc = r_5_15.plus(r_0_1);
			assertEquals("1/3", rc.toString());
		}
	@Test
		public void test_plus_of_r_m3_11_and_r_25_26() {
			Rational r1 = new Rational(-3, 11);
			Rational r2 = new Rational(25, 26);
			Rational rc = r1.plus(r2);
			assertEquals("197/286", rc.toString());
		}
	@Test
		public void test_plus_of_r_1_5_and_r_4_m5() {
			Rational r1 = new Rational(1,5);
			Rational r2 = new Rational(4,-5);
			Rational rc = r1.plus(r2);
			assertEquals("-3/5", rc.toString());
		}
	@Test
		public void test_sum_of_r_3_7_and_r_4_7(){
			Rational r1 = new Rational(3,7);
			Rational r2 = new Rational(4,7);
			Rational rc = Rational.sum(r1,r2);
			assertEquals("1", rc.toString());
		}
	@Test
		public void test_sum_of_r_2_3_and_r_0_1() {
			Rational r1 = new Rational(2,3);
			Rational r2 = new Rational(0,1);
			Rational rc = Rational.sum(r1,r2);
			assertEquals("2/3",rc.toString());
		}
	@Test
		public void test_sum_of_r_m4_7_and_r_2_3() {
			Rational r1 = new Rational(-4,7);
			Rational r2 = new Rational(2,3);
			Rational rc = Rational.sum(r1, r2);
			assertEquals("2/21", rc.toString());
		}
	@Test
		public void test_minus_of_r_1_2_and_r_0_1() {
			Rational r1 = new Rational(1,2);
			Rational r2 = new Rational(0,1);
			Rational rc = r1.minus(r2);
			assertEquals("1/2", rc.toString());
		}
	@Test
		public void test_minus_of_r_28_3_and_r_7_11() {
			Rational r1 = new Rational(28,3);
			Rational r2 = new Rational(7,11);
			Rational rc = r1.minus(r2);
			assertEquals("281/33", rc.toString());
		}
	@Test
		public void test_minus_of_r_m4_9_and_r_m4_9() {
			Rational r1 = new Rational(-4,9);
			Rational r2 = new Rational(-4,9);
			Rational rc = r1.minus(r2);
			assertEquals("0", rc.toString());
		}

	@Test
		public void test_difference_of_r_2_3_and_r_1_2() {
			Rational r_2_3 = new Rational(2,3);
			Rational r_1_2 = new Rational(1,2);
			Rational r = Rational.difference(r_2_3, r_1_2);
			assertEquals("1/6", r.toString());
		}

	@Test
		public void test_difference_of_r_m2_3_and_r_1_2() {
			Rational r_m2_3 = new Rational(-2,3);
			Rational r_1_2 = new Rational(1,2);
			Rational r = Rational.difference(r_m2_3, r_1_2);
			assertEquals("-7/6", r.toString());
		}

	@Test
		public void test_difference_of_r_0_3_and_r_2_7() {
			Rational r_0_3 = new Rational(0,3);
			Rational r_2_7 = new Rational(2,7);
			Rational r = Rational.difference(r_0_3, r_2_7);
			assertEquals("-2/7", r.toString());
		}

	@Test (expected = ArithmeticException.class)
		public void test_reciprocal_of_r_0_3() {
			Rational r_0_3 = new Rational(0,3);
			r_0_3.reciprocalOf();
		}

	@Test
		public void test_reciprocal_of_r_m2_5 (){
			Rational r_m2_5 = new Rational(-2,5);
			Rational r = r_m2_5.reciprocalOf();
			assertEquals("-5/2", r.toString());
		}

	@Test
		public void test_reciprocal_of_r_7_2() {
			Rational r_7_2 = new Rational(7,2);
			Rational r = r_7_2.reciprocalOf();
			assertEquals("2/7", r.toString());
		}

	@Test
		public void test_r_1_3_divided_by_r_m1_6() {
			Rational r_1_3 = new Rational(1,3);
			Rational r_m1_6 = new Rational(-1,6);
			Rational r = r_1_3.dividedBy(r_m1_6);
			assertEquals("-2", r.toString());
		}

	@Test
		public void test_quotient_of_r_1_3_and_r_m1_6() {
			Rational r_1_3 = new Rational(1,3);
			Rational r_m1_6 = new Rational(-1,6);
			Rational r = Rational.quotient(r_1_3,r_m1_6);
			assertEquals("-2", r.toString());
		}

	@Test (expected = ArithmeticException.class)
		public void test_quotient_of_r_1_3_and_r_0_6() {
			Rational r_1_3 = new Rational(1,3);
			Rational r_0_6 = new Rational(0,6);
			Rational r = Rational.quotient(r_1_3,r_0_6);
		}

	@Test
		public void test_quotient_of_r_2_3_and_r_1_2() {
			Rational r_2_3 = new Rational(2,3);
			Rational r_1_2 = new Rational(1,2);
			Rational r = Rational.quotient(r_2_3,r_1_2);
			assertEquals("4/3", r.toString());
		}

}
