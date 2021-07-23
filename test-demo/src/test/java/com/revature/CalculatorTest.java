package com.revature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.revature.CalculatorException;

@TestMethodOrder(OrderAnnotation.class)
public class CalculatorTest {

	/*
	 * JUnit annotations
	 * 	- @BeforeEach
	 * 	- @AfterEach
	 * 	- @BeforeAll
	 * 	- @AfterAll
	 * 	- @Test
	 * 	- @Ignore
	 *  - @Order
	 */
	
	private static Calculator calc;
	
	
	@BeforeAll
	public static void setUp() {
		calc = new Calculator();
	}
	
	@AfterAll
	public static void tearDown() {
	}
	
	@Order(1)
	@Test
	public void addTwoAndTwo() {
		double expected = 4;
		double actualResult = calc.add(2, 2);
		assertEquals(expected, actualResult, "Adding 2 and 2 should be 4");
	}
	@Order(2)
	@Test
	public void addTwoDecimals() {
		double expected = 0.9;
		double actualResult = calc.add(0.37, 0.53);
		assertEquals(expected, actualResult, "Adding 0.37 and 0.53 should be 0.9");
	}
	@Order(3)
	@Test
	public void addPossitiveAndNegative() {
		double expected = -1;
		double actualResult = calc.add(5, (-6));
		assertEquals(expected, actualResult, "Adding 5 and -6 should be -1");
	}
	@Order(4)
	@Test
	public void addPossitiveAndNegativeWithPosAns() {
		double expected = 4;
		double actualResult = calc.add(5, (-1));
		assertEquals(expected, actualResult, "Adding 5 and -1 should be -4");
	}
	@Order(5)
	@Test
	public void addLargeNumbers() {
		double expected = 10300;
		double actualResult = calc.add(7000, 3300);
		assertEquals(expected, actualResult, "Adding 7000 and 3300 should be 10300");
	}
	
	@Order(6)
	@Test
	public void subTwoFromTwo() {
		double expected = 0;
		double actual = calc.subtract(2, 2);
		assertEquals(expected, actual, "Subtracting 2 from 2 should be 0");
	}
	@Order(7)
	@Test
	public void subSixFrom10() {
		double expected = 4;
		double actual = calc.subtract(10, 6);
		assertEquals(expected, actual, "Subtracting 6 from 10 should be 4");
	}
	@Order(8)
	@Test
	public void subPositiveFromNegative() {
		double expected = -16;
		double actual = calc.subtract(-10, 6);
		assertEquals(expected, actual, "Subtracting 6 from -10 should be -16");
	}
	@Order(8)
	@Test
	public void subNegativeFromNegative() {
		double expected = -4;
		double actual = calc.subtract(-10, -6);
		assertEquals(expected, actual, "Subtracting -6 from -10 should be -4");
	}
	@Order(9)
	@Test
	public void subDoubles() {
		double expected = 0.75;
		double actual = calc.subtract(6.25, 5.5);
		assertEquals(expected, actual, "Subtracting 5.5 from 6.25 should be 0.75");
	}
	@Order(10)
	@Test
	public void multiTwoAndTwo() {
		double expected = 4;
		double actual = calc.multiply(2, 2);
		assertEquals(expected, actual, "Multiplying 2 and 2 should be 4");
	}
	@Order(11)
	@Test
	public void multiPositiveAndNegative() {
		double expected = -10;
		double actual = calc.multiply(-5, 2);
		assertEquals(expected, actual, "Multiplying -5 and 2 should be -10");
	}
	@Order(12)
	@Test
	public void multiDoubles() {
		double expected = 0.25;
		double actual = calc.multiply(0.5, 0.5);
		assertEquals(expected, actual, "Multiplying 0.5 and 0.5 should be 0.25");
	}
	@Order(13)
	@Test
	public void divideOneByTwo() {
		double expected = 0.5;
		double actual = calc.divide(1, 2);
		assertEquals(expected, actual, "Multiplying 1 and 2 should be 0.5");
	}
	@Order(14)
	@Test
	public void divideTenByfive() {
		double expected = 2;
		double actual = calc.divide(10, 5);
		assertEquals(expected, actual, "Multiplying 10 and 5 should be 2");
	}
	
	@Order(15)
	@Test
	public void divideBy0() {
		assertThrows(CalculatorException.class, () -> calc.divide(1,0));
		
	}
	@Order(16)
	@Test
	public void FiveIsPrime() {
		boolean expected = true;
		boolean actual = calc.isPrime(5);
		assertEquals(expected, actual, "Is a Prime Number");
	}
	@Order(17)
	@Test
	public void IsTenIsPrime() {
		boolean expected = false;
		boolean actual = calc.isPrime(1);
		assertEquals(expected, actual, "Is not a Prime Number");
	}
	
	@Order(18)
	@Test
	public void compareDoublesTrue() {
		boolean expected = true;
		boolean actual = calc.compartThreeDecimals(5.124, 5.124823);
		assertEquals(expected, actual, "Comparing up to Three Decimals 5.124 and 5.124823 should be true");
	}
	@Order(19)
	@Test
	public void compareDoublesFalse() {
		boolean expected = false;
		boolean actual = calc.compartThreeDecimals(5.129, 5.124823);
		assertEquals(expected, actual, "Comparing up to Three Decimals 5.129 and 5.124823 should be false");
	}
	@Order(20)
	@Test
	public void comparePositiveAndNegative() {
		boolean expected = false;
		boolean actual = calc.compartThreeDecimals(5.124, -5.124823);
		assertEquals(expected, actual, "Comparing up to Three Decimals 5.129 and 5.124823 should be false");
	}
}
