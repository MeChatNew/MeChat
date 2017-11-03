package com.example.maiduan.android_project_2.model.entity;

import android.support.v4.app.Fragment;

public class Fragments {
    private Fragment fragment;
    private String title;

    public Fragments() {
    }

    public Fragments(Fragment fragment, String title) {
        this.fragment = fragment;
        this.title = title;
    }

    public Fragments(Fragment fragment) {
        this.fragment = fragment;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}