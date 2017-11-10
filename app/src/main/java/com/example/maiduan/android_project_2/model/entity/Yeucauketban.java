package com.example.maiduan.android_project_2.model.entity;

import android.graphics.Bitmap;

/**
 * Created by dinhtuanthanh on 10/11/2017.
 */

public class Yeucauketban {
    private String nameyeucauketban;
    private String statusyeucauketban;
    private Bitmap imgfriendyeucauketban;

    public Yeucauketban(String nameyeucauketban, String statusyeucauketban, Bitmap imgfriendyeucauketban) {
        this.nameyeucauketban = nameyeucauketban;
        this.statusyeucauketban = statusyeucauketban;
        this.imgfriendyeucauketban = imgfriendyeucauketban;
    }

    public Yeucauketban() {
    }

    public String getNameyeucauketban() {
        return nameyeucauketban;
    }

    public void setNameyeucauketban(String nameyeucauketban) {
        this.nameyeucauketban = nameyeucauketban;
    }

    public String getStatusyeucauketban() {
        return statusyeucauketban;
    }

    public void setStatusyeucauketban(String statusyeucauketban) {
        this.statusyeucauketban = statusyeucauketban;
    }

    public Bitmap getImgfriendyeucauketban() {
        return imgfriendyeucauketban;
    }

    public void setImgfriendyeucauketban(Bitmap imgfriendyeucauketban) {
        this.imgfriendyeucauketban = imgfriendyeucauketban;
    }
}
