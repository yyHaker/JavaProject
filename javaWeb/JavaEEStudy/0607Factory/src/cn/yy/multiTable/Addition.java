package cn.yy.multiTable;

public class Addition extends LowTable {

	@Override
	public void low() {
		for(int i=1;i<=9;i++){
			   for(int j=1;j<=i;j++){
				   System.out.print(String.format("%d+%2d=%3d\t",j,i,i*j));
			   }
			   System.out.println();
		   }
	}

}
