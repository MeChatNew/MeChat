package com.mechat.xteam.IChat.model.entity;

/**
 * Created by taipv on 11/17/2017.
 */

public class MessageDetail {
    private String content;
    private String avatar;

    public MessageDetail(String content, String avatar) {
        this.content = content;
        this.avatar = avatar;
    }

    public MessageDetail() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

}
