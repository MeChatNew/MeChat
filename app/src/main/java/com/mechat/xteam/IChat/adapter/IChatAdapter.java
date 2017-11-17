package com.mechat.xteam.IChat.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.mechat.xteam.IChat.R;
import com.mechat.xteam.IChat.model.entity.Messages;
import com.mechat.xteam.IChat.view.activity.ChatDetail;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.content.ContentValues.TAG;

/**
 * Created by taipv on 11/11/2017.
 */

public class IChatAdapter extends RecyclerView.Adapter<IChatAdapter.ViewHolder> {
    List<Messages>listMes;
    Context ctx;

    public IChatAdapter( Context ctx,List<Messages>listMes) {
        this.listMes = listMes;
        this.ctx = ctx;
    }

    @Override
    public IChatAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message, parent, false));
    }


    @Override
    public void onBindViewHolder(IChatAdapter.ViewHolder holder, int position) {
        Messages messages=listMes.get(position);
        Log.d(TAG, "onBindViewHolder: "+messages.getIName());
        holder.setData(messages);
        Toast.makeText(ctx, "Hello New Message", Toast.LENGTH_SHORT).show();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ctx, "Hello New Message", Toast.LENGTH_SHORT).show();
                goToDetailChat();
            }
        });
        Log.d(TAG, "onBindViewHolder: "+listMes.get(0).getIName());
    }

    private void goToDetailChat() {
        ctx.startActivity(new Intent(ctx.getApplicationContext(),ChatDetail.class));
    }

    @Override
    public int getItemCount() {
        return listMes.size();
    }
    public void clearData(){
        listMes.clear();
        notifyDataSetChanged();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nameChat,contentChat,timeChat;
        private CircleImageView avatarChat;
        public ViewHolder(View itemView) {
            super(itemView);
            nameChat= (TextView) itemView.findViewById(R.id.name_chat);
            contentChat= (TextView) itemView.findViewById(R.id.content_chat);
            timeChat= (TextView) itemView.findViewById(R.id.time_chat);
            avatarChat= (CircleImageView) itemView.findViewById(R.id.avatar_chat);

        }
        private void setData(Messages messages){

                nameChat.setText(messages.getIName());
                contentChat.setText(messages.getIMessages());
                timeChat.setText(messages.getITime());
                avatarChat.setImageResource(R.drawable.mew);

        }

    }
}
