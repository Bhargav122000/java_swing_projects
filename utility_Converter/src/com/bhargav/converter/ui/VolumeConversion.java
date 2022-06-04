package com.bhargav.converter.ui;

public class VolumeConversion extends Conversion {
	
	public void convertFromGallon() {
		double num1 = getValue();
		switch (getConvertUnitTo()) {
		case "gallon":
			setConvertedValue(num1 * 1.0);
			break;
		case "litre":
			setConvertedValue(num1 * 4.54609);
			break;
		case "milliletre":
			setConvertedValue(num1 * 4546.09);
			break;
		case "cubic centimetre":
			setConvertedValue(num1 * 4546.09);
			break;
		case "cubic metre":
			setConvertedValue(num1 * 0.00454609);
			break;
		case "cubic inch":
			setConvertedValue(num1 * 277.4194327916);
			break;
		case "cubic foot":
			setConvertedValue(num1 * 0.1605436532);
			break;
		default:
			setConvertedValue(0);
		}
	}

	public void convertFromLitre() {
		double num1 = getValue();
		switch (getConvertUnitTo()) {
		case "gallon":
			setConvertedValue(num1 * 0.2199692483);
			break;
		case "litre":
			setConvertedValue(num1 * 1.0);
			break;
		case "milliletre":
			setConvertedValue(num1 * 1000.0);
			break;
		case "cubic centimetre":
			setConvertedValue(num1 * 1000.0);
			break;
		case "cubic metre":
			setConvertedValue(num1 * 0.001);
			break;
		case "cubic inch":
			setConvertedValue(num1 * 61.0237440947);
			break;
		case "cubic foot":
			setConvertedValue(num1 * 0.0353146667);
			break;
		default:
			setConvertedValue(0);
		}
	}

	public void convertFromMilliLetre() {
		double num1 = getValue();
		switch (getConvertUnitTo()) {
		case "gallon":
			setConvertedValue(num1 * 0.0002199692);
			break;
		case "litre":
			setConvertedValue(num1 * 0.001);
			break;
		case "milliletre":
			setConvertedValue(num1 * 1.0);
			break;
		case "cubic centimetre":
			setConvertedValue(num1 * 1.0);
			break;
		case "cubic metre":
			setConvertedValue(num1 * 0.000001);
			break;
		case "cubic inch":
			setConvertedValue(num1 * 0.0610237441);
			break;
		case "cubic foot":
			setConvertedValue(num1 * 0.0000353147);
			break;
		default:
			setConvertedValue(0);
		}
	}

	public void convertFromCubicCentiMetre() {
		double num1 = getValue();
		switch (getConvertUnitTo()) {
		case "gallon":
			setConvertedValue(num1 * 0.0002199692);
			break;
		case "litre":
			setConvertedValue(num1 * 0.001);
			break;
		case "milliletre":
			setConvertedValue(num1 * 1.0);
			break;
		case "cubic centimetre":
			setConvertedValue(num1 * 1.0);
			break;
		case "cubic metre":
			setConvertedValue(num1 * 0.000001);
			break;
		case "cubic inch":
			setConvertedValue(num1 * 0.0610237441);
			break;
		case "cubic foot":
			setConvertedValue(num1 * 0.0000353147);
			break;
		default:
			setConvertedValue(0);
		}
	}

	public void convertFromCubicMetre() {
		double num1 = getValue();
		switch (getConvertUnitTo()) {
		case "gallon":
			setConvertedValue(num1 * 219.9692482991);
			break;
		case "litre":
			setConvertedValue(num1 * 1000.0);
			break;
		case "milliletre":
			setConvertedValue(num1 * 1000000.0);
			break;
		case "cubic centimetre":
			setConvertedValue(num1 * 1000000.0);
			break;
		case "cubic metre":
			setConvertedValue(num1 * 1.0);
			break;
		case "cubic inch":
			setConvertedValue(num1 * 61023.744094732);
			break;
		case "cubic foot":
			setConvertedValue(num1 * 35.3146667215);
			break;
		default:
			setConvertedValue(0);
		}
	}

	public void convertFromCubicInch() {
		double num1 = getValue();
		switch (getConvertUnitTo()) {
		case "gallon":
			setConvertedValue(num1 * 0.0036046501);
			break;
		case "litre":
			setConvertedValue(num1 * 0.016387064);
			break;
		case "milliletre":
			setConvertedValue(num1 * 16.387064);
			break;
		case "cubic centimetre":
			setConvertedValue(num1 * 16.387064);
			break;
		case "cubic metre":
			setConvertedValue(num1 * 0.0000163871);
			break;
		case "cubic inch":
			setConvertedValue(num1 * 1.0);
			break;
		case "cubic foot":
			setConvertedValue(num1 * 0.0005787037);
			break;
		default:
			setConvertedValue(0);
		}
	}

	public void convertFromCubicFoot() {
		double num1 = getValue();
		switch (getConvertUnitTo()) {
		case "gallon":
			setConvertedValue(num1 * 6.228835459);
			break;
		case "litre":
			setConvertedValue(num1 * 28.316846592);
			break;
		case "milliletre":
			setConvertedValue(num1 * 28316.846592);
			break;
		case "cubic centimetre":
			setConvertedValue(num1 * 28316.846592);
			break;
		case "cubic metre":
			setConvertedValue(num1 * 0.0283168466);
			break;
		case "cubic inch":
			setConvertedValue(num1 * 1728);
			break;
		case "cubic foot":
			setConvertedValue(num1 * 1.0);
			break;
		default:
			setConvertedValue(0);
		}
	}

	public void convert() {
		switch (getConvertUnitFrom()) {
		case "gallon":
			convertFromGallon();
			break;
		case "litre":
			convertFromLitre();
			break;
		case "milliletre":
			convertFromMilliLetre();
			break;
		case "cubic centimetre":
			convertFromCubicCentiMetre();
			break;
		case "cubic metre":
			convertFromCubicMetre();
			break;
		case "cubic inch":
			convertFromCubicInch();
			break;
		case "cubic foot":
			convertFromCubicFoot();
			break;
		default:
			setConvertedValue(0);
		}
	}
}
