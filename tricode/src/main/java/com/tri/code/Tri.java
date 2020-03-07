/**
 * 
 */
package com.tri.code;

import java.util.ArrayList;
import java.util.Collections;
/**
 * @author training
 *
 */
public class Tri {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> lesChiffres = new ArrayList<Integer>();
		
		for (String chiffre : args) {
			lesChiffres.add(Integer.parseInt(chiffre));
		}
		
		System.out.println(lesChiffres);
		Collections.sort(lesChiffres);
		System.out.println(lesChiffres);

	}

}
