package com.mechat.xteam.IChat.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mechat.xteam.IChat.R;
import com.mechat.xteam.IChat.adapter.IChatAdapter;
import com.mechat.xteam.IChat.model.entity.Messages;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 *Phung Tai
 */

public class ChatFragment extends Fragment {
    IChatAdapter iChatAdapter;
    Messages messages;
    RecyclerView rcvIchat;
    List<Messages>listMes;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.ichat,container,false);
    }

    public static ChatFragment newInstance() {
        
        Bundle args = new Bundle();
        
        ChatFragment fragment = new ChatFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rcvIchat= (RecyclerView) view.findViewById(R.id.rcv_ichat);
        rcvIchat.setLayoutManager(new LinearLayoutManager(getContext()));
        //set du lieu ao
        messages=new Messages();
        messages.setIName("Tai");
        messages.setIMessages("Dang lam gi the Duan");
        messages.setITime("23:59");
        Messages messages1=new Messages();
        messages1.setIName("Huyen");
        messages1.setIMessages("Dang lam gi the Tai");
        messages1.setITime("23:59");
        Messages messages2=new Messages();
        messages2.setIName("Duan");
        messages2.setIMessages("Dang lam gi the Thanh");
        messages2.setITime("23:59");
        Messages messages3=new Messages();
        messages3.setIName("Thanh");
        messages3.setIMessages("Dang lam gi the Huyen");
        messages3.setITime("23:59");
        listMes=new ArrayList<>();
        listMes.add(messages);
        listMes.add(messages1);
        listMes.add(messages2);
        listMes.add(messages3);
        iChatAdapter=new IChatAdapter(getContext(),listMes);
//        iChatAdapter.setListData(listMes);
        Log.d(TAG, "onViewCreated: "+listMes.get(2).getIMessages());
        Log.d(TAG, "onViewCreated: "+ listMes.get(2).getIName());
        rcvIchat.setAdapter(iChatAdapter);
    }
}
