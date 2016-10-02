package com.yy.pattern.infor;

import com.yy.pattern.facade.FileIoOperations;
import com.yy.pattern.facade.StringOperations;

public class Address {
	  String address;
	  String city;
	  String state;
	  String zipCode;

 final String ADDRESS_DATA_FILE = "AddressInfo.txt";
 final int ZIPCODE_LEN = 9;

 //constructor of address
  //public Address(String add, String cty, String st, String zip) {
 public Address(String add, String cty, String st ,String zip) {
		address = add;
		city = cty;
		state = st;
		//添加的成员变量
	    zipCode = zip;
  }

  //检验所填的信息是否有效
  public boolean isValid() {
	    boolean flag = false;

	    if( (isValidUsrAdress() == true)&&
	        (isValidCityName() == true)&&
	        (isValidState() == true)&&
	        (isValidUSZipCode()==true)){
	             flag = true;
	    }
        return flag;
  }

  //save the user input to adress file
  public boolean save() {
    FileIoOperations fio = new FileIoOperations();
    String dataLine = getAddress() + "," + getCity() + "," +
                      getState()+","+getZipCode();
    return fio.writeToFile(ADDRESS_DATA_FILE, dataLine,
           true, true);
  }

  public String getAddress() {
    return address;
  }
  public String getCity() {
    return city;
  }
  public String getState() {
    return state;
  }
  public String getZipCode(){
	  return zipCode;
  }

  //=============================================
  // 1) the adress input should not be empty
  // 2) the adress should contain at least 1 English character
  //=============================================
  public boolean isValidUsrAdress(){
    	    boolean flag = false;

    		if( address.length() == 0){
  		     return flag;
  	    }
  	    else{
  			for(int i = 0; i < address.length(); i++){
  				if( Character.isLetter(address.charAt(i)) == true)
  					 flag = true;
  			    }
  			return flag;
  	    }
  }
  //=============================================
  // 1) the adress input should not be empty
  // 2) the adress should contain at least 1 English character
  //=============================================
    public boolean isValidCityName(){
    	    boolean flag = false;

    		if( address.length() == 0){
  		         return flag;
  	        }
  	        else{
  			   for(int i = 0; i < address.length(); i++){
  				   if( Character.isLetter(address.charAt(i)) == true)
  					    flag = true;
  			       }
  			   return flag;
  	        }
    }

  // =============================================
  // Only the 50 US state and their abbrevate forms are legal
  //=============================================
  public boolean isValidState(){
	    boolean flag = false;
		String USState[] = { "AL","Alabama","AK","Alaska","AZArizona","AR","Arkansas",
									   "CA","California","CO","Colorado","CT","Connecticut","DE","Delaware",
									   "DE","Delaware","FL","Florida","GA","Georgia","HI","Hawaii","ID","Idaho",
									   "IL","Illinois","IN","Indiana","IA","Iowa","KS","Kansas","KY","Kentucky",
									   "LA","Lousiana","ME","Maine","MD","Maryland","MA","Massachusetts","MI",
									   "Michigan","MN","Minnesota","MS","Mississippi","MO","Missouri","MT","Montana",
									   "NE","Nebraska","NV","Nevada","NH","New Hampshire","NJ","New Jersey",
									   "NM","New Mexico","NY","New York","NC","North Carolina","ND","North Dakota",
									   "OH","Ohio","OK","Oklahoma","OR","Oregon","PA","Pennsylvania","RI","Rhode Island",
									   "SC","South Carolina","SD","South Dakota","TN","Tennessee","TX","Texas",
									   "UT","Utah","VT","Vermont","VA","Virginia","WA","Washington","WV","West Virginia",
									   "WI","Wisconsin","WY","Wyoming"};
		state = state.toLowerCase();
		char[] s = StringOperations.toNonBlankCharArray(state);
		int m=0;
	    for(int i = 0; i < USState.length; i++){
			 USState[i]= USState[i].toLowerCase();
			 char[] st = StringOperations.toNonBlankCharArray(USState[i]);
			 if(s.length == st.length){
				  for (int k = 0; k<st.length; k++){
						if( s[k] == st[k])
							m++;
				  }
				 if(m == st.length)
						 flag = true;
				 else
						 m=0;
			 }
	    }
        return flag;
  }
  //检验zipcode是否有效
  public boolean isValidUSZipCode(){
  	    boolean isValid = false;

  	  	if(zipCode.length() == ZIPCODE_LEN){
			  char[] number = StringOperations.toNonBlankCharArray(zipCode);
  	  		  isValid = StringOperations.checkDigits(number);
  		}
  	  	return isValid;
  }
  //==
}

