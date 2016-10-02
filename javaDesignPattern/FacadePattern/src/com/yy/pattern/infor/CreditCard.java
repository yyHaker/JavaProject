package com.yy.pattern.infor;

import com.yy.pattern.client.UserGUI;
import com.yy.pattern.facade.FileIoOperations;
import com.yy.pattern.facade.StringOperations;

public class CreditCard {

  String cardType;
  String cardNumber;
  static final int VISA_LENGTH = 16;
  static final int DISCOVER_LENGTH = 15;
  static final int MASTER_LENGTH = 16;
  final String CC_DATA_FILE = "CreditCardInfo.txt";

  //constructor of CreditCard
  public CreditCard(String ccType, String ccNumber) {
    cardType = ccType;
    cardNumber = ccNumber;
  }

  //Check if the credit card number format is valid or not
  //Legal Visa card number format: 16 digit numbers
  //Legal Discover card number format: 15 digit numbers
  //Legal MASTER card:  16 digit numbers
  public boolean isValid() {
       boolean flag = false;

       char[] number = StringOperations.toNonBlankCharArray(cardNumber);
       flag = validateCreditCardNum(number, cardType);
	   return flag;
  }
  //save credit card info to cc.txt
  public boolean save() {
    FileIoOperations fio = new FileIoOperations();
    String dataLine =
      getCardType() + "," + getCardNumber();
    return fio.writeToFile(CC_DATA_FILE, dataLine, true, true);
  }
  public String getCardType() {
    return cardType;
  }
  public String getCardNumber() {
    return cardNumber;
  }

  public boolean validateCreditCardNum(char[] num, String cardType){
	    boolean isValid = false;
	    if (cardType.equals(UserGUI.VISA)) {
	  		if(num.length == VISA_LENGTH){
	  			isValid = StringOperations.checkDigits(num);
			}
	    }
		else if (cardType.equals(UserGUI.DISCOVER)) {
			if(num.length == DISCOVER_LENGTH){
				isValid = StringOperations.checkDigits(num);
			}
	    }
		else if (cardType.equals(UserGUI.MASTER)) {
	  		if(num.length == MASTER_LENGTH){
	  			isValid = StringOperations.checkDigits(num);
			}
	    }
	  	return isValid;
  }
}

