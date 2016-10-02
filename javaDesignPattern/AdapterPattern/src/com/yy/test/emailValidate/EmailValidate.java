package com.yy.test.emailValidate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidate {

	public static void main(String[] args) {
		//String email="572176750@qq.com";
		System.out.println(ValidateEmaiAddress("Y572176750@qq.com"));
		//System.out.println(email.length());

	}

	public static boolean ValidateEmaiAddress(String emailAddress){
		String regex = "[a-zA-Z][0-9a-zA-Z]+@[0-9a-zA-Z]+\\.[0-9a-zA-Z]+";  
        Pattern pattern = Pattern.compile(regex);  
        Matcher matcher = pattern.matcher(emailAddress);  
        
        if(matcher.matches()&&emailAddress.length()>=5){  
        	System.out.println("这是合法的email");
            return true;
        }else{  
            System.out.println("这是非法的Email"); 
            return false;
        }  
		
	}
}

