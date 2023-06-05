package ua.knu.fit.mit.lab5.config;

import components.Sample;
import components.SampleImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig
{
    @Bean
    public Sample getSample(){
        return new SampleImpl();
    }
}
