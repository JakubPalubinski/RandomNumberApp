package com.JakubP.RandomNumberApp.logic;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatBot {
    private Socket s = new Socket("irc.chat.twitch.tv", 6667);
    private String accountName = "niduc2022";
    private String Token = "oauth:qokf8clo4fze4yb0mzfn9y172csq17";
    private Scanner streamReader = new Scanner(s.getInputStream());
    private PrintWriter streamWriter = new PrintWriter(s.getOutputStream(), true);
    private String lastLine;
    private static ChatBot bot;

    public static ChatBot getBot() throws IOException {
        if(bot==null){
            bot = new ChatBot();
        }
        return bot;
    }
    
    private ChatBot() throws IOException {
        streamWriter.println("PASS " + Token);
        streamWriter.println("NICK " + accountName);
        for (int i =0; i<7; i++){
            lastLine = streamReader.nextLine();
            //System.out.println(lastLine);
        }
    }

    public String readMsg() throws IOException {

        while(true){
            if(streamReader.hasNext()){
                lastLine = streamReader.next();
                return lastLine;
            }
        }

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
        for (int i =0; i<4; i++){
            lastLine = streamReader.nextLine();
        }
    }
}
