package main.java.bignumbers;

import java.util.AbstractMap;
import java.util.Map;

public class BigNumber {
	private static final int PRECISION = 192;
	private byte[] digits;

	public BigNumber() {
		digits = new byte[PRECISION];
	}

	public BigNumber(String s) {
		char[] charArr = s.toCharArray();

		Byte[] byteArr = new Byte[charArr.length];

		for (int i = 0; i < byteArr.length; i++) {
			byteArr[i] = Byte.parseByte(Character.toString(charArr[i]));
		}

		digits = getFixedArray(byteArr);
	}

	public BigNumber add(BigNumber number) {
		byte c = 0;

		BigNumber res = new BigNumber();

		for (int i = 0; i < digits.length; i++) {
			// jezeli suma jest < 10 nie ma przesuniecia
			if (this.digits[i] + number.digits[i] < 10) {
				Map.Entry<Byte, Byte> tuple = addDigits(this.digits[i], number.digits[i]);

				if (res.digits[i] == 0) {
					res.digits[i] = tuple.getKey();
				} else {
					res.digits[i] = (byte) (res.digits[i] + tuple.getKey());
				}
			} else {
				Map.Entry<Byte, Byte> tuple = addDigits(this.digits[i], number.digits[i]);

				res.digits[i] = tuple.getKey();
				res.digits[i + 1] = tuple.getValue();
			}
		}

		return res;
	}

	public Map.Entry<Byte, Byte> addDigits(byte digit1, byte digit2) {
		byte r = (byte) ((digit1 + digit2) % 10);
		byte c = (byte) ((digit1 + digit2) / 10);

		Map.Entry<Byte, Byte> result = new AbstractMap.SimpleEntry<Byte, Byte>(r, c);

		return result;
	}

	public BigNumber substract(BigNumber number) {
		byte c = 0;

		BigNumber res = new BigNumber();

		for (int i = 0; i < digits.length; i++) {
			Map.Entry<Byte, Byte> tuple = substractDigits(this.digits[i], number.digits[i], c);
			c = tuple.getValue();

			res.digits[i] = tuple.getKey();
		}

		return res;
	}

	public Map.Entry<Byte, Byte> substractDigits(byte digit1, byte digit2, byte carry) {
		byte r = (byte) ((digit1 - digit2 - carry) - ((digit1 - digit2 - carry) % 10));
		byte c = (byte) ((digit1 - digit2 - carry) / 10);

		Map.Entry<Byte, Byte> result = new AbstractMap.SimpleEntry<Byte, Byte>(r, c);

		return result;
	}

	public BigNumber multiply(BigNumber number) {
		byte c = 0;

		BigNumber res = new BigNumber();

		for (int i = 0; i < digits.length; i++) {
			for (int j = 0; j < digits.length; j++) {
				Map.Entry<Byte, Byte> tuple = multiplyDigits(this.digits[i], number.digits[j], c);
				c = tuple.getValue();

				res.digits[i + j] += tuple.getKey();
			}
			
			res.digits[i] += c;
		}

		return res;
	}

	public Map.Entry<Byte, Byte> multiplyDigits(byte digit1, byte digit2, byte carry) {
		byte r = (byte) ((digit1 * digit2 + carry) - ((digit1 * digit2 + carry) % 10));
		byte c = (byte) ((digit1 * digit2 + carry) / 10);

		Map.Entry<Byte, Byte> result = new AbstractMap.SimpleEntry<Byte, Byte>(r, c);

		return result;
	}

	public byte[] getFixedArray(Byte[] arr) {
		byte[] res = new byte[PRECISION];

		for (int i = arr.length - 1, j = 0; i >= 0; i--, j++) {
			res[j] = arr[i];
		}

		return res;
	}

	public String getValue() {
		StringBuilder sb = new StringBuilder();

		int ind = digits.length - 1;

		while (digits[ind] == 0 && ind > 0) {
			ind--;
		}

		for (int i = ind; i >= 0; i--) {
			sb.append(digits[i]);
		}

		return sb.toString();
	}
}
