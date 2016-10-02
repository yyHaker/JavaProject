package cn.yy.multiTable;

public class LowTableFactory {
    public  static LowTable TableFactory(String op){
    	switch (op) {
		case "+":
			return new Addition();
		
		case "*":
			return new Mutiplication();
		
		}
		return null;
    }
}
