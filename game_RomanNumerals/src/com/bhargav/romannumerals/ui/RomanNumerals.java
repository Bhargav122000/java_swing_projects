package com.bhargav.romannumerals.ui;

import java.util.ArrayList;
import java.util.Random;

public abstract class RomanNumerals {
	private Random random;

	private int score;

	private String operandType;
	private int numberValue1, numberValue2;
	private String romanValue1, romanValue2;
	private char operator;
	private String expression;

	private String romanValue;
	private int actualNumberValue;
	private int providedNumberValue;

	private int numberValue;
	private String actualRomanValue;
	private String providedRomanValue;

	public RomanNumerals() {
		random = new Random();
		score = 0;
	}

	public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getOperandType() {
		return operandType;
	}

	public void setOperandType(String operandType) {
		this.operandType = operandType;
	}

	public int getNumberValue1() {
		return numberValue1;
	}

	public void setNumberValue1(int numberValue1) {
		this.numberValue1 = numberValue1;
	}

	public int getNumberValue2() {
		return numberValue2;
	}

	public void setNumberValue2(int numberValue2) {
		this.numberValue2 = numberValue2;
	}

	public String getRomanValue1() {
		return romanValue1;
	}

	public void setRomanValue1(String romanValue1) {
		this.romanValue1 = romanValue1;
	}

	public String getRomanValue2() {
		return romanValue2;
	}

	public void setRomanValue2(String romanValue2) {
		this.romanValue2 = romanValue2;
	}

	public char getOperator() {
		return operator;
	}

