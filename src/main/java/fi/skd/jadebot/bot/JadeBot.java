package fi.skd.jadebot.bot;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class JadeBot extends ListenerAdapter {
    private JDABuilder builder;
    private AudioPlayer audioPlayer;

    private final char FRONTCHAR = '!';

    public JadeBot(String token) {
        builder = new JDABuilder(AccountType.BOT);
        builder.setToken(token);
        builder.addEventListeners(this);
        audioPlayer = new AudioPlayer();
    }

    public void launch() throws LoginException {
        builder.build();
    }


    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        System.out.println("We received a message from " +
                event.getAuthor().getName() + ": " +
                event.getMessage().getContentDisplay());
    }

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] command = event.getMessage().getContentRaw().split(" ", 2);

        if ((FRONTCHAR + "play").equals(command[0]) && command.length == 2) {
            audioPlayer.loadAndPlay(event.getChannel(), command[1]);
        } else if ((FRONTCHAR + "skip").equals(command[0])) {
            audioPlayer.skipTrack(event.getChannel());
        } else if ((FRONTCHAR + "list").equals(command[0])) {
            audioPlayer.listTracks(event.getChannel());
        } else if ((FRONTCHAR + "quit").equals(command[0])) {
            quit();
        } else if ((FRONTCHAR + "pause").equals(command[0])) {
            pause();
        }

        super.onGuildMessageReceived(event);
    }

    private void quit() {
        System.exit(0);
    }

    public void pause() {
        System.out.println("JadeBot: pause()");
    }

    public String listTracks() {
        return audioPlayer.listAllTracks();
    }
}
