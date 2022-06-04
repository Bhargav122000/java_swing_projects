package com.bhargav.converter.cli;

public class LengthConversion extends Conversion {

	public void convertFromMilliMetre() {
		double num1 = getValue();
		switch (getConvertUnitTo()) {
		case "millimetre":
			setConvertedValue(num1 * 1.0);
			break;
		case "centimetre":
			setConvertedValue(num1 * 0.1);
			break;
		case "metre":
			setConvertedValue(num1 * 0.001);
			break;
		case "kilometre":
			setConvertedValue(num1 * 0.000001);
			break;
		case "inch":
			setConvertedValue(num1 * 0.0393700787);
			break;
		case "foot":
			setConvertedValue(num1 * 0.0032808399);
			break;
		case "yard":
			setConvertedValue(num1 * 0.0010936133);
			break;
		case "mile":
			setConvertedValue(num1 * 0.0000006214);
			break;
		default:
			setConvertedValue(0);
		}
	}

	public void convertFromCentiMetre() {
		double num1 = getValue();
		switch (getConvertUnitTo()) {
		case "millimetre":
			setConvertedValue(num1 * 10.0);
			break;
		case "centimetre":
			setConvertedValue(num1 * 1.0);
			break;
		case "metre":
			setConvertedValue(num1 * 0.01);
			break;
		case "kilometre":
			setConvertedValue(num1 * 0.00001);
			break;
		case "inch":
			setConvertedValue(num1 * 0.3937007874);
			break;
		case "foot":
			setConvertedValue(num1 * 0.032808399);
			break;
		case "yard":
			setConvertedValue(num1 * 0.010936133);
			break;
		case "mile":
			setConvertedValue(num1 * 0.0000062137);
			break;
		default:
			setConvertedValue(0);
		}
	}

	public void convertFromMetre() {
		double num1 = getValue();
		switch (getConvertUnitTo()) {
		case "millimetre":
			setConvertedValue(num1 * 1000.0);
			break;
		case "centimetre":
			setConvertedValue(num1 * 100.0);
			break;
		case "metre":
			setConvertedValue(num1 * 1.0);
			break;
		case "kilometre":
			setConvertedValue(num1 * 0.001);
			break;
		case "inch":
			setConvertedValue(num1 * 39.3700787402);
			break;
		case "foot":
			setConvertedValue(num1 * 3.280839895);
			break;
		case "yard":
			setConvertedValue(num1 * 1.0936132983);
			break;
		case "mile":
			setConvertedValue(num1 * 0.0006213712);
			break;
		default:
			setConvertedValue(0);
		}
	}

	public void convertFromKiloMetre() {
		double num1 = getValue();
		switch (getConvertUnitTo()) {
		case "millimetre":
			setConvertedValue(num1 * 1000000.0);
			break;
		case "centimetre":
			setConvertedValue(num1 * 100000.0);
			break;
		case "metre":
			setConvertedValue(num1 * 1000.0);
			break;
		case "kilometre":
			setConvertedValue(num1 * 1.0);
			break;
		case "inch":
			setConvertedValue(num1 * 39370.078740157);
			break;
		case "foot":
			setConvertedValue(num1 * 3280.8398950131);
			break;
		case "yard":
			setConvertedValue(num1 * 1093.6132983377);
			break;
		case "mile":
			setConvertedValue(num1 * 0.6213711922);
			break;
		default:
			setConvertedValue(0);
		}
	}

	public void convertFromInch() {
		double num1 = getValue();
		switch (getConvertUnitTo()) {
		case "millimetre":
			setConvertedValue(num1 * 25.4);
			break;
		case "centimetre":
			setConvertedValue(num1 * 2.54);
			break;
		case "metre":
			setConvertedValue(num1 * 0.0254);
			break;
		case "kilometre":
			setConvertedValue(num1 * 0.0000254);
			break;
		case "inch":
			setConvertedValue(num1 * 1.0);
			break;
		case "foot":
			setConvertedValue(num1 * 0.0833333333);
			break;
		case "yard":
			setConvertedValue(num1 * 0.0277777778);
			break;
		case "mile":
			setConvertedValue(num1 * 0.0000157828);
			break;
		default:
			setConvertedValue(0);
		}
	}

	public void convertFromFoot() {
		double num1 = getValue();
		switch (getConvertUnitTo()) {
		case "millimetre":
			setConvertedValue(num1 * 304.8);
			break;
		case "centimetre":
			setConvertedValue(num1 * 30.48);
			break;
		case "metre":
			setConvertedValue(num1 * 0.3048);
			break;
		case "kilometre":
			setConvertedValue(num1 * 0.0003048);
			break;
		case "inch":
			setConvertedValue(num1 * 12.0);
			break;
		case "foot":
			setConvertedValue(num1 * 1.0);
			break;
		case "yard":
			setConvertedValue(num1 * 0.3333333333);
			break;
		case "mile":
			setConvertedValue(num1 * 0.0001893939);
			break;
		default:
			setConvertedValue(0);
		}
	}

	public void convertFromYard() {
		double num1 = getValue();
		switch (getConvertUnitTo()) {
		case "millimetre":
			setConvertedValue(num1 * 914.4);
			break;
		case "centimetre":
			setConvertedValue(num1 * 91.44);
			break;
		case "metre":
			setConvertedValue(num1 * 0.9144);
			break;
		case "kilometre":
			setConvertedValue(num1 * 0.0009144);
			break;
		case "inch":
			setConvertedValue(num1 * 36.0);
			break;
		case "foot":
			setConvertedValue(num1 * 3.0);
			break;
		case "yard":
			setConvertedValue(num1 * 1.0);
			break;
		case "mile":
			setConvertedValue(num1 * 0.0005681818);
			break;
		default:
			setConvertedValue(0);
		}
	}

	public void convertFromMile() {
		double num1 = getValue();
		switch (getConvertUnitTo()) {
		case "millimetre":
			setConvertedValue(num1 * 1609344);
			break;
		case "centimetre":
			setConvertedValue(num1 * 160934.4);
			break;
		case "metre":
			setConvertedValue(num1 * 1609.344);
			break;
		case "kilometre":
			setConvertedValue(num1 * 1.609344);
			break;
		case "inch":
			setConvertedValue(num1 * 63360);
			break;
		case "foot":
			setConvertedValue(num1 * 5280);
			break;
		case "yard":
			setConvertedValue(num1 * 1760);
			break;
		case "mile":
			setConvertedValue(num1 * 1.0);
			break;
		default:
			setConvertedValue(0);
		}
	}

	public void convert() {
		switch (getConvertUnitFrom()) {
		case "millimetre":
			convertFromMilliMetre();
			break;
		case "centimetre":
			convertFromCentiMetre();
			break;
		case "metre":
			convertFromMetre();
			break;
		case "kilometre":
			convertFromKiloMetre();
			break;
		case "inch":
			convertFromInch();
			break;
		case "foot":
			convertFromFoot();
			break;
		case "yard":
			convertFromYard();
			break;
		case "mile":
			convertFromMile();
			break;
		default:
			setConvertedValue(0);
		}
	}
}
