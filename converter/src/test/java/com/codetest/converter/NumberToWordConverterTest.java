package com.codetest.converter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.codetest.converter.impl.NumberToWordConverter;

/**
 * Unit test for simple App.
 */
public class NumberToWordConverterTest {
	
	NumberToWordConverter converter = new NumberToWordConverter();

	@Test
	public void negativeInput() {
		assertEquals(NumberToWordConverter.NEGATIVE+"twelve",converter.convert(-12));
	}

	@Test
	public void zeroInput() {
		assertEquals(NumberToWordConverter.ZERO,converter.convert(0));
	}

	@Test
	public void positiveTensInput() {
		assertEquals("ninety nine",converter.convert(99));	
	}
	@Test
	public void positiveHundredsInput() {
		assertEquals("eight hundred and ninety nine",converter.convert(899));	
	}
	@Test
	public void positiveThousandsInput() {
		assertEquals("nine thousand",converter.convert(9000));	
	}
	@Test
	public void positiveMillionsInput() {
		assertEquals("one million ninety nine",converter.convert(1000099));	
	}
	@Test
	public void positiveHundredMillionsInput() {
		assertEquals(
				"nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine",
				converter.convert(999999999));	
	}
	@Test
	public void greaterThanUpperLimit() {
		assertEquals(NumberToWordConverter.LIMIT_CROSSED,converter.convert(1999999999));	
	}	
}
