package com.bhargav.converter.cli;

public class TemperatureConversion extends Conversion {

	public void convertFromCelsius() {
		double num1 = getValue();
		switch (getConvertUnitTo()) {
		case "celsius":
			setConvertedValue(num1 * 1.0);
			break;
		case "fahrenheit":
			setConvertedValue(((9 / 5) * num1) + 32.0);
			break;
		case "kelvin":
			setConvertedValue(num1 + 273.15);
			break;
		default:
			setConvertedValue(0);
			;
		}
	}

	public void convertFromFahrenheit() {
		double num1 = getValue();
		switch (getConvertUnitTo()) {
		case "celsius":
			setConvertedValue((num1 - 32.0) * (5 / 9));
			break;
		case "fahrenheit":
			setConvertedValue(num1 * 1.0);
			break;
		case "kelvin":
			num1 = (num1 - 32.0) * (5 / 9);
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
			setConvertedValue(((9 / 5) * num1) + 32.0);
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
}
