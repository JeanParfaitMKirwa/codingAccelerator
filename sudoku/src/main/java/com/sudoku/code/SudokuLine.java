/**
 * 
 */
package com.sudoku.code;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author training
 *
 */
public class SudokuLine implements Comparable<SudokuLine>{
	
	List<String> origine = new ArrayList<String>();
	// ensemble des nombres entier d'une ligne sur lesquels se baser
	SortedSet<Integer> ligneAremplirEnEntierCalcule;
	// coordonnees des underscore
	Map<Integer, String> lesTraitsDansLigne;
	int myID;
	
	public SudokuLine(List<String> line, int id) {
		this.myID = id;
		this.origine = line;
		this.lesTraitsDansLigne = this.chargerIndexDesTrait(line);
		this.ligneAremplirEnEntierCalcule  =  new TreeSet<Integer>(SudokuLine.chargerEnEntier(line));
	}
	
	/**
	 * 
	 * @param origine
	 * @return
	 */
	public static  Set<Integer> chargerEnEntier(List<String> origine) {
		return  origine.stream()
		.filter(SudokuLine::nEstPasUnTrait)
		.map(Integer::parseInt)
		.collect(Collectors.toSet());
	}
	/***
	 *  un predicat pour seulement les nombres entiers
	 *  
	 * @param chiffre
	 * @return
	 */
	public static boolean nEstPasUnTrait(String chiffre) {
		return chiffre.compareTo("_") != 0;
	}
	
	/**
	 * La methode garde les references des caracteres '_'
	 * @param line
	 * @return
	 */
	private Map<Integer, String> chargerIndexDesTrait(List<String> line) {
		Map<Integer, String> lesTraits = new HashMap<Integer, String>();
		for(int i = 0; i < line.size(); i ++) {
			if (line.get(i).compareTo("_")== 0) {
				lesTraits.put(i, "_");
			}
		}
		return lesTraits;
	}

	@Override
	public int compareTo(SudokuLine o) {
		// TODO Auto-generated method stub
		if (this.lesTraitsDansLigne.size() == o.lesTraitsDansLigne.size() ) {
			return 0;
		} else if (this.lesTraitsDansLigne.size() == o.lesTraitsDansLigne.size() ) {
			return 1;
		}
		return -1;
	}

}
