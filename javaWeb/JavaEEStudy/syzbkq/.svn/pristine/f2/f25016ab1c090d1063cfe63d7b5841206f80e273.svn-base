package cn.thinking.system.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.neuedu.mapper.SqlServerDataSourceMapper;

import cn.thinking.system.datasource.DataSourceTypeManager;
import cn.thinking.system.datasource.DataSources;

/**
 * 动态加载数据源切面
 * @author Administrator
 *
 */
@Component // for auto scan
@Aspect    // for aop
public class DataSourceInterceptor {    
	@Around("execution(* *..mapper*..*(..))")
    public Object doAroundSql(ProceedingJoinPoint jp) throws Throwable {
        if (jp.getTarget() instanceof SqlServerDataSourceMapper) {
        	DataSourceTypeManager.set(DataSources.SQLSERVER);
        } else {
        	DataSourceTypeManager.set(DataSources.ORACLE);
        }
        return jp.proceed();
    }
	
	@Around("execution(* *..dao*..*(..))")
    public Object doAroundOrcl(ProceedingJoinPoint jp) throws Throwable {
        if (jp.getTarget() instanceof SqlServerDataSourceMapper) {
        	DataSourceTypeManager.set(DataSources.SQLSERVER);
        } else {
        	DataSourceTypeManager.set(DataSources.ORACLE);
        }
        return jp.proceed();
    }
}
