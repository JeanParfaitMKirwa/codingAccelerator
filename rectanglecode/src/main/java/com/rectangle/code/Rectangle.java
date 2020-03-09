/**
 * 
 */
package com.rectangle.code;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author training
 *
 */
public class Rectangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String file1 = args[0];
		File c1 = new File(file1);
		String file2 = args[1];
		File c2 = new File(file2);
		
		RectangleLine rectangle = new RectangleLine();
		List<String> allLines = null;
		List<String> allLinesFile2 = null;
		
		// Lecture du 1er fichier
		try {
			allLines = Files.readAllLines(c1.toPath());
			System.out.println("========= file : " + c1.getName() + " ====");
			for (String line : allLines) {
				rectangle.add(line);
				System.out.println(line);
			}
			System.out.println();
			System.out.println();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// lecture du 2eme fichier
		try {
			allLinesFile2 = Files.readAllLines(c2.toPath());
			System.out.println("========= file : " + c2.getName() + " ====");
			for (String line : allLinesFile2) {
				System.out.println(line);
			}
			System.out.println();
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/** recherche du triangle */
		
		int y, x, xIndex;
		x = -1;
		y = -1;
		xIndex = -1;

		boolean  found = false;

			String line = rectangle.lines.get(0);
			for ( int i = 0 ; i < allLinesFile2.size(); i ++) {
				xIndex = allLinesFile2.get(i).indexOf(line);
				
				
				if (xIndex != -1) {
					found = true;
					y = i;
					x = xIndex;
					for( int index = 1; index < rectangle.lines.size(); index ++) {
						String newLine = rectangle.lines.get(index);
						xIndex = allLinesFile2.get(i+index).indexOf(newLine);
						if (xIndex != -1) {
							found = found && true;
							continue;
						} else {
							found = false;
							break;
						}
					}
					if (found) {
						break;
					}
				} else if (!found){
					continue;
				}
			}
			if ( found) {
				System.out.println("found at (x,y) = (" + x + "," + y +")");
			}
			
	}

}
