package cn.yy.multiTable;

public class ClientFactoryUse {

	public static void main(String[] args) {
       LowTable lowtable= LowTableFactory.TableFactory("*");
       lowtable.low();
	}

}
