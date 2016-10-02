package com.yy.pattern.facade;

public class StringOperations {

	  /*======================================*/
	  /* Get rid of all the spaces from the user input      */
	  /*======================================*/
	  public static char[] toNonBlankCharArray(String postalCode){
		   int m=0;

		   for (int k=0;k<postalCode.length(); k++){
				 if (Character.isSpaceChar(postalCode.charAt(k)) == false ){
					m++;
				 }
		   }
		   char[] p = new char[m];
		   int n = 0;
		   for (int k=0;k<postalCode.length(); k++){
			   if (Character.isSpaceChar(postalCode.charAt(k)) == false ){
					p[n] =  postalCode.charAt(k);
					n++;
			   }
		   }
		   return p;
	   }

	   public static boolean checkDigits( char[] charArr ){
		     boolean flag = false;
			 int len = charArr.length;
			 int m = 0;
			 for(int i=0; i<len; i++)
				  if (Character.isDigit(charArr[i]) == true){
					   m++;
				  }
				  if(m==len)
					   flag = true;
				 return flag;
	  }
 }