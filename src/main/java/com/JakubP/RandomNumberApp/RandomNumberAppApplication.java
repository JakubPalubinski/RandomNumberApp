package com.JakubP.RandomNumberApp;

import com.JakubP.RandomNumberApp.services.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;

@SpringBootApplication
public class RandomNumberAppApplication  {

	public static void main(String[] args) throws IOException {

		ConnectionService twitchConnectionService = new TwitchConnectionService(TwitchChatBotService.getBot(), new TwitchStreamDataService());
		TimeService refreshTimeService = new RefreshTimerService(new TwitchStreamDataService(), twitchConnectionService);
		refreshTimeService.start();
		twitchConnectionService.connect();
		SpringApplication.run(RandomNumberAppApplication.class, args);
		twitchConnectionService.disconnect();
	}
}
