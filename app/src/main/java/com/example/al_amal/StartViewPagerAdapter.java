package com.example.al_amal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class StartViewPagerAdapter extends PagerAdapter {

    Context mContext;
    List<ScreenItem>mListScreen;

    public StartViewPagerAdapter(Context mContext, List<ScreenItem> mListScreen) {
        this.mContext = mContext;
        this.mListScreen = mListScreen;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layoutScreen = inflater.inflate(R.layout.layout_screen,null);

//        ImageView screenImg  = layoutScreen.findViewById(R.id.intro_img);
//        TextView desc = layoutScreen.findViewById(R.id.desc_text);
//
//        screenImg.setImageResource(mListScreen.get(position).getScreenImg());
//        desc.setText(mListScreen.get(position).getDesc());
//
//        container.addView(layoutScreen);
        return layoutScreen;



    }

    @Override
    public int getCount() {
        return mListScreen.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((View)object);
    }
}
