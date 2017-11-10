package com.example.maiduan.android_project_2.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.maiduan.android_project_2.R;
import com.example.maiduan.android_project_2.model.entity.Fridends;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dinhtuanthanh on 10/11/2017.
 */

public class FriendAdapter extends ArrayAdapter<Fridends> {
    Activity context=null;
    List<Fridends> myArray=null;
    int layoutId;

    public FriendAdapter(Activity context,int layoutId, ArrayList<Fridends> arr){
        super(context, layoutId, arr);
        this.context=context;
        this.layoutId=layoutId;
        this.myArray=arr;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater= context.getLayoutInflater();
        convertView=inflater.inflate(layoutId, null);
        final Fridends emp=myArray.get(position);

        final ImageView imgfriend = (ImageView) convertView.findViewById(R.id.imgfriend);
        final TextView txtname = (TextView) convertView.findViewById(R.id.txtnamefriend);
        final TextView txtstatus = (TextView) convertView.findViewById(R.id.txtstatus);

        txtname.setText(emp.getName());
        txtstatus.setText(emp.getStatus());


        return convertView;
    }
}
