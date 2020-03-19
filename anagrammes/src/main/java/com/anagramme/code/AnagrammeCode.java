/**
 * 
 */
package com.anagramme.code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import java.nio.file.Files;
import java.io.File;
import java.io.IOException;
/**
 * @author training
 *
 */
public class AnagrammeCode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String motArgument =args[0];
		String fichierArgument = args[1];
		
		File fichier = new File(fichierArgument);
		List<String> lesMots = new ArrayList();
		List<String> allLines = null;
		
		try {
			/** lecture du fichier **/
			allLines = Files.readAllLines(fichier.toPath());
			System.out.println("========= file : " + fichier.getName() + " ====");

			/**preparer un set pour le mot passé en argument **/
			Set<Character> setDesCharsMotArgument = new HashSet<Character>();
			Stream<Character> leschars = motArgument.codePoints().mapToObj(c -> (char) c);
			leschars.forEach(setDesCharsMotArgument::add);

			for (String line : allLines) {
				System.out.println(line);
				if (line.length() == motArgument.length()) {
					/**preparer un set pour le mot du fichier **/
					Set<Character> lineCharsSet = new HashSet<Character>();
					Stream<Character> lesCharsLine = line.codePoints().mapToObj(c -> (char) c);
					lesCharsLine.forEach(lineCharsSet::add);
					/**comparer les set  mot en argument et le mot du chier**/
					if (lineCharsSet.containsAll(setDesCharsMotArgument)) {
						lesMots.add(line);
					}
				}
			}
			System.out.println();
			System.out.println();
			System.out.println("=============== RESULTAT =====================");
			System.out.println();
			System.out.println();
			System.out.println(lesMots);
			System.out.println();
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
