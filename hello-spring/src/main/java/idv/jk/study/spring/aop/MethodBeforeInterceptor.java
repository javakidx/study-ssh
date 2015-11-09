package idv.jk.study.spring.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

import idv.jk.study.spring.service.impl.AopServiceImpl;

public class MethodBeforeInterceptor implements MethodBeforeAdvice
{

	public void before(Method method, Object[] args, Object instance) throws Throwable
	{
		System.out.printf("執行方法：%s", method.getName());
		
		if (instance instanceof AopServiceImpl)
		{
			String name = ((AopServiceImpl)instance).getName();
			
			if (name == null)
			{
				throw new NullPointerException("name屬性不能為null");
			}
		}
	}

}
