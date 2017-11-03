package com.example.maiduan.android_project_2.view.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.maiduan.android_project_2.R;
import com.example.maiduan.android_project_2.adapter.ViewpagerAdapter;
import com.example.maiduan.android_project_2.model.entity.Fragments;
import com.example.maiduan.android_project_2.view.entity.ViewPagerNoScroll;
import com.example.maiduan.android_project_2.view.fragment.ChatFragment;
import com.example.maiduan.android_project_2.view.fragment.FriendFragment;
import com.example.maiduan.android_project_2.view.fragment.NewFeedFragment;
import com.example.maiduan.android_project_2.view.fragment.RoomFragment;

import java.util.ArrayList;
import java.util.List;
/**
 * Tai
 */
public class MainActivity extends AppCompatActivity {
    BottomNavigationView bnv;
    ViewPagerNoScroll viewPager;
    MenuItem prevMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initBottomNavigation();
    }

    private void initBottomNavigation() {
        bnv = findViewById(R.id.bnv);
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_newfeed:
                        viewPager.setCurrentItem(0);
                        break;
                    case (R.id.action_ichat):
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.action_chatroom:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.action_friend:
                        viewPager.setCurrentItem(3);
                        break;
                }
                return false;
            }
        });
    }

    private void init() {
        viewPager = findViewById(R.id.viewpager);
        viewPager.setPagingEnabled(false);
        List<Fragments> arr = new ArrayList<>();
        arr.add(new Fragments(NewFeedFragment.newInstance()));
        arr.add(new Fragments(ChatFragment.newInstance()));
        arr.add(new Fragments(RoomFragment.newInstance()));
        arr.add(new Fragments(FriendFragment.newInstance()));
        ViewpagerAdapter vpa = new ViewpagerAdapter(getSupportFragmentManager(), arr);
        viewPager.setAdapter(vpa);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                }
                else
                {
                    bnv.getMenu().getItem(0).setChecked(false);
                }

                bnv.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bnv.getMenu().getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
