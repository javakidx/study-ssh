package idv.jk.study.spring.service.impl;

import javax.security.auth.login.AccountException;

import idv.jk.study.spring.service.AopService;

public class AopServiceImpl implements AopService
{
	private String name;
	
	public void withAop() throws Exception
	{
		System.out.printf("執行AOP的函式，name：%s%n", name);
		
		if(name.trim().length() == 0)
		{
			throw new AccountException("name屬性不得為空");
		}
	}

	public void withoutAop() throws Exception
	{
		System.out.printf("執行沒有AOP的函式");
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

}
