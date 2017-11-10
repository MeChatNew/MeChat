package com.example.maiduan.android_project_2.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.maiduan.android_project_2.R;
import com.example.maiduan.android_project_2.adapter.FriendAdapter;
import com.example.maiduan.android_project_2.model.entity.Fridends;

import java.util.ArrayList;


/**
 *Dinh Thanh
 */

public class FriendFragment extends Fragment {
    ArrayList<Fridends> arrFriend;
    FriendAdapter adapter;
    ListView lvfriend;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fr_friend,container,false);
        lvfriend=(ListView) view.findViewById(R.id.lvfriend);
        arrFriend=new ArrayList<Fridends>();
        //Khởi tạo đối tượng adapter và gán Data source
        adapter=new FriendAdapter(
                getActivity(),
                R.layout.item_friend,// lấy custom layout
                arrFriend/*thiết lập data source*/);
        lvfriend.setAdapter(adapter);//gán Adapter vào Lisview
        Fridends fr = new Fridends("Đinh Tuấn Thanh","trạng thái",null);
        Fridends fr1 = new Fridends("Mai Ngọc Duẩn","trạng thái",null);
        Fridends fr2 = new Fridends("Phùng Văn Tài","trạng thái",null);
        Fridends fr3 = new Fridends("Vũ Ngọc Huyền","trạng thái",null);
        arrFriend.add(fr);
        arrFriend.add(fr1);
        arrFriend.add(fr2);
        arrFriend.add(fr3);

        return view;
    }
}
