package com.bhargav.converter;

import java.util.*;

public class TemperatureConversion {
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

	public void convertFromCelsius() {
		double num1 = getValue();
		switch (getConvertUnitTo()) {
		case "celsius":
			setConvertedValue(num1 * 1.0);
			break;
		case "fahrenheit":
			setConvertedValue(((9/5) * num1) + 32.0);
			break;
		case "kelvin":
			setConvertedValue(num1 + 273.15);
			break;
		default:
			setConvertedValue(0);;
		}
	}
	
	public void convertFromFahrenheit() {
		double num1 = getValue();
		switch (getConvertUnitTo()) {
		case "celsius":
			setConvertedValue((num1 - 32.0) * (5/9));
			break;
		case "fahrenheit":
			setConvertedValue(num1 * 1.0);
			break;
		case "kelvin":
			num1 = (num1 - 32.0) * (5/9);
			setConvertedValue(num1 + 273.15);
			break;
		default:
			setConvertedValue(0);
		}
	}
	
	public void convertFromKelvin() {
		double num1 = getValue();
		switch (getConvertUnitTo()) {
		case "celsius":
			setConvertedValue(num1 - 273.15);
			break;
		case "fahrenheit":
			num1 = num1 - 273.15;
			setConvertedValue(((9/5) * num1) + 32.0);
			break;
		case "kelvin":
			setConvertedValue(num1 * 1.0);
			break;
		default:
			setConvertedValue(0);
		}
	}
	
	public void convert() {
		switch (getConvertUnitFrom()) {
		case "celsius":
			convertFromCelsius();
			break;
		case "fahrenheit":
			convertFromFahrenheit();
			break;
		case "kelvin":
			convertFromKelvin();
			break;
		default:
			setConvertedValue(0);
		}
	}
	
	public static void main(String[] args) {
		TemperatureConversion temperatureConversion = new TemperatureConversion();
		Scanner scanner = new Scanner(System.in);

		try {
			System.out.println("Enter the unit to convert:");
			temperatureConversion.setConvertUnitFrom(scanner.nextLine());
			System.out.println("Enter the unit to be converted into:");
			temperatureConversion.setConvertUnitTo(scanner.nextLine());
			System.out.println("Enter the value to convert:");
			temperatureConversion.setValue(Double.parseDouble(scanner.nextLine()));
			temperatureConversion.convert();
			System.out.println(temperatureConversion.getConvertedValue());
		} catch (NumberFormatException e) {
			System.out.println("Invalid input for value");
		} finally {
			scanner.close();
		}
	}
}
