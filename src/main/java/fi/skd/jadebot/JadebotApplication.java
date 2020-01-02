package fi.skd.jadebot;

import fi.skd.jadebot.bot.Main;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JadebotApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JadebotApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main.launchBot();
	}
}
