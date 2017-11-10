package com.mechat.xteam.IChat.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mechat.xteam.IChat.R;

/**
duan
 */

public class RoomFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.roomchat,container,false);
    }

    public static RoomFragment newInstance() {
        
        Bundle args = new Bundle();
        
        RoomFragment fragment = new RoomFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
