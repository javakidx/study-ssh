package soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by bioyang on 2015/11/19.
 */
@Configuration
//@ComponentScan(basePackages = {"soundsystem", "video"})
//@ComponentScan(basePackageClasses = {SgtPeppers.class})
public class CDPlayerConfig
{
    @Bean
    public CompactDisc compactDisc()
    {
        return new SgtPeppers();
    }

    @Bean
    public CDPlayer cdPlayer()
    {
        return new CDPlayer(compactDisc());
    }
}
