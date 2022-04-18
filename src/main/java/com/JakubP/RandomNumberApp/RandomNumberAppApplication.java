package com.JakubP.RandomNumberApp;


import com.JakubP.RandomNumberApp.logic.Connector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.io.IOException;


@SpringBootApplication
public class RandomNumberAppApplication  {

	public static void main(String[] args) throws IOException {
		Connector c = new Connector();
		c.connect();
		SpringApplication.run(RandomNumberAppApplication.class, args);
		c.disconnect();
	}

}
