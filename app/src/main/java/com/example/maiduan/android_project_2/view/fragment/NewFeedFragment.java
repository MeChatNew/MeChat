package com.example.maiduan.android_project_2.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.maiduan.android_project_2.R;

/**
 * Created by it-36 on 10/27/17.
 */

public class NewFeedFragment extends Fragment {
    public static NewFeedFragment newInstance() {

        Bundle args = new Bundle();

        NewFeedFragment fragment = new NewFeedFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.newfeed,container,false);
    }


}
