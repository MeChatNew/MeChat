package com.example.maiduan.android_project_2.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.maiduan.android_project_2.R;
import com.example.maiduan.android_project_2.model.entity.Yeucauketban;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dinhtuanthanh on 10/11/2017.
 */

public class YeucauketbanAdapter extends ArrayAdapter<Yeucauketban> {
    Activity context=null;
    List<Yeucauketban> myArray=null;
    int layoutId;

    public YeucauketbanAdapter(Activity context, int layoutId, ArrayList<Yeucauketban> arr){
        super(context, layoutId, arr);
        this.context=context;
        this.layoutId=layoutId;
        this.myArray=arr;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater= context.getLayoutInflater();
        convertView=inflater.inflate(layoutId, null);
        final Yeucauketban emp=myArray.get(position);

        final ImageView imgfriendyeucauketban = (ImageView) convertView.findViewById(R.id.imgfriendyeucauketban);
        final TextView txtnameyeucauketban = (TextView) convertView.findViewById(R.id.txtnamefriendyeucauketban);
        final TextView txtstatusyeucauketban = (TextView) convertView.findViewById(R.id.txtstatusyeucauketban);
        final Button btndongy = (Button) convertView.findViewById(R.id.btndongyketban);


        txtnameyeucauketban.setText(emp.getNameyeucauketban());
        txtstatusyeucauketban.setText(emp.getStatusyeucauketban());

        return convertView;
    }
}