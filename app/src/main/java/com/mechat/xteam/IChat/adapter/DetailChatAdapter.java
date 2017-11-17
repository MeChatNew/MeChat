package com.mechat.xteam.IChat.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mechat.xteam.IChat.R;
import com.mechat.xteam.IChat.model.entity.MessageDetail;
import com.mechat.xteam.IChat.util.PicassoImage;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by taipv on 11/17/2017.
 */

public class DetailChatAdapter extends RecyclerView.Adapter<DetailChatAdapter.ViewHolder> {
    List<MessageDetail>listChat;
    Context ctx;

    public DetailChatAdapter(List<MessageDetail> listChat, Context ctx) {
        this.listChat = listChat;
        this.ctx = ctx;
    }

    @Override
    public DetailChatAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detail_chat,null,false));
    }

    @Override
    public void onBindViewHolder(DetailChatAdapter.ViewHolder holder, int position) {
        MessageDetail chat=listChat.get(position);
        holder.setData(chat);
    }

    @Override
    public int getItemCount() {
        return listChat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtChat;
        CircleImageView imgAvatar;
        public ViewHolder(View itemView) {
            super(itemView);
            txtChat= (TextView) itemView.findViewById(R.id.textContentFriend);
            imgAvatar= (CircleImageView) itemView.findViewById(R.id.img_avatar_content);
        }
        private void setData(MessageDetail chat){
            txtChat.setText(chat.getContent());
        new PicassoImage().getImage(ctx,chat.getAvatar(),imgAvatar);
            }
    }

}
