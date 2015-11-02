package idv.jk.study.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import idv.jk.study.spring.service.AopService;

public class AopServiceTest
{
	@SuppressWarnings("resource")
	@Test
	public void testAop() throws Exception
	{
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		AopService service = (AopService)applicationContext.getBean("aopService");
		service.withAop();
		service.withoutAop();
	}
}
