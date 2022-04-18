package com.JakubP.RandomNumberApp.services;

import java.io.IOException;

public interface ChatBotService {
    public String readMsg();

    public int getNumberFromMsg() throws IOException;

    public void writeMsg(String msg);

    public void leaveChannel(String channel);

    public void joinChannel(String channel);
}
