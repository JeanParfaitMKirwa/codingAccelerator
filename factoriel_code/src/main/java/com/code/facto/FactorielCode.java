/**
 * 
 */
package com.code.facto;

/**
 * @author training
 *
 */
public class FactorielCode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int argument = Integer.parseInt(args[0]);
		long result = 1;
		for (int i = argument; i > 0 ; i--) {
			if (i == 1) {
				result = result * 1 ;
			} else {
				result = result * i;
			}
			
		}
		System.out.println(result);
	}

}
