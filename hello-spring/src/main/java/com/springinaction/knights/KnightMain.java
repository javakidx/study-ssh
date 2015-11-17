package com.springinaction.knights;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by bioyang on 2015/11/18.
 */
public class KnightMain
{
    public static void main(String[] args)
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/springinaction/knights.xml");

        Knight knight = (Knight) context.getBean("knight");
        knight.embarkOnQuest();
    }
}
