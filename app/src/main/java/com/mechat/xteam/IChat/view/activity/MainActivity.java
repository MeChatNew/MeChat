package com.mechat.xteam.IChat.view.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.mechat.xteam.IChat.R;
import com.mechat.xteam.IChat.adapter.ViewpagerAdapter;
import com.mechat.xteam.IChat.model.entity.Fragments;
import com.mechat.xteam.IChat.view.entity.ViewPagerNoScroll;
import com.mechat.xteam.IChat.view.fragment.ChatFragment;
import com.mechat.xteam.IChat.view.fragment.FriendFragment;
import com.mechat.xteam.IChat.view.fragment.NewFeedFragment;
import com.mechat.xteam.IChat.view.fragment.RoomFragment;

import java.util.ArrayList;
import java.util.List;
/**
 * Tai
 */
public class MainActivity extends AppCompatActivity {
    BottomNavigationView bnv;
    ViewPagerNoScroll viewPager;
    MenuItem prevMenuItem;
    CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        init();
        initBottomNavigation();
    }

    private void initBottomNavigation() {
        bnv = (BottomNavigationView) findViewById(R.id.bnv);
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
        viewPager = (ViewPagerNoScroll) findViewById(R.id.viewpager);
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
