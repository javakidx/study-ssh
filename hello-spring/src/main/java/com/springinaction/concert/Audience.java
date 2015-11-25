package com.springinaction.concert;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by bioyang on 2015/11/26.
 */
@Aspect
public class Audience
{
    @Before("execution(** concert.Performance.perform(..))")
    public void silenceCellPhones()
    {
        System.out.println("Silencing cell phones");
    }

    @Before("execution(** concert.Performance.perform(..))")
    public void takeSeats()
    {
        System.out.println("Taking seats");
    }

    @AfterReturning("execution(** concert.Performance.perform(..))")
    public void applause()
    {
        System.out.println("CLAP CLAP CLAP!!!");
    }

    @AfterThrowing("execution(** concert.Performance.perform(..))")
    public void demandRefund()
    {
        System.out.println("Demanding a refund");
    }
}
