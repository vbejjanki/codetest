package com.codetest.converter.impl;

import com.codetest.converter.api.Converter;
import com.codetest.util.Constants;

public class NumberToWordConverter implements Converter {
	
	public static String LIMIT_CROSSED = "Number greater than 999,999,999";
	public static String ZERO = "zero";
	public static String NEGATIVE = "negative of ";
	
	@Override
	public String convert(int input) {
		StringBuilder builder = new StringBuilder();
		if (input < 0) {
			builder.append(NEGATIVE);
			input = -input;
		}else if(input == 0) {
			return ZERO;
		}
		builder.append(convert(input,false));
		return builder.toString();
	}

	
	private String convert(final int number,boolean negative) {
		if (number < 20) {
			return Constants.zeroToNineteen.get(number);
		}
		// n = 20 to 99
		if (number < 100) {
			return Constants.tenMultiples.get(number / 10) + ((number % 10 != 0) ? " " : "")
					+ Constants.zeroToNineteen.get(number % 10);
		}
		// dividing the number into 3 zero multiples
		if (number < 1000) {
			return Constants.zeroToNineteen.get(number / 100) + " hundred" + ((number % 100 != 0) ? " and " : "") + convert(number % 100,false);
		}
		if (number < 1000000) {
			return convert(number / 1000,false) + " thousand" + ((number % 1000 != 0) ? " " : "") + convert(number % 1000,false);
		}
		if (number < 1000000000) {
			return convert(number / 1000000) + " million" + ((number % 1000000 != 0) ? " " : "") + convert(number % 1000000);
		}

		return LIMIT_CROSSED;
	}

}
