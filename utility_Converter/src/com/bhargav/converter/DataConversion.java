package com.bhargav.converter;

import java.util.*;

public class DataConversion {
	private String convertUnitFrom;
	private String convertUnitTo;
	private double value;
	private double convertedValue;

	public String getConvertUnitFrom() {
		return convertUnitFrom;
	}

	public void setConvertUnitFrom(String convertUnitFrom) {
		this.convertUnitFrom = convertUnitFrom;
	}

	public String getConvertUnitTo() {
		return convertUnitTo;
	}

	public void setConvertUnitTo(String convertUnitTo) {
		this.convertUnitTo = convertUnitTo;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public double getConvertedValue() {
		return convertedValue;
	}

	public void setConvertedValue(double convertedValue) {
		this.convertedValue = convertedValue;
	}

	public void convertFromBit() {
		double num1 = getValue();
		switch (getConvertUnitTo()) {
		case "bit":
			setConvertedValue(num1 * 1.0);
			break;
		case "byte":
			setConvertedValue(num1 * 0.125);
			break;
		case "kilobyte":
			setConvertedValue(num1 * 0.0001220703);
			break;
		case "megabyte":
			setConvertedValue(num1 * 1.19209290E-7);
			break;
		case "gigabyte":
			setConvertedValue(num1 * 1.16415322E-10);
			break;
		case "terabyte":
			setConvertedValue(num1 * 1.13686838E-13);
			break;
		default:
			setConvertedValue(0);
		}
	}

	public void convertFromByte() {
		double num1 = getValue();
		switch (getConvertUnitTo()) {
		case "bit":
			setConvertedValue(num1 * 8.0);
			break;
		case "byte":
			setConvertedValue(num1 * 1.0);
			break;
		case "kilobyte":
			setConvertedValue(num1 * 0.0009765625);
			break;
		case "megabyte":
			setConvertedValue(num1 * 0.0000009537);
			break;
		case "gigabyte":
			setConvertedValue(num1 * 0.0000000009);
			break;
		case "terabyte":
			setConvertedValue(num1 * 9.09494702E-13);
			break;
		default:
			setConvertedValue(0);
		}
	}

	public void convertFromKiloByte() {
		double num1 = getValue();
		switch (getConvertUnitTo()) {
		case "bit":
			setConvertedValue(num1 * 8192.0);
			break;
		case "byte":
			setConvertedValue(num1 * 1024.0);
			break;
		case "kilobyte":
			setConvertedValue(num1 * 1.0);
			break;
		case "megabyte":
			setConvertedValue(num1 * 0.0009765625);
			break;
		case "gigabyte":
			setConvertedValue(num1 * 0.0000009537);
			break;
		case "terabyte":
			setConvertedValue(num1 * 0.0000000009);
			break;
		default:
			setConvertedValue(0);
		}
	}

	public void convertFromMegaByte() {
		double num1 = getValue();
		switch (getConvertUnitTo()) {
		case "bit":
			setConvertedValue(num1 * 8388608.0);
			break;
		case "byte":
			setConvertedValue(num1 * 1048576.0);
			break;
		case "kilobyte":
			setConvertedValue(num1 * 1024.0);
			break;
		case "megabyte":
			setConvertedValue(num1 * 1.0);
			break;
		case "gigabyte":
			setConvertedValue(num1 * 0.0009765625);
			break;
		case "terabyte":
			setConvertedValue(num1 * 0.0000009537);
			break;
		default:
			setConvertedValue(0);
		}
	}

	public void convertFromGigaByte() {
		double num1 = getValue();
		switch (getConvertUnitTo()) {
		case "bit":
			setConvertedValue(num1 * 8589934592.0);
			break;
		case "byte":
			setConvertedValue(num1 * 1073741824.0);
			break;
		case "kilobyte":
			setConvertedValue(num1 * 1048576.0);
			break;
		case "megabyte":
			setConvertedValue(num1 * 1024);
			break;
		case "gigabyte":
			setConvertedValue(num1 * 1);
			break;
		case "terabyte":
			setConvertedValue(num1 * 0.0009765625);
			break;
		default:
			setConvertedValue(0);
		}
	}

	public void convertFromTeraByte() {
		double num1 = getValue();
		switch (getConvertUnitTo()) {
		case "bit":
			setConvertedValue(num1 * 8796093022208.0);
			break;
		case "byte":
			setConvertedValue(num1 * 1099511627776.0);
			break;
		case "kilobyte":
			setConvertedValue(num1 * 1073741824.0);
			break;
		case "megabyte":
			setConvertedValue(num1 * 1048576.0);
			break;
		case "gigabyte":
			setConvertedValue(num1 * 1024);
			break;
		case "terabyte":
			setConvertedValue(num1 * 1);
			break;
		default:
			setConvertedValue(0);
		}
	}

	public void convert() {
		switch (getConvertUnitFrom()) {
		case "bit":
			convertFromBit();
			break;
		case "byte":
			convertFromByte();
			break;
		case "kilobyte":
			convertFromKiloByte();
			break;
		case "megabyte":
			convertFromMegaByte();
			break;
		case "gigabyte":
			convertFromGigaByte();
			break;
		case "terabyte":
			convertFromTeraByte();
			break;
		default:
			setConvertedValue(0);
		}
	}

	public static void main(String[] args) {
		DataConversion dataConversion = new DataConversion();
		Scanner scanner = new Scanner(System.in);

		try {
			System.out.println("Enter the unit to convert:");
			dataConversion.setConvertUnitFrom(scanner.nextLine());
			System.out.println("Enter the unit to be converted into:");
			dataConversion.setConvertUnitTo(scanner.nextLine());
			System.out.println("Enter the value to convert:");
			dataConversion.setValue(Double.parseDouble(scanner.nextLine()));
			dataConversion.convert();
			System.out.println(dataConversion.getConvertedValue());
		} catch (NumberFormatException e) {
			System.out.println("Invalid input for value");
		} finally {
			scanner.close();
		}
	}
}
