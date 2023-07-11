package com.example.customviewsdemo;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;

public class CustomTextView extends androidx.appcompat.widget.AppCompatTextView {
    Drawable end;
    public CustomTextView(@NonNull Context context) {
        super(context);
        init();
    }

    public CustomTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

   /* @Override
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@Nullable Drawable start, @Nullable Drawable top, @Nullable Drawable end, @Nullable Drawable bottom) {
        end = ResourcesCompat.getDrawable(getResources(),R.drawable.ic_launcher_background,null);
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(start, top, end, bottom);
    }*/

    private void init()
    {
        end = ResourcesCompat.getDrawable(getResources(),R.drawable.ic_launcher_background,null);
        setCompoundDrawablesRelativeWithIntrinsicBounds(null,null, end, null);
    }
}
