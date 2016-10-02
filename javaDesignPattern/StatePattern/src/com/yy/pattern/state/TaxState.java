package com.yy.pattern.state;
/*========================================*/
/* A concrete state in the state pattern  */
/*========================================*/
public class TaxState extends State {
	private boolean overDrawnLismitFlag=false;
    
	public TaxState(){
		state=TAXSTATE;
	}
	@Override
	public void deposit(double amount) {
         if(amount>0){
        	 amount=amount-amount*BankContext.TRANS_FEE_TAX_RATE;
        	 balance=context.getBalance()+amount;
        	 context.updateBalance(balance);
        	 changeState();
         }
         else {
        	 System.out.println("Deposit amount cannot be 0 or negtive");
         }
	} 
	
	@Override
	public void withdraw(double amount) {
     if(amount>0){
    	  if((context.getBalance()-amount)>BankContext.OVERDRAW_LIMIT){
    		  balance=context.getBalance()-amount;
    		  context.updateBalance(amount);
    		  changeState();
    	  }else{
    		  overDrawnLismitFlag=true;
    	  }
     }else {
    	 System.out.println("Deposit amount cannot be 0 or negtive");
     }
	}

	@Override
	public boolean isOverDrawnLimitReached() {
		return overDrawnLismitFlag;
	}

}
