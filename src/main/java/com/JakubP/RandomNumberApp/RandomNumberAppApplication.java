package com.JakubP.RandomNumberApp;

import com.JakubP.RandomNumberApp.services.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;

@SpringBootApplication
public class RandomNumberAppApplication  {

	public static void main(String[] args) throws IOException {

		ConnectionService connectionService = new TwitchConnectionService(TwitchChatBotService.getBot(), new TwitchStreamDataService());
		TimerService refreshTimeService = new RefreshTimerService(new TwitchStreamDataService(), connectionService);
		refreshTimeService.start();
		connectionService.connect();
		SpringApplication.run(RandomNumberAppApplication.class, args);
		connectionService.disconnect();
	}
}
