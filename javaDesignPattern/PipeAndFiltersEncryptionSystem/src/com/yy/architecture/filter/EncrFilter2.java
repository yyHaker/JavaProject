package com.yy.architecture.filter;
import com.yy.architecture.pipe.*;

import java.io.IOException;
import java.io.ObjectOutputStream.PutField;
import java.lang.Character;
/*-------------------------------------------------------
/* Read from the input pipe, character by character.
/* Encrypt the chars by using Encryption Algorithm 2 (分组互换算法).
/* Precondition: a text file to be encrypted contains only
/* English characters and digital numbers. The algorithm is:
/*       a<-->b, c<-->d, e<-->f, ,..., y<-->z
/*       0<-->1, 2<-->3, ...8<-->9
/* Upper case letters are also encrypted the same way
/* (Upper case letters are encrypted into Upper case letters) .
/* The encrypted chars are written to the sink pipe char by char
/*------------------------------------------------------*/

public class EncrFilter2 extends Filter{
	 private char[][] coupledLowerCaseChar = new char[13][2];
	 private char[][] coupledUpperCaseChar = new char[13][2];
   public EncrFilter2(Pipe input, Pipe output){
      super(input, output);
      coupledLowerCaseChar = createCoupledCharArr("lowerCase");
      coupledUpperCaseChar = createCoupledCharArr("upperCase");
   }

   protected void processData(){

      try{
         int c = inPipe.read(); // Read a character from the source pipe

         while(c != -1){ //not end of file
            char f = (char)c;
			char e = encrypt(f); // to encrypt a character
			outPipe.write(e);  // Write character 'e' to the sink pipe
            c = inPipe.read();
         }
         outPipe.closePipedOutputStream();
         inPipe.closePipedInputStream();
      }
      catch(IOException exc){
         exc.printStackTrace();
         System.err.println("Error: failed encryption 2");
         System.exit(1);
      }
   }
   /**
    * 分组互换算法加密一个字符
    *@description 
    *@param EncrFilter2
    *@return char
    * @param c
    * @return
    */
   private char encrypt(char inChar){
	   char outChar=inChar;
	  System.out.println("\n original char: "+ inChar);
	  
	  if(Character.isLetter(inChar)){
		   outChar=shiftChar(inChar);
	   }else if(Character.isDigit(inChar)){
		   outChar=shiftNum(inChar);
	   }
	    
	   System.out.println("Encrypted char: " + outChar);  
	   return outChar;
   }
   
   private char[][] createCoupledCharArr(String style){
	    String lowerStr = "abcdefghijklmnopqrstuvwxyz";
	    String upperStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    char[] lowerCharArr = lowerStr.toCharArray();
	    char[] upperCharArr = upperStr.toCharArray();
	    char[][] coupledCharArr = new char[13][2];

	    if(style.equals("lowerCase") ) {
	    	for(int m=0; m<13; m++){
				coupledCharArr[m][0] = lowerCharArr[2*m];
				coupledCharArr[m][1] = lowerCharArr[2*m+1];
			}
	    }
	    if(style.equals("upperCase") ) {
			for(int m=0; m<13; m++){
				coupledCharArr[m][0] = upperCharArr[2*m];
				coupledCharArr[m][1] = upperCharArr[2*m+1];
			}
	    }
	    return coupledCharArr;
  }
   private char shiftNum(char intputNum){
       char[][] num = new char[5][2];
       num[0] [0]= '0';
       num[0] [1]= '1';
       num[1] [0]= '2';
       num[1] [1]= '3';
       num[2] [0]= '4';
       num[2] [1]= '5';
       num[3] [0]= '6';
       num[3] [1]= '7';
       num[4] [0]= '8';
       num[4] [1]= '9';

       char shiftedNum = '1';
       for(int m=0; m<5; m++){
         if( intputNum == num[m][0] )
             shiftedNum = num[m][1];
         else if( intputNum == num[m][1] )
             shiftedNum = num[m][0];
  	 }
  	 return shiftedNum;
  }
   private char shiftChar(char aChar){
	    char inChar = aChar;
       char outChar = 'a';

	    if(Character.isLowerCase(inChar)==true){
	    	for(int m=0; m<13; m++){
				if( coupledLowerCaseChar[m][0] == inChar)
				    outChar = coupledLowerCaseChar[m][1];
				else if(coupledLowerCaseChar[m][1] == inChar )
				    outChar = coupledLowerCaseChar[m][0];
			}
		}
		if(Character.isUpperCase(inChar)==true){
			for(int m=0; m<13; m++){
				if( coupledUpperCaseChar[m][0] == inChar)
					outChar = coupledUpperCaseChar[m][1];
				else if(coupledUpperCaseChar[m][1] == inChar )
					outChar = coupledUpperCaseChar[m][0];
			}
		}
		return outChar;
  }
   
}


