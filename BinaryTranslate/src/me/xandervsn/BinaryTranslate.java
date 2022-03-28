package me.xandervsn;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class BinaryTranslate {
	
	public BinaryTranslate() {
		System.out.println("Type \"console\" to use console and \"file\" to upload a file.");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		String numInput = "";
		int num = -1;
		
		if(input.equals("file")) {
			try {
				System.out.println("Please enter your file's name");
				input = scanner.nextLine();
				Scanner fileScanner = new Scanner(new File(input));
				numInput = fileScanner.nextLine();
			}catch (IOException ex) {
				System.out.println("Your file was not found");
				scanner.close();
				System.exit(0);
			}
		}else {
			numInput = scanner.nextLine();
		}
		System.out.println("If you are translating from decimal, type \"d\"");
		System.out.println("If you are translating from binary, type \"b\"");
		input = scanner.nextLine();
		if(input.equals("d")) { //decimal input
			int numR = 0;
			num = Integer.parseInt(numInput);
			String answer = "";
			while(num > 0) {
				numR = num % 2;
				if(numR == 1) {
					num = num - 1;
				}
				num = num / 2;
				
				answer = Integer.toString(numR) + answer;
				
			}
			
			System.out.println(answer);
			
		}else { //binary input
			int answer = 0;
			for(int a = numInput.length() - 1; a>= 0; a--) {
				int exponent = numInput.length() - (a+1);
				if(numInput.charAt(a) == '1') {
					
					answer = answer + (int)Math.pow(2, exponent);
				}
				
			}
			System.out.print(answer);
		}
		
			
		scanner.close();
	}

	public static void main(String[] args) {
		new BinaryTranslate();
	}

}
