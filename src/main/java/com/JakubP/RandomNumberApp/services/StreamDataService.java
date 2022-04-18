package com.JakubP.RandomNumberApp.services;

import java.util.List;

public interface StreamDataService {
    public void refresh();

    public List<String> getStreamUsernames();
}
