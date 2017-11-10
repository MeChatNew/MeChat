package com.example.maiduan.android_project_2.model.entity;

import android.graphics.Bitmap;

/**
 * Created by dinhtuanthanh on 10/11/2017.
 */

public class Fridends {
    private String name;
    private String status;
    private Bitmap imgfriend;

    public Fridends(String name, String status, Bitmap imgfriend) {
        this.name = name;
        this.status = status;
        this.imgfriend = imgfriend;
    }

    public Fridends() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Bitmap getImgfriend() {
        return imgfriend;
    }

    public void setImgfriend(Bitmap imgfriend) {
        this.imgfriend = imgfriend;
    }
}
