package com.JakubP.RandomNumberApp.services;

import org.springframework.stereotype.Service;

import java.util.Timer;
import java.util.TimerTask;

@Service
public class RefreshTimerService implements TimeService{
    private Timer timer = new Timer();
    private final StreamDataService twitchStreamDataService;
    private final ConnectionService twitchConnectionService;

    public RefreshTimerService(StreamDataService streamDataService, ConnectionService twitchConnectionService){
        this.twitchConnectionService = twitchConnectionService;
        this.twitchStreamDataService = streamDataService;
        }

    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            twitchConnectionService.disconnect();
            twitchStreamDataService.refresh();
            twitchConnectionService.connect();
        }
    };

    public void start(){
        timer.scheduleAtFixedRate(task, 0, 1000*60*30);
    }
}
