package projettaa.taa.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import projettaa.taa.aspect.LogAspect;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"projettaa.taa.aspect"})

public class AssetConfig {

    @Bean   
    public LogAspect myLogger(){
       return new LogAspect();
    }
}
