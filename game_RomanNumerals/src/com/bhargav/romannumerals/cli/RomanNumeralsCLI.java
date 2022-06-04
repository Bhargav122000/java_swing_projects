package com.bhargav.romannumerals.cli;

import java.util.ArrayList;

public class RomanNumeralsCLI {

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

	public String convertToRoman(int number) {
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

	public int convertToNumber(String roman) {
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

}
