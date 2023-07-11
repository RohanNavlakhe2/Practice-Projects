package com.example.customviewsdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.provider.CalendarContract;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;

import com.google.android.material.color.MaterialColors;

public class DrawingView extends View {
    private Paint paint;
    private Path path;
    private static final String TAG = "Drawing";

    public DrawingView(Context context) {
        super(context);
    }

    public DrawingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DrawingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public DrawingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init()
    {
        paint = new Paint();
        path = new Path();
        paint.setColor(ResourcesCompat.getColor(getResources(),R.color.teal_200,null));
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        Log.d("Drawing","Width: "+width+" Height: "+height);
        //canvas.drawLine(0,0,width/2,height/2,paint);
        canvas.drawPath(path,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG,"onTouch");
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG,"Down: X"+event.getX()+" y: "+event.getY());
                path.moveTo(event.getX(),event.getY());
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(TAG,"Move:X"+event.getX()+" y: "+event.getY());
                path.lineTo(event.getX(),event.getY());
                break;
        }
        invalidate();
        return true;
    }
}
