package com.example.maiduan.android_project_2.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.maiduan.android_project_2.R;
import com.example.maiduan.android_project_2.adapter.YeucauketbanAdapter;
import com.example.maiduan.android_project_2.model.entity.Yeucauketban;

import java.util.ArrayList;

/**
 * Created by dinhtuanthanh on 09/11/2017.
 */

public class MetalkFragment extends Fragment {
    ArrayList<Yeucauketban> arryeucauketban;
    YeucauketbanAdapter adapter;
    ListView lvyeucauketban;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fr_metalk,container,false);
        lvyeucauketban=(ListView) view.findViewById(R.id.lvyeucauketban);
        arryeucauketban=new ArrayList<Yeucauketban>();
        //Khởi tạo đối tượng adapter và gán Data source
        adapter=new YeucauketbanAdapter(
                getActivity(),
                R.layout.item_yeucauketban,arryeucauketban);
        lvyeucauketban.setAdapter(adapter);//gán Adapter vào Lisview
        Yeucauketban fr = new Yeucauketban("Đinh Tuấn Thanh","trạng thái",null);
        Yeucauketban fr1 = new Yeucauketban("Mai Ngọc Duẩn","trạng thái",null);
        Yeucauketban fr2 = new Yeucauketban("Phùng Văn Tài","trạng thái",null);
        Yeucauketban fr3 = new Yeucauketban("Vũ Ngọc Huyền","trạng thái",null);
        arryeucauketban.add(fr);
        arryeucauketban.add(fr1);
        arryeucauketban.add(fr2);
        arryeucauketban.add(fr3);

        return view;
    }
}
