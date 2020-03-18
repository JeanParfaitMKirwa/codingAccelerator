/**
 * 
 */
package com.sudoku.code;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author training
 *
 */
public class SudokuTable {
	SudokuLine[] lesLignes = new SudokuLine[9];
	final int[] a = {1,2,3,4,5,6,7,8,9};
	final int mustHaveSum = IntStream.of(a).sum();
	
	public SudokuTable() {
		
	}
	/**
	 * Resoudre une ligne dont un seul chiffre manque
	 * @param id
	 * @return
	 */
	public int resoudreLigne(int id) {
		SudokuLine ligne = this.lesLignes[id];
		int sommeTemporaire = ligne.ligneAremplirEnEntierCalcule
				.stream()
				.collect(Collectors.summingInt(Integer::intValue));
		int difference = mustHaveSum - sommeTemporaire;
		try {
//			System.out.println(" for id =" + id);
//			System.out.println("position =" + ligne.lesTraitsDansLigne.keySet().toArray()[0]);
//			System.out.println(" the difference is = " + difference);
			ligne.origine.set((Integer)ligne.lesTraitsDansLigne.keySet().toArray()[0],
					""+difference);
//			System.out.println(" result of id = " + id + " => " + difference);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		return 0;
	}
	
	/****
	 * Affichage de resultat
	 */
	public void afficherResultat() {
		System.out.println("=====================RESULTAT=================");
		System.out.println();
		System.out.println();
		for (int i = 0; i < this.lesLignes.length; i++) {

			if (!Arrays.asList(3, 6).contains(i)) {
				afficherLigne(i);
			} else {
				for (int j = 0; j < 11; j++) {
					System.out.print("+");
				}
				System.out.println();
				afficherLigne(i);
			}
			System.out.println();
		}
	}
	
	public void resoudreEnVertical(SudokuLine sudokuLine) {
		SudokuLine ligne = this.lesLignes[sudokuLine.myID];

		ligne.lesTraitsDansLigne.forEach((k, v) -> {
			int somme = 0;
			// faire une somme des lignes verticales
			for (int i = 0; i < lesLignes.length; i++) {
				if ( i != ligne.myID) {
					somme = somme + Integer.parseInt(this.lesLignes[i].origine.get(k));
				}
			}
			// deduire le chiffre restant à ajouter dans la ligne
			int difference = this.mustHaveSum - somme;
			ligne.origine.set(k, "" + difference);
		});

	}
	
	
	private void afficherLigne(int indexLigne) {
		int integerArray[] = new int[9];

		for (int y = 0; y < this.lesLignes[indexLigne].origine.size(); y++) {
			integerArray[y] = Integer.parseInt(this.lesLignes[indexLigne].origine.get(y));
		}

		for (int j = 0; j < integerArray.length; j++) {
			if (Arrays.asList(3, 6).contains(j)) {
				System.out.print("|");
			}
			if (this.lesLignes[indexLigne].lesTraitsDansLigne.containsKey(j)) {
				System.out.print((char)27 +"[33m" + integerArray[j]);
			} else {
				System.out.print((char)27 + "[0m" + integerArray[j]);
			}
		}
	}

}
