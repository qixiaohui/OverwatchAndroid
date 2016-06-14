package com.infi.overwatch.overwatchandroid.Component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

/**
 * Created by TQi on 6/14/16.
 */
public class HeroDetailContainerView extends LinearLayout implements Target{
    public HeroDetailContainerView(Context context){
        this(context, null);
    }

    public HeroDetailContainerView(Context context, AttributeSet attrs){
        this(context, attrs, 0);
    }

    public HeroDetailContainerView(Context context, AttributeSet attrs, int defStyle){
        super(context, attrs, defStyle);
    }

    @Override
    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
        setBackground(new BitmapDrawable(getResources(), bitmap));
    }

    @Override
    public void onBitmapFailed(Drawable errorDrawable) {

    }

    @Override
    public void onPrepareLoad(Drawable placeHolderDrawable) {

    }
}
