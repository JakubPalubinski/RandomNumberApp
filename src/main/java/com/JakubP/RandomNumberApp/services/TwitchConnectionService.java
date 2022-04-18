package com.JakubP.RandomNumberApp.services;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TwitchConnectionService implements ConnectionService{
    private final StreamDataService streamDataService;
    private final List<String> usernames;
    private final ChatBotService bot;

    public TwitchConnectionService(ChatBotService bot, StreamDataService streamDataService){
        this.streamDataService = streamDataService;
        this.bot = bot;
        usernames = this.streamDataService.getStreamUsernames();
    }

    public void connect(){
        for (String username : usernames) {
            bot.joinChannel(username);
        }
    }

    public void disconnect(){
        for (String username : usernames) {
            bot.leaveChannel(username);
        }
    }
}
