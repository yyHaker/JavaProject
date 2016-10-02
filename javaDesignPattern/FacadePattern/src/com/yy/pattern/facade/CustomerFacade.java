package com.yy.pattern.facade;

import com.yy.pattern.infor.Account;
import com.yy.pattern.infor.Address;
import com.yy.pattern.infor.CreditCard;

public class CustomerFacade {

  private String address;
  private String city;
  private String state;
  private String zipCode;
  
  private String cardType;
 

private String cardNumber;
  private String fname;
  private String lname;
  private String[] errorMsg;
  private  Address objAddress;
  private  Account objAccount;
  private CreditCard objCreditCard;

  public void setAddress(String inAddress) {
    address = inAddress;
  }
  public void setCity(String inCity) {
    city = inCity;
  }
  public void setState(String inState) {
    state = inState;
  }
  public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
  
  public void setFName(String inFName) {
    fname = inFName;
  }
  public void setLName(String inLName) {
    lname = inLName;
  }
  public void setCardType(String inCardType) {
    cardType = inCardType;
  }
  public void setCardNumber(String inCardNumber) {
    cardNumber = inCardNumber;
  }
  public String[] getErrorMsg() {
	   return errorMsg;
  }

  private boolean isValidateUsrInfo(){
	    boolean isValidData = true;
	    String errorMessage = "";

	    errorMsg = new String[3];
	    objAccount = new Account(fname, lname);
	    if (objAccount.isValid() == false) {
	        isValidData = false;
	        errorMsg[0] = "Invalid FirstName/LastName\n";
	    }
	    else
	        errorMsg[0] = "valid FirstName/LastName\n";

	    objAddress = new Address(address, city, state,zipCode);
	    if (objAddress.isValid() == false) {
	        isValidData = false;
	        errorMsg[1] = "Invalid Address/City/State/zipCode\n";
	    }
	    else
	        errorMsg[1] = "Valid Address/City/State/zipCode\n";

	    objCreditCard = new CreditCard(cardType, cardNumber);
	    if (objCreditCard.isValid() == false) {
	        isValidData = false;
	        errorMsg[2] = "Invalid CreditCard Info\n";
        }
        else
            errorMsg[2] = "Valid CreditCard Info\n";

	    return isValidData;
  }

  public boolean saveCustomerData() {
       boolean flag = false;
	   if( isValidateUsrInfo() == true){
		     boolean isAddrSaved = objAddress.save();
		     boolean isAcctSaved = objAccount.save();
		     boolean isCardSaved = objCreditCard.save();

		     if (isAddrSaved && isAcctSaved && isCardSaved) {
			  	  flag = true;
		     }
		}
		return flag;
   }
}

