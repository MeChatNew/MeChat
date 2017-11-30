package com.chat.xteam.ichat.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.chat.xteam.ichat.R;

import java.util.ArrayList;

/**
 * Created by dinhtuanthanh on 09/11/2017.
 */

public class friendFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fr_friend,container,false);


        return view;
    }
}
