package idv.jk.study.spring.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class MethodAfterInterceptor implements AfterReturningAdvice
{

	public void afterReturning(Object value, Method method, Object[] args, Object instance) throws Throwable
	{
		System.out.printf("方法 %s 執行完畢，傳回值為：%s" + method.getName(), value);
	}

}
