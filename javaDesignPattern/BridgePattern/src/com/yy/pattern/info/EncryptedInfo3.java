package com.yy.pattern.info;

import com.yy.pattern.writer.MessageWriter;

/*------------------------------------------------------------------*/
/*新添加的加密算法
/* 
/*To encrypt a word, we replace the letter a with b, b with c, and so on, up to z,
/*  which is replaced by a. This is called the rotate-1 Caesar cipher. When a digital
/*   number between 0 and 9 is encountered, the rule to rotate is 01, 12,…,8
/*   9 and 90.
/*
/*--------------------------------------------------------------------*/
public class EncryptedInfo3 extends AgentInfo {
private MessageWriter writer;
 public EncryptedInfo3(MessageWriter I) {
   writer=I;
}
	@Override
	public void log(String lastNm, String firstNm, String code) {
		if( isValidAgentName(lastNm) == false ||  isValidAgentName(firstNm) == false    ){
   		    System.out.println("Invalid agent name. Only English characters are allowed.");
   	        System.exit(1);
	}
	if( isValidCode(code) == false){
		    System.out.println("Invalid agent code. Only English characters and numbers are allowed.");
		   	System.exit(1);
	}

  String fName = encryptName(firstNm);
  String lName = encryptName(lastNm);

  String codeStr = encryptCode(code);
  writer.logMsg(lName, fName, codeStr);

	}
	
	//this method can be used to encrypt the first name or last name
	public String encryptName(String msg){
		System.out.println("\n Agent name: "+msg);
		char[] alphabet=getAlphabetArray();
		char[] chars=msg.toCharArray();
		
		for(int m=0;m<chars.length;m++){
		    for(int n=0;n<26;n++){
		    	if(chars[m]==alphabet[n]){
		    		chars[m]=alphabet[(n+1)%26];
		    		break;
		    	}else if(chars[m]==Character.toUpperCase(alphabet[n])){
		    		chars[m]=Character.toUpperCase(alphabet[(n+1)%26]);
		    		break;
		    	}
		    }
		}
		System.out.println("Encrypted agent name: "+new String(chars));
		return new String(chars);
	}
   //this method can be used to encrypt the agent code 
	public String encryptCode(String code){
		 System.out.println("Agent code: "+ code);
		 char[] digitArr = getDigitArray();
		  char[] codeChars = code.toCharArray();
		  char[] alphabet = getAlphabetArray();

		  if(codeChars.length != 12){
		     System.out.println("Incorrect code length.");
		  }else{
			  for(int m=0;m<codeChars.length;m++){
				    for(int n=0;n<26;n++){
				    	if(codeChars[m]==alphabet[n]){
				    		codeChars[m]=alphabet[(n+1)%26];
				    		break;
				    	}else if(codeChars[m]==Character.toUpperCase(alphabet[n])){
				    		codeChars[m]=Character.toUpperCase(alphabet[(n+1)%26]);
				    		break;
				    	}
				    }
				    
				    for(int j=0;j<10;j++){
				    	if(codeChars[m]==digitArr[j]){
				    		codeChars[m]=digitArr[(j+1)%10];
				    		break;
				    	}
				    }
				}
		  }
		  System.out.println("Encrypted agent code: "+new String(codeChars));
		return new String(codeChars);
	}
	
	private char[] getAlphabetArray(){
	       String str = "abcdefghijklmnopqrstuvwxyz";
		   char[] chArray = str.toCharArray();
		   return chArray;
	  }
	  private char[] getDigitArray(){
	       String str = "0123456789";
	  	   char[] chArray = str.toCharArray();
	  	   return chArray;
	  }
}
