package com.bhargav.converter.cli;

public class MassConversion extends Conversion {

	public void convertFromTon() {
		double num1 = getValue();
		switch (getConvertUnitTo()) {
		case "ton":
			setConvertedValue(num1 * 1.0);
			break;
		case "pound":
			setConvertedValue(num1 * 2204.6226218488);
			break;
		case "ounce":
			setConvertedValue(num1 * 35273.96194958);
			break;
		case "kilogram":
			setConvertedValue(num1 * 1000.0);
			break;
		case "gram":
			setConvertedValue(num1 * 1000000.0);
			break;
		default:
			setConvertedValue(0);
		}
	}

	public void convertFromPound() {
		double num1 = getValue();
		switch (getConvertUnitTo()) {
		case "ton":
			setConvertedValue(num1 * 0.0004535924);
			break;
		case "pound":
			setConvertedValue(num1 * 1.0);
			break;
		case "ounce":
			setConvertedValue(num1 * 16.0);
			break;
		case "kilogram":
			setConvertedValue(num1 * 0.45359237);
			break;
		case "gram":
			setConvertedValue(num1 * 453.59237);
			break;
		default:
			setConvertedValue(0);
		}
	}

	public void convertFromOunce() {
		double num1 = getValue();
		switch (getConvertUnitTo()) {
		case "ton":
			setConvertedValue(num1 * 0.0000283495);
			break;
		case "pound":
			setConvertedValue(num1 * 0.0625);
			break;
		case "ounce":
			setConvertedValue(num1 * 1.0);
			break;
		case "kilogram":
			setConvertedValue(num1 * 0.0283495231);
			break;
		case "gram":
			setConvertedValue(num1 * 28.349523125);
			break;
		default:
			setConvertedValue(0);
		}
	}

	public void convertFromKiloGram() {
		double num1 = getValue();
		switch (getConvertUnitTo()) {
		case "ton":
			setConvertedValue(num1 * 0.001);
			break;
		case "pound":
			setConvertedValue(num1 * 2.2046226218);
			break;
		case "ounce":
			setConvertedValue(num1 * 35.2739619496);
			break;
		case "kilogram":
			setConvertedValue(num1 * 1.0);
			break;
		case "gram":
			setConvertedValue(num1 * 1000.0);
			break;
		default:
			setConvertedValue(0);
		}
	}

	public void convertFromGram() {
		double num1 = getValue();
		switch (getConvertUnitTo()) {
		case "ton":
			setConvertedValue(num1 * 0.000001);
			break;
		case "pound":
			setConvertedValue(num1 * 0.0022046226);
			break;
		case "ounce":
			setConvertedValue(num1 * 0.0352739619);
			break;
		case "kilogram":
			setConvertedValue(num1 * 0.001);
			break;
		case "gram":
			setConvertedValue(num1 * 1.0);
			break;
		default:
			setConvertedValue(0);
		}
	}

	public void convert() {
		switch (getConvertUnitFrom()) {
		case "ton":
			convertFromTon();
			break;
		case "pound":
			convertFromPound();
			break;
		case "ounce":
			convertFromOunce();
			break;
		case "kilogram":
			convertFromKiloGram();
			break;
		case "gram":
			convertFromGram();
			break;
		default:
			setConvertedValue(0);
		}
	}
}
