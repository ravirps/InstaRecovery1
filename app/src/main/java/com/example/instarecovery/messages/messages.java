package com.example.instarecovery.messages;

import java.util.List;

public class messages
{
    private List<String> participants;

    private List<Conversation> conversation;

    public void setParticipants(List<String> participants){
        this.participants = participants;
    }
    public List<String> getParticipants(){
        return this.participants;
    }
    public void setConversation(List<Conversation> conversation){
        this.conversation = conversation;
    }
    public List<Conversation> getConversation(){
        return this.conversation;
    }
}


class Likes
{
    private String username;

    private String date;

    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return this.username;
    }
    public void setDate(String date){
        this.date = date;
    }
    public String getDate(){
        return this.date;
    }
}