	public void setOperator(char operator) {
		this.operator = operator;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public String getRomanValue() {
		return romanValue;
	}

	public void setRomanValue(String romanValue) {
		this.romanValue = romanValue;
	}

	public int getActualNumberValue() {
		return actualNumberValue;
	}

	public void setActualNumberValue(int actualNumberValue) {
		this.actualNumberValue = actualNumberValue;
	}

	public int getProvidedNumberValue() {
		return providedNumberValue;
	}

	public void setProvidedNumberValue(int providedNumberValue) {
		this.providedNumberValue = providedNumberValue;
	}

	public int getNumberValue() {
		return numberValue;
	}

	public void setNumberValue(int numberValue) {
		this.numberValue = numberValue;
	}

	public String getActualRomanValue() {
		return actualRomanValue;
	}

	public void setActualRomanValue(String actualRomanValue) {
		this.actualRomanValue = actualRomanValue;
	}

	public String getProvidedRomanValue() {
		return providedRomanValue;
	}

	public void setProvidedRomanValue(String providedRomanValue) {
		this.providedRomanValue = providedRomanValue;
	}

	public int generateNumber() {
		return random.nextInt(1, 3001);
	}

	public String generateRoman() {
		int n = random.nextInt(1, 3001);
		return convertToRoman(n);
	}

	private void generateOperator() {
		boolean temp = new Random().nextBoolean();
		if (temp) {
			operator = '+';
		} else {
			operator = '-';
		}
	}

	private void decideOperandsType() {
		boolean temp = new Random().nextBoolean();
		if (temp) {
			operandType = "number";
		} else {
			operandType = "roman";
		}
	}

	private void generateOperands() {
		int operand1, operand2;
		operand1 = generateNumber();
		if (operator == '+') {
			do {
				operand2 = generateNumber();
			} while (operand1 + operand2 > 3000);
		} else {
			do {
				operand2 = generateNumber();
			} while (operand1 <= operand2);
		}

		if (operandType.equals("number")) {
			numberValue1 = operand1;
			numberValue2 = operand2;
		} else {
			romanValue1 = convertToRoman(operand1);
			romanValue2 = convertToRoman(operand2);
		}
	}

	public String generateExpression() {
		String expr = null;
		generateOperator();
		decideOperandsType();
		generateOperands();

		if (operandType.equals("number")) {
			expr = numberValue1 + " " + operator + " " + numberValue2;
		} else {
			expr = romanValue1 + " " + operator + " " + romanValue2;
		}
		return expr;
	}

	private String convertToRomanThousands(int number) {
		String str = "";
		int count = 0;
		if (number >= 1000) {
			count = number / 1000;
			for (int i = 1; i <= count; i++) {
				str += "M";
			}
		}
		return str;
	}

	private String convertToRomanHundreds(int number) {
		String str = "";
		int count = 0;
		if (number >= 100) {
			count = number / 100;
			if (count <= 3) {
				for (int i = 1; i <= count; i++) {
					str += "C";
				}
			} else if (count == 4) {
				str += "CD";
			} else if (count >= 5 && count <= 8) {
				str += "D";
				for (int i = 1; i <= count - 5; i++) {
					str += "C";
				}
			}
			if (count == 9) {
				str += "CM";
			}
		}
		return str;
	}

	private String convertToRomanTens(int number) {
		String str = "";
		int count = 0;
		if (number >= 10) {
			count = number / 10;
			if (count <= 3) {
				for (int i = 1; i <= count; i++) {
					str += "X";
				}
			} else if (count == 4) {
				str += "XL";
			} else if (count >= 5 && count <= 8) {
				str += "L";
				for (int i = 1; i <= count - 5; i++) {
					str += "X";
				}
			}
			if (count == 9) {
				str += "XC";
			}
		}
		return str;
	}

	private String convertToRomanOnes(int number) {
		String str = "";
		int count = 0;
		if (number >= 1) {
			count = number / 1;
			if (count <= 3) {
				for (int i = 1; i <= count; i++) {
					str += "I";
				}
			} else if (count == 4) {
				str += "IV";
			} else if (count >= 5 && count <= 8) {
				str += "V";
				for (int i = 1; i <= count - 5; i++) {
					str += "I";
				}
			}
			if (count == 9) {
				str += "IX";
			}
		}
		return str;
	}

	protected String convertToRoman(int number) {
		String roman;
		StringBuilder romanTemp = new StringBuilder();
		romanTemp.append(convertToRomanThousands(number));
		number %= 1000;
		romanTemp.append(convertToRomanHundreds(number));
		number %= 100;
		romanTemp.append(convertToRomanTens(number));
		number %= 10;
		romanTemp.append(convertToRomanOnes(number));
		number %= 1;
		roman = romanTemp.toString();
		return roman;
	}

	private int convertToNumberThousands(ArrayList<String> romanList) {
		int count = 0;
		int num = 0;
		if (romanList.size() > 0 && romanList.get(0).equals("M")) {
			count = 0;
			for (int i = 0; i < romanList.size(); i++) {
				if (romanList.get(i).equals("M")) {
					count++;
				} else {
					break;
				}
			}
			for (int i = 1; i <= count; i++) {
				romanList.remove(0);
			}
			num = (count * 1000);
		}
		return num;
	}

	private int convertToNumberHundreds(ArrayList<String> romanList) {
		int count = 0;
		int num = 0;

		if (romanList.size() > 0 && romanList.get(0).equals("D")) {
			count = 1;
			num = (count * 500);
			romanList.remove(0);
		}

		if (romanList.size() > 0 && romanList.get(0).equals("C")) {
			if (romanList.size() > 1 && romanList.get(1).equals("D")) {
				count = 4;
				romanList.remove(0);
				romanList.remove(0);
			} else if (romanList.size() > 1 && romanList.get(1).equals("M")) {
				count = 9;
				romanList.remove(0);
				romanList.remove(0);
			} else {
				count = 0;
				for (int i = 0; i < romanList.size(); i++) {
					if (romanList.get(i).equals("C")) {
						count++;
					} else {
						break;
					}
				}
				for (int i = 1; i <= count; i++) {
					romanList.remove(0);
				}
			}
			num += (count * 100);
		}
		return num;
	}

	private int convertToNumberTens(ArrayList<String> romanList) {
		int count = 0;
		int num = 0;

		if (romanList.size() > 0 && romanList.get(0).equals("L")) {
			count = 1;
			num = (count * 50);
			romanList.remove(0);
		}

		if (romanList.size() > 0 && romanList.get(0).equals("X")) {
			if (romanList.size() > 1 && romanList.get(1).equals("L")) {
				count = 4;
				romanList.remove(0);
				romanList.remove(0);
			} else if (romanList.size() > 1 && romanList.get(1).equals("C")) {
				count = 9;
				romanList.remove(0);
				romanList.remove(0);
			} else {
				count = 0;
				for (int i = 0; i < romanList.size(); i++) {
					if (romanList.get(i).equals("X")) {
						count++;
					} else {
						break;
					}
				}
				for (int i = 1; i <= count; i++) {
					romanList.remove(0);
				}
			}
			num += (count * 10);
		}
		return num;
	}

	private int convertToNumberOnes(ArrayList<String> romanList) {
		int count = 0;
		int num = 0;

		if (romanList.size() > 0 && romanList.get(0).equals("V")) {
			count = 1;
			num = (count * 5);
			romanList.remove(0);
		}

		if (romanList.size() > 0 && romanList.get(0).equals("I")) {
			if (romanList.size() > 1 && romanList.get(1).equals("V")) {
				count = 4;
				romanList.remove(0);
				romanList.remove(0);
			} else if (romanList.size() > 1 && romanList.get(1).equals("X")) {
				count = 9;
				romanList.remove(0);
				romanList.remove(0);
			} else {
				count = 0;
				for (int i = 0; i < romanList.size(); i++) {
					if (romanList.get(i).equals("I")) {
						count++;
					} else {
						break;
					}
				}
				for (int i = 1; i <= count; i++) {
					romanList.remove(0);
				}
			}
			num += (count * 1);
		}
		return num;
	}

	protected int convertToNumber(String roman) {
		ArrayList<String> romanList = new ArrayList<String>();
		for (int i = 0; i < roman.length(); i++) {
			romanList.add(String.valueOf(roman.charAt(i)));
		}

		int number, numberTemp = 0;
		numberTemp += convertToNumberThousands(romanList);
		numberTemp += convertToNumberHundreds(romanList);
		numberTemp += convertToNumberTens(romanList);
		numberTemp += convertToNumberOnes(romanList);
		number = numberTemp;
		return number;
	}

	public abstract void updateScore();

	public abstract void generateInputValue();

	public abstract void convert();
}
