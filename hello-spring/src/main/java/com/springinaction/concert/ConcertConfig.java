package com.springinaction.concert;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by bioyang on 2015/11/26.
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class ConcertConfig
{
    @Bean
    public Audience audience()
    {
        return new Audience();
    }
}
