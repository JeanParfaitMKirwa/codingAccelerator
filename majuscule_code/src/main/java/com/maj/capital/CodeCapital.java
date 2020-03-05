package com.maj.capital;


public class CodeCapital {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String result = "";
		String[] stringArray = args[0].split(" ");
		
		for (String line : stringArray) {
			
			line = line.toLowerCase();
			
			for (int i = 0; i < line.length(); i++) {
				if ((i > 0) && (i % 2 != 0)) {
					char caractere = Character.toUpperCase(line.charAt(i));
					result = result + caractere;
				} else {
					result = result + line.charAt(i);
				}
			}
			result = result + " ";
		}
		System.out.println(result);
	}

}
