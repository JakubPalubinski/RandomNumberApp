package com.JakubP.RandomNumberApp.logic;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class StreamDataService {
    private List<String> lista = new ArrayList<>();

    public StreamDataService(){
        refresh();
    }

    private void refresh(){
        lista.clear();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://api.twitch.tv/helix/streams?first=50")).headers("Authorization", "Bearer 09ghtst8c374b6s8986n0yr4c2flbn", "Client-Id", "hfeulz5uv752u3v0zh1qzjxm4mt1ia").GET().build();
        String s = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                //.thenApply(Seed::parse)
                //.thenAccept(System.out::println)
                .join();
        s=s.substring(8);
        parse(s);
    }

    private String parse(String responseBody){
        JSONArray albums = new JSONArray(responseBody);
        for (int i = 0; i<albums.length(); i++){
            JSONObject album = albums.getJSONObject(i);
            String user_name = album.getString("user_name");
            lista.add(user_name);
        }
        return null;
    }

    public List<String> getStreamUsernames(){
        /*
        l.clear();
        l = new ArrayList<>();
        for(int i=0; i<lista.size(); i++){
            l.add(lista.get(i));
        }
        */
        return lista;
    }
}
