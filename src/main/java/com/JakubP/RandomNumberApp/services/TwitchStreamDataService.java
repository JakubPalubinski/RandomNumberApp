package com.JakubP.RandomNumberApp.services;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class TwitchStreamDataService implements StreamDataService{
    private static List<String> usernames = new ArrayList<>();

    public TwitchStreamDataService(){

    }

    public void refresh(){
        usernames.clear();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://api.twitch.tv/helix/streams?first=50")).headers("Authorization", "Bearer 09ghtst8c374b6s8986n0yr4c2flbn", "Client-Id", "hfeulz5uv752u3v0zh1qzjxm4mt1ia").GET().build();
        String s = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .join();
        s=s.substring(8);
        parse(s);
    }

    private void parse(String responseBody){
        JSONArray albums = new JSONArray(responseBody);
        for (int i = 0; i<albums.length(); i++){
            JSONObject album = albums.getJSONObject(i);
            String user_name = album.getString("user_name");
            usernames.add(user_name);
        }
    }

    public List<String> getStreamUsernames(){
        return usernames;
    }
}
