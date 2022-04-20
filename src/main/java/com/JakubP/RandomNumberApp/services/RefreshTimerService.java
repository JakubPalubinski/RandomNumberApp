package com.JakubP.RandomNumberApp.services;

import org.springframework.stereotype.Service;

import java.util.Timer;
import java.util.TimerTask;

@Service
public class RefreshTimerService implements TimerService {
    private Timer timer = new Timer();
    private final StreamDataService streamDataService;
    private final ConnectionService connectionService;

    public RefreshTimerService(StreamDataService streamDataService, ConnectionService connectionService){
        this.connectionService = connectionService;
        this.streamDataService = streamDataService;
        }

    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            connectionService.disconnect();
            streamDataService.refresh();
            connectionService.connect();
        }
    };

    public void start(){
        timer.scheduleAtFixedRate(task, 0, 1000*60*30);
    }
}
