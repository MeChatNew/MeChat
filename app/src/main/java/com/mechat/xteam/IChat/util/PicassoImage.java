package com.mechat.xteam.IChat.util;

import android.content.Context;

import com.mechat.xteam.IChat.R;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by taipv on 11/17/2017.
 */

public class PicassoImage {
    public void getImage(Context ctx, String url, CircleImageView img){
        Picasso.with(ctx).load(url).placeholder(R.drawable.default_avata).error(R.drawable.default_avata).fit().centerCrop().into(img);
    }
}
