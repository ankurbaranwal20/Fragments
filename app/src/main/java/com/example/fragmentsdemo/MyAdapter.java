package com.example.fragmentsdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class MyAdapter extends FragmentStatePagerAdapter
{
    static final int pages = 3;
    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment1 f = null;
        switch (i)
        {
            case 0:
                f=Fragment1.getInstance(R.drawable.ic_launcher_foreground,"My First Message");
                break;
            case 1:
                f= Fragment1.getInstance(R.drawable.ic_launcher_foreground,"My Second Message");
                break;
            case 2:
                f=Fragment1.getInstance(R.drawable.ic_launcher_foreground,"My Third Message");
                break;
        }
        return f;
    }

    @Override
    public int getCount() {
        return pages;
    }
}
