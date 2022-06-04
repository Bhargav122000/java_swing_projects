package com.bhargav.converter;

import java.util.*;

public class AreaConversion {
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

	public void convertFromAcre() {
		double num1 = getValue();
		switch (getConvertUnitTo()) {
		case "acre":
			setConvertedValue(num1 * 1);
			break;
		case "hectare":
			setConvertedValue(num1 * 0.4046856422);
			break;
		case "square centimetre":
			setConvertedValue(num1 * 40468564.224);
			break;
		case "square foot":
			setConvertedValue(num1 * 43560);
			break;
		case "square inch":
			setConvertedValue(num1 * 6272640);
			break;
		case "square metre":
			setConvertedValue(num1 * 4046.8564224);
			break;
		default:
			setConvertedValue(0);
		}
	}

	public void convertFromHectare() {
		double num1 = getValue();
		switch (getConvertUnitTo()) {
		case "acre":
			setConvertedValue(num1 * 2.4710538147);
			break;
		case "hectare":
			setConvertedValue(num1 * 1);
			break;
		case "square centimetre":
			setConvertedValue(num1 * 100000000);
			break;
		case "square foot":
			setConvertedValue(num1 * 107639.10416709);
			break;
		case "square inch":
			setConvertedValue(num1 * 15500031.000062);
			break;
		case "square metre":
			setConvertedValue(num1 * 10000);
			break;
		default:
			setConvertedValue(0);
		}
	}

	public void convertFromSquareCentimeter() {
		double num1 = getValue();
		switch (getConvertUnitTo()) {
		case "acre":
			setConvertedValue(num1 * 2.47105381E-8);
			break;
		case "hectare":
			setConvertedValue(num1 * 0.00000001);
			break;
		case "square centimetre":
			setConvertedValue(num1 * 1);
			break;
		case "square foot":
			setConvertedValue(num1 * 0.001076391);
			break;
		case "square inch":
			setConvertedValue(num1 * 0.15500031);
			break;
		case "square metre":
			setConvertedValue(num1 * 0.0001);
			break;
		default:
			setConvertedValue(0);
		}
	}

	public void convertFromSquareFoot() {
		double num1 = getValue();
		switch (getConvertUnitTo()) {
		case "acre":
			setConvertedValue(num1 * 0.0000229568);
			break;
		case "hectare":
			setConvertedValue(num1 * 0.0000092903);
			break;
		case "square centimetre":
			setConvertedValue(num1 * 929.0304);
			break;
		case "square foot":
			setConvertedValue(num1 * 1);
			break;
		case "square inch":
			setConvertedValue(num1 * 144);
			break;
		case "square metre":
			setConvertedValue(num1 * 0.09290304);
			break;
		default:
			setConvertedValue(0);
		}
	}

	public void convertFromSquareInch() {
		double num1 = getValue();
		switch (getConvertUnitTo()) {
		case "acre":
			setConvertedValue(num1 * 1.59422508E-7);
			break;
		case "hectare":
			setConvertedValue(num1 * 0.0000000645);
			break;
		case "square centimetre":
			setConvertedValue(num1 * 6.4516);
			break;
		case "square foot":
			setConvertedValue(num1 * 0.0069444444);
			break;
		case "square inch":
			setConvertedValue(num1 * 1);
			break;
		case "square metre":
			setConvertedValue(num1 * 0.00064516);
			break;
		default:
			setConvertedValue(0);
		}
	}

	public void convertFromSquareMetre() {
		double num1 = getValue();
		switch (getConvertUnitTo()) {
		case "acre":
			setConvertedValue(num1 * 0.0002471054);
			break;
		case "hectare":
			setConvertedValue(num1 * 0.0001);
			break;
		case "square centimetre":
			setConvertedValue(num1 * 10000);
			break;
		case "square foot":
			setConvertedValue(num1 * 10.7639104167);
			break;
		case "square inch":
			setConvertedValue(num1 * 1550.0031000062);
			break;
		case "square metre":
			setConvertedValue(num1 * 1);
			break;
		default:
			setConvertedValue(0);
		}
	}

	public void convert() {
		switch (getConvertUnitFrom()) {
		case "acre":
			convertFromAcre();
			break;
		case "hectare":
			convertFromHectare();
			break;
		case "square centimetre":
			convertFromSquareCentimeter();
			break;
		case "square foot":
			convertFromSquareFoot();
			break;
		case "square inch":
			convertFromSquareInch();
			break;
		case "square metre":
			convertFromSquareMetre();
			break;
		default:
			setConvertedValue(0);
		}
	}

	public static void main(String[] args) {
		AreaConversion areaConversion = new AreaConversion();
		Scanner scanner = new Scanner(System.in);

		try {
			System.out.println("Enter the unit to convert:");
			areaConversion.setConvertUnitFrom(scanner.nextLine());
			System.out.println("Enter the unit to be converted into:");
			areaConversion.setConvertUnitTo(scanner.nextLine());
			System.out.println("Enter the value to convert:");
			areaConversion.setValue(Double.parseDouble(scanner.nextLine()));
			areaConversion.convert();
			System.out.println(areaConversion.getConvertedValue());
		} catch (NumberFormatException e) {
			System.out.println("Invalid input for value");
		} finally {
			scanner.close();
		}

	}
}
