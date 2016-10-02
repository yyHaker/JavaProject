package cn.thinking.system.datasource;
/**
 * 数据源默认初始化
 * @author yang-jg
 *
 */
public class DataSourceTypeManager {
	 private static final ThreadLocal<DataSources> dataSourceTypes = new ThreadLocal<DataSources>(){
	        @Override
	        protected DataSources initialValue(){
	            return DataSources.ORACLE;
	        }
	    };
	     
	    public static DataSources get(){
	        return dataSourceTypes.get();
	    }
	     
	    public static void set(DataSources dataSourceType){
	        dataSourceTypes.set(dataSourceType);
	    }
	     
	    public static void reset(){
	        dataSourceTypes.set(DataSources.ORACLE);
	    }
}
