package idv.jk.study.spring.aop;

import java.lang.reflect.Method;

import javax.security.auth.login.AccountException;

import org.springframework.aop.ThrowsAdvice;

public class ThrowsInterceptor implements ThrowsAdvice
{
	public void afterThrowing(Method method, Object[] args, Object instance, AccountException ex) throws Throwable
	{
		System.out.printf("方法 %s 抛出了例外：%s", method.getName(), ex.toString());
	}
	
	public void afterThrowing(NullPointerException ex) throws Throwable
	{
		System.out.printf("抛出了例外：%s", ex.toString());
	}
}
