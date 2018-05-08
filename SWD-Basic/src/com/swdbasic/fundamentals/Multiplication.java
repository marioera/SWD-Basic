package com.swdbasic.fundamentals;

public class Multiplication {

	public int mult(int a, int b) {
		int total = 0;

		if (a < 0) {
			a = -a;
			b = -b;
		}

		while (a >= 1) {
			if (a % 2 != 0) {
				total += b;
			}
			a >>= 1;
			b <<= 1;
		}

		return total;
	}

	public int mult_Myriam(int a, int b) {
		int count = 0;
		int divi, multi;
		int c = 0;
		int bAux = b;
		int d = 0;

		if (a == 0 || b == 0) {
			d = 0;
		} else {

			if (a < 0) {
				a = a * (-1);
				b = b * (-1);
				bAux = bAux * (-1);
			}

			if (a % 2 == 0) {
				while (a != 1) {

					divi = (a >> 1);
					multi = (b << 1);
					count++;
					a = divi;
					b = multi;

					if (a % 2 != 0) {
						c = c + multi;
					}
					d = c;
				}
			} else {
				while (a != 1) {
					divi = (a >> 1);
					multi = (b << 1);

					count++;
					a = divi;
					b = multi;

					if (a % 2 != 0) {
						c = c + multi;
					}
					d = c + bAux;
				}
			}
		}
		return d;
	}

	public int mult_Sandra(int a, int b) {
		int resultb = 0;
		int total = 0;
		int lastb;
		if (a < 0 || b < 0) {
			a = -a;
			b = -b;
		}
		if (a < 0 || b > 0) {
			int a1 = a;
			a = b;
			b = a1;
		}

		while (a >= 1) {
			lastb = b;
			if (a % 2 == 0) {
				resultb = 0;
				lastb = 0;
			}
			a = a >> 1;
			b = b << 1;
			resultb = lastb + total;
			total = resultb;
		}
		return total;
	}

	public int mult_Leo(int a, int b) {
		int sum = 0;
		while (a != 0) {
			if (a % 2 != 0) {
				sum += b;
			}
			a = a >>> 1; // dividir por 2
			b = b << 1; // Multiplicar por 2
		}
		return sum;
	}

	public int mult_Rorro(int a, int b) {
		int result = 0;
		int count = 1;
		if (a <= -1) {
			a = a * -1;
			count = count * -1;
		}
		while (a != 0) {
			if (a % 2 != 0) {
				result += b;
			}
			a = a >> 1;
			b = b << 1;
		}
		return result * count;
	}

	public int mult_Jimmy(int a, int b) {
		int result = 0;
		byte signFlag = 1;

		// Logic to validate if the variable "a" is negative, when case is true
		// it change its natural state to positive.
		if (a < 0) {
			a = a * -1;
			signFlag = -1;
		}

		// Logic to validate if the variable "a" is pair, when case is true the
		// variable "result" is set with the "b" value.
		if (a % 2 == 0) {
			result = 0;
		} else {
			result = b;
		}

		// Logic to add values to "result" when "a" division there aren't exact.
		while (a != 0 && a != -1) {
			if ((a >> 1) % 2 == 0) {
				b = b << 1;
			} else {
				result = result + (b << 1);
				b = b << 1;
			}
			a = a >> 1;
		}

		// Logic to return natural state to "a" when initially was negative.
		if (signFlag == -1) {
			result = result * signFlag;
		}

		return result;
	}

	public int mult_Frey(int a, int b) {
		int varsigno = 0; // 0= negative, 1=positive

		if (a >= 0 && b >= 0)
			varsigno = 1;
		if (a <= 0 && b <= 0)
			varsigno = 1;

		if (varsigno == 0 || varsigno == 1) {
			if (a <= 0)
				a = a * (-1);
			if (b <= 0)
				b = b * (-1);
		}

		int var = 0;

		while (a > 0 || a > 1) {
			if (a % 2 != 0) {
				var = var + b;
			}
			a = a >> 1; // divide
			b = b << 1; // multiply
		}

		if (varsigno == 0)
			var = var * (-1);
		return var;
	}

	public int mult_Nelson(int a, int b) {
		int counter = 0;
		int split;
		int multi;
		int c = 0;
		int belse = b;
		int d = 0;
		if (a % 2 == 0) {
			while (a != 1) {

				split = (a >> 1);
				multi = (b << 1);
				counter++;
				a = split;
				b = multi;

				if (a % 2 != 0) {
					c = c + multi;
				}
				d = c;
			}
		} else {
			while (a != 1) {
				split = (a >> 1);
				multi = (b << 1);

				counter++;
				a = split;
				b = multi;

				if (a % 2 != 0) {
					c = c + multi;
				}
				d = c + belse;
			}
		}
		return d;
	}

	/* CarlosR */
	private int evalnumbers(int a, int b) {
		if (a == 0 || b == 0) {
			return 0;
		}

		else if (a == 1 || b == 1) {
			return multexp(a, b);
		}

		return -1;
	}

	private int mod(int val) {
		return val % 2;
	}

	private int divBits(int val) {
		return val >> 1;
	}

	private int multBits(int val) {
		return val << 1;
	}

	public int multexp(int a, int b) {
		return a * b;
	}

	public int mult_CarlosR(int a, int b) {
		boolean flag = false;
		int eval;
		int resultmult;
		int resultdiv;
		int mod;
		int sum = 0;

		eval = evalnumbers(a, b);

		if (eval != -1) {
			return eval;
		}

		mod = mod(a);
		if (mod == 1) {
			sum += b;
		}

		while (flag == false) {
			resultmult = multBits(b);
			resultdiv = divBits(a);
			if (resultdiv == 1) {
				sum += resultmult;
				flag = true;
			}

			else {
				mod = mod(resultdiv);
				if (mod == 1) {
					sum += resultmult;
				}
				b = resultmult;
				a = resultdiv;
			}
		}

		return sum;
	}

	/* FIN - CarlosR */

	/* JonathanM */
	private int div(int x) {
		return x >> 1;
	}

	private int mult(int x) {
		return x << 1;
	}

	public int mult_Jonathan(int a, int b) {
		int divA = a;
		int multB = b;
		int result = 0;

		if (mod(b) == 0)
			result = b;

		while (divA > 0) {
			divA = div(divA);
			multB = mult(multB);
			if (mod(divA) != 0) {
				result = result + multB;
			}
		}

		return result;
	}

	/* FIN - JonathanM */
}
