package com.JakubP.RandomNumberApp.config;

import com.JakubP.RandomNumberApp.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.io.IOException;

@Configuration
public class BeanConfiguration {
    @Bean
    @Scope("singleton")
    ChatBotService chatBotService() throws IOException {
        return TwitchChatBotService.getBot();
    }

    @Bean
    @Scope("singleton")
    GeneratorService generatorService(){
        return LCGeneratorService.getGenerator();
    }
}
