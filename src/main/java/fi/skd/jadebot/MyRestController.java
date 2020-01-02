package fi.skd.jadebot;

import fi.skd.jadebot.bot.Main;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
    @RequestMapping("/playlist")
    public String getPlayList() {
        return Main.getJadeBot().listTracks();
    }
}
