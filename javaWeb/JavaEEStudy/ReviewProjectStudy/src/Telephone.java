/**
 * 本人电话号码
 * @author 57217
 *
 */
public class Telephone {

	public static void main(String[] args) {
          int []arr=new int[]{8,7,6,4,2,1,0};
          int []index=new int[]{5,0,2,0,2,1,4,0,6,4,3};
          String tel="";
          for (int i : index) {
			tel+=arr[i];
		}
          System.out.println("本人联系方式:"+tel);
	}

}
