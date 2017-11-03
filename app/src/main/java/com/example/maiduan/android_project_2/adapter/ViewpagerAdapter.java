package com.example.maiduan.android_project_2.adapter;
/**
 *Dinh Thanh zz
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.maiduan.android_project_2.model.entity.Fragments;

import java.util.List;
public class ViewpagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragments> fragmentses;

    public ViewpagerAdapter(FragmentManager fm, List<Fragments> fragmentses) {
        super(fm);

        this.fragmentses = fragmentses;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentses.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return fragmentses.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (fragmentses.get(position).getTitle() == null)
            return super.getPageTitle(position);
        else
            return fragmentses.get(position).getTitle();
    }
}
