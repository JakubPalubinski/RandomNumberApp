package com.JakubP.RandomNumberApp.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TwitchChatBotService implements ChatBotService{
    private final Socket socket = new Socket("irc.chat.twitch.tv", 6667);
    private final String accountName = "niduc2022";
    private final String Token = "oauth:qokf8clo4fze4yb0mzfn9y172csq17";
    private final Scanner streamReader = new Scanner(socket.getInputStream());
    private final PrintWriter streamWriter = new PrintWriter(socket.getOutputStream(), true);
    private String lastLine;
    private static TwitchChatBotService bot;

    public static TwitchChatBotService getBot() throws IOException {
        if(bot==null){
            bot = new TwitchChatBotService();
        }
        return bot;
    }
    
    private TwitchChatBotService() throws IOException {
        streamWriter.println("PASS " + Token);
        streamWriter.println("NICK " + accountName);
        for (int i =0; i<7; i++){
            lastLine = streamReader.nextLine();
        }
    }

    public String readMsg() {
        try{
            if(streamReader.hasNext()){
                lastLine = streamReader.nextLine();
                return lastLine;
            }
        } catch (Exception e){
            return "";
        }
        return "";
    }

    public int getNumberFromMsg() throws IOException {
        return readMsg().hashCode();
    }

    public void writeMsg(String msg){
        streamWriter.println(msg);
    }

    public void leaveChannel(String channel){
        writeMsg("PART #"+channel.toLowerCase());
    }

    public void joinChannel(String channel) {
        writeMsg("JOIN #"+channel.toLowerCase());
        for (int i =0; i<3; i++){
            lastLine = streamReader.nextLine();
        }
    }
}
