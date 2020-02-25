package com.coding.escalier.accelerator;

import java.util.Collections;

public class Escalier {

	public static void main(String[] args) {

		//Declaration et acquisition de la valeur argument de l'application
		int longueur = Integer.parseInt(args[0]);
		String caractere ="#";
		String ligne = String.join("", Collections.nCopies(longueur," ")) + caractere;
		
		// Affichage
		for( int i = 0 ; i < longueur; i++ ) {
			ligne = String.join("", Collections.nCopies(longueur - i ," ")) + 
					String.join("", Collections.nCopies( i+1 , caractere));
			System.out.println(ligne);
		}
	}

}
