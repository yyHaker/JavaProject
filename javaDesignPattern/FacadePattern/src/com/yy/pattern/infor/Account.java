package com.yy.pattern.infor;

import com.yy.pattern.facade.FileIoOperations;

public class Account {

  String firstName;
  String lastName;
  final String ACCOUNT_DATA_FILE = "AccountData.txt";

 //constructor
  public Account(String fname, String lname) {
    firstName = fname;
    lastName = lname;
  }

  // Students should modify this method
  public boolean isValid() {
	    boolean flag = true;
	    char firstNM[] = firstName.toCharArray();
        char lastNM[] = lastName.toCharArray();

    	int len1 = firstNM.length;
    	int len2 = lastNM.length;

    	if( (len1==0) || (len2==0))
    	      return false;
    	else{
		      for(int i = 0; i < len1; i++){
				  if( Character.isLetter(firstNM[i]) == false)
					  flag = false;
			  }
			  for(int j = 0; j < len2; j++){
					if( Character.isLetter(lastNM[j]) == false)
						 flag = false;
			  }
			  return flag;
	  }
  }

  // save last name and first name
  public boolean save() {
    FileIoOperations fio = new FileIoOperations();
    String dataLine = getLastName() + "," + getFirstName();
    return fio.writeToFile(ACCOUNT_DATA_FILE, dataLine,
           true, true);

  }

  // get first name and last name
  public String getFirstName() {
    return firstName;
  }
  public String getLastName() {
    return lastName;
  }

}

