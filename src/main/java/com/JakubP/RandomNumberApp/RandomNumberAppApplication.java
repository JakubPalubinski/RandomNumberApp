package com.JakubP.RandomNumberApp;

import com.JakubP.RandomNumberApp.services.ConnectionService;
import com.JakubP.RandomNumberApp.services.TwitchConnectionService;
import com.JakubP.RandomNumberApp.services.TwitchStreamDataService;
import com.JakubP.RandomNumberApp.services.TwitchChatBotService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;

@SpringBootApplication
public class RandomNumberAppApplication  {

	public static void main(String[] args) throws IOException {
		ConnectionService c = new TwitchConnectionService(TwitchChatBotService.getBot(), new TwitchStreamDataService());
		c.connect();
		SpringApplication.run(RandomNumberAppApplication.class, args);
		c.disconnect();
	}
}
