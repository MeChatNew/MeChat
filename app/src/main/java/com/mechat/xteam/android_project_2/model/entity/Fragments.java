package com.mechat.xteam.android_project_2.model.entity;

import android.os.Bundle;
import android.support.v4.app.Fragment;

public class Fragments extends Fragment{
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

    public static Fragments newInstance() {

        Bundle args = new Bundle();

        Fragments fragment = new Fragments();
        fragment.setArguments(args);
        return fragment;
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