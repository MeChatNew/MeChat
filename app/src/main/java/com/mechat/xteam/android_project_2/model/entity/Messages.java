package com.mechat.xteam.android_project_2.model.entity;

/**
 * Created by taipv on 11/11/2017.
 */

public class Messages {
    String Avatar;
    String IName;
    String IMessages;
    String ITime;

    public Messages(String avatar, String IName, String IMessages, String ITime) {
        Avatar = avatar;
        this.IName = IName;
        this.IMessages = IMessages;
        this.ITime = ITime;
    }

    public Messages() {

    }

    public String getAvatar() {
        return Avatar;
    }

    public void setAvatar(String avatar) {
        Avatar = avatar;
    }

    public String getIName() {
        return IName;
    }

    public void setIName(String IName) {
        this.IName = IName;
    }

    public String getIMessages() {
        return IMessages;
    }

    public void setIMessages(String IMessages) {
        this.IMessages = IMessages;
    }

    public String getITime() {
        return ITime;
    }

    public void setITime(String ITime) {
        this.ITime = ITime;
    }
}
