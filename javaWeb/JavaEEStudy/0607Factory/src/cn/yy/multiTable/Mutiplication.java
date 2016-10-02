package cn.yy.multiTable;

public class Mutiplication extends LowTable {

	@Override
	public void low() {
		for(int i=1;i<=9;i++){
			   for(int j=1;j<=i;j++){
				   System.out.print(String.format("%d*%d=%d\t",j,i,i*j));
			   }
			   System.out.println();
		   }
	}

}
