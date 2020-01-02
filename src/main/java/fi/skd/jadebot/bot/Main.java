package fi.skd.jadebot.bot;

import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    private static JadeBot jadeBot;

    public static void main(String[] args) throws LoginException {
        launchBot();
    }

    public static void launchBot() throws LoginException {
        jadeBot = new JadeBot(readBotToken());
        jadeBot.launch();
    }

    private static String readBotToken() {
        String token = "";
        try {
            token = new String (Files.readAllBytes(Paths.get("token.txt")));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return token;
    }

    public static JadeBot getJadeBot() {
        return jadeBot;
    }

    public static void setJadeBot(JadeBot jadeBot) {
        Main.jadeBot = jadeBot;
    }
}
