package com.springinaction.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * Created by bioyang on 2015/11/25.
 */
@Configuration
@PropertySource("classpath:/com/springinaction/soundsystem/app.properties")
public class ExpressiveConfig
{
    @Autowired
    Environment env;

    @Bean
    public BlankDisc disc()
    {
        return new BlankDisc(
          env.getProperty("disc.title"),
                env.getProperty("disc.artist")
        );
    }
}
