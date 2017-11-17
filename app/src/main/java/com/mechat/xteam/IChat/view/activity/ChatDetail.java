package com.mechat.xteam.IChat.view.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.mechat.xteam.IChat.R;
import com.mechat.xteam.IChat.model.entity.MessageDetail;

public class ChatDetail extends AppCompatActivity {
FloatingActionButton fab;
ListView lvContent;
EditText edtInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
    }

    private void init() {
        fab= (FloatingActionButton) findViewById(R.id.fab_send);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                send();
            }
        });
    }

    private void send() {

        edtInput = (EditText)findViewById(R.id.edt_iputMess);

        // Read the input field and push a new instance
        // of ChatMessage to the Firebase database

        FirebaseDatabase.getInstance()
                .getReference()
                .child("message/")
                .push()
                .setValue(new MessageDetail(edtInput.getText().toString(),
                        FirebaseAuth.getInstance()
                                .getCurrentUser()
                                .getDisplayName())
                );

        // Clear the input
        edtInput.setText("");
    }
}
