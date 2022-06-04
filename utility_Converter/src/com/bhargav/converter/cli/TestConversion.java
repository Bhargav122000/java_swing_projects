package com.bhargav.converter.cli;

import java.util.*;

public class TestConversion {

	public static void main(String[] args) {
		Conversion conversion = null;
		Scanner scanner = new Scanner(System.in);
		
		try {
			System.out.println("[area data length mass temperature volume]");
			System.out.println("Enter the measurement:");
			String measurement = scanner.nextLine();
			if (measurement.equalsIgnoreCase("area")) {
				conversion = new AreaConversion();
			} else if (measurement.equalsIgnoreCase("data")) {
				conversion = new DataConversion();
			} else if (measurement.equalsIgnoreCase("length")) {
				conversion = new LengthConversion();
			} else if (measurement.equalsIgnoreCase("mass")) {
				conversion = new MassConversion();
			} else if (measurement.equalsIgnoreCase("temperature")) {
				conversion = new TemperatureConversion();
			} else if (measurement.equalsIgnoreCase("volume")) {
				conversion = new VolumeConversion();
			} else {
				throw new Exception();
			}
			
			System.out.println("Enter the unit to convert:");
			conversion.setConvertUnitFrom(scanner.nextLine());
			System.out.println("Enter the unit to be converted into:");
			conversion.setConvertUnitTo(scanner.nextLine());
			System.out.println("Enter the value to convert:");
			conversion.setValue(Double.parseDouble(scanner.nextLine()));
			conversion.convert();
			System.out.println(conversion.getConvertedValue());
		} catch (NumberFormatException e) {
			System.out.println("Invalid value to convert...");
		} catch (Exception e) {
			System.out.println("Invalid measurement...");
		} finally {
			scanner.close();
		}
	}

}
