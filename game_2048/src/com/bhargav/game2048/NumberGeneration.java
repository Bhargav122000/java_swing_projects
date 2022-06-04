package com.bhargav.game2048;
import java.util.Random;

public class NumberGeneration {

	public static void main(String[] args) {
		System.out.println("Welcome to the Number Generation phase...");
		
		Random random = new Random();
		int numberGenerated;
		if(random.nextBoolean() == true) {
			numberGenerated = 2;
		}else {
			numberGenerated = 4;
		}
		System.out.println("The number generated is: " + numberGenerated);
	}

}
