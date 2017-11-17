package com.chat.xteam.ichat.model;



public class Group extends Room{
    public String id;
    public ListFriend listFriend;

    public Group(){
        listFriend = new ListFriend();
    }
}
