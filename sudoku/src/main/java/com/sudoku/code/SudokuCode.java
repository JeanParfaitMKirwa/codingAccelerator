/**
 * 
 */
package com.sudoku.code;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author training
 *
 */
public class SudokuCode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// declarations
		
		// lignes de sudoku en état brut 
		List<String> allLines = null;
		//table de sudoku
		SudokuTable sudoku = new SudokuTable();
		// lignes de sudoku ayant plusieurs traits
		List<SudokuLine> ligneMultiplesTraits = new ArrayList<SudokuLine>();
		
		
		// le fichier entré en argument
		String sudokuFile = args[0];
		File s = new File(sudokuFile);


		
		// Lecture du fichier en argument  et resolution des lignes simple
		try {
			allLines = Files.readAllLines(s.toPath());
			System.out.println("========= file : " + s.getName() + " ====");
			int i = 0;
			for (String line : allLines) {
				System.out.println(line);
				List<String> aLine = new ArrayList<String>();
				if (!line.startsWith("-")) {
					aLine.add(line.substring(0, 1));
					aLine.add(line.substring(1, 2));
					aLine.add(line.substring(2, 3));
					aLine.add(line.substring(4, 5));
					aLine.add(line.substring(5, 6));
					aLine.add(line.substring(6, 7));
					aLine.add(line.substring(8, 9));
					aLine.add(line.substring(9, 10));
					aLine.add(line.substring(10, 11));
					sudoku.lesLignes[i] = new SudokuLine(aLine, i);
					// resolution des lignes à un seul trait
					if (sudoku.lesLignes[i].lesTraitsDansLigne.keySet().toArray().length == 1) {
						sudoku.resoudreLigne(i);
					} else if (sudoku.lesLignes[i].lesTraitsDansLigne.keySet().toArray().length == 2) {
						// garder les lignes à traits multiple
						ligneMultiplesTraits.add(sudoku.lesLignes[i]);
					}
					i++;
				}
			}
			
			// resolution des cas compliques exemple: lignes à 2 traits
			ligneMultiplesTraits.stream().forEach(sudoku::resoudreEnVertical);
			
			System.out.println();
			System.out.println();
			sudoku.afficherResultat();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
