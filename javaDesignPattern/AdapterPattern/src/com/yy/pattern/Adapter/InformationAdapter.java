package com.yy.pattern.Adapter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.yy.pattern.face.*;
/*---------------------------------------------------------*/
/* This adapter class extends InfoValidation and           */
/* implements CusInfoValidator, and so the first           */
/* 4 functionalities listed in class CusInfoValidator      */
/* are automatically inherited from class InfoValidation,  */
/* and in this addapter class, isValidSSNNum(String SSNNum)*/
/* is emplemented.                                         */
/*---------------------------------------------------------*/


public class InformationAdapter extends InfoValidation implements CusInfoValidator{

    /*------------------------------------------*/
	/* The Social Security number is a 9-digit  */
	/* number in the format "AAA-GG-SSSS".      */
	/*------------------------------------------*/
	public boolean isValidSSNNum(String SSNNum){
	   boolean isValid=true;
	   if(SSNNum.length() == 0){
		      isValid = false;
		      System.out.println("Empty string ***");
	   }
	   else{
			   String ns = SSNNum.trim();
			   String nStr = ns.replaceAll("\\s{1,}", "");
			   int len = nStr.length();

			   if ( (len==11) && (nStr.charAt(3) == '-') && (nStr.charAt(6) == '-')  ) {
				  for(int m=0; m<len; m++){
					    if(  (m != 3) && (m !=6) && ( Character.isDigit(nStr.charAt(m))==false) ){
					    	isValid=false;
					    }
				  }
			   }
			   else{
				  isValid=false;
			   }
	   }
	   return  isValid;
    }
     //实现校验email的功能
	@Override
	public boolean isValidEmailAddr(String emailAddr) {
		boolean isValid=true;
		if (emailAddr.length()==0) {
			 isValid=false;
			 System.out.println("Empty string ***");
		}else{
			String email=emailAddr.trim();
			 /**
			  * 利用正则表达式进行校验
			  * email格式要求
			  * 1.由26个英文字母和0-9等数字组成，必须有一个@,至少有一个.
			  * 2.首位必须是英文字母
			  * 3.email地址的长度至少为5
			  * 例如:yy572176950@qq.com
			  */
			String regex = "[a-zA-Z][0-9a-zA-Z]+@[0-9a-zA-Z]+\\.[0-9a-zA-Z]+";  
	        Pattern pattern = Pattern.compile(regex);  
	        Matcher matcher = pattern.matcher(email);  
	        
	        if(matcher.matches()&&email.length()>=5){  
	        	//System.out.println("这是合法的email");
	            isValid=true;
	        }else{  
	            //System.out.println("这是非法的Email"); 
	           // return false;
	        	isValid=false;
	        }  
			
			
		}
		return isValid;
	}
}


