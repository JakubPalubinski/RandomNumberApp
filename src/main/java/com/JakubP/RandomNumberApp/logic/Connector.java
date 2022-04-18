package com.JakubP.RandomNumberApp.logic;

import java.io.IOException;
import java.util.List;

public class Connector {
    StreamDataService t = new StreamDataService();
    List<String> usernames = t.getStreamUsernames();
    ChatBot bot = ChatBot.getBot();

    public void connect(){
        for(int i=0; i<usernames.size(); i++){
            bot.joinChannel(usernames.get(i));
        }
    }

    public void disconnect(){
        for(int i=0; i<usernames.size(); i++){
            bot.leaveChannel(usernames.get(i));
        }
    }

    public Connector() throws IOException {
    }
}
