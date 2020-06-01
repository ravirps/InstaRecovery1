package com.example.instarecovery.messages;

import java.util.List;

public class Conversation
{
    private String sender;

    private String created_at;

    private List<Likes> likes;

    private String media_owner;

    private String text;

    public String getText() {
        return text;
    }

    private String media_share_caption;

    private String media_share_url;

    public void setSender(String sender){
        this.sender = sender;
    }
    public String getSender(){
        return this.sender;
    }
    public void setCreated_at(String created_at){
        this.created_at = created_at;
    }
    public String getCreated_at(){
        return this.created_at;
    }
    public void setLikes(List<Likes> likes){
        this.likes = likes;
    }
    public List<Likes> getLikes(){
        return this.likes;
    }
    public void setMedia_owner(String media_owner){
        this.media_owner = media_owner;
    }
    public String getMedia_owner(){
        return this.media_owner;
    }
    public void setMedia_share_caption(String media_share_caption){
        this.media_share_caption = media_share_caption;
    }
    public String getMedia_share_caption(){
        return this.media_share_caption;
    }
    public void setMedia_share_url(String media_share_url){
        this.media_share_url = media_share_url;
    }
    public String getMedia_share_url(){
        return this.media_share_url;
    }
}
