package com.vteam.foodfriends.ui.custom_view;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.Log;

import com.vteam.foodfriends.R;

/**
 * Created by H2PhySicS on 12/2/2017.
 */

public class TimeTextView extends AppCompatTextView {
    private int width;
    private int height;
    private boolean isSelected;
    private Paint paint;
    private Paint textPaint;

    public TimeTextView(Context context) {
        super(context);
        init();
    }

    public TimeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TimeTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.restore();
        float xPos = (float) (width - textPaint.getTextSize() * Math.abs(this.length() / 2)) / 2;
        int yPos = (int) (height / 2 - (textPaint.ascent() + textPaint.descent()) / 2);
        String text = (String) getText();
        int offset = width / 10;
        if (isSelected){
            canvas.drawRect(offset, -offset, width - offset, height + offset, paint);
            canvas.drawText(text, xPos, yPos, textPaint);
//            canvas.save();
        }

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        setup();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        setup();
    }

    public void setSelectedItem(){
        isSelected = true;
        setup();
    }

    public void removeSelectedItem(){
        isSelected = false;
        setup();
    }

    private void init(){
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    private void setup(){
        if (getWidth() == 0 && getHeight() == 0){
            return;
        }

        width = getWidth();
        height = getHeight();
//        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(getResources().getColor(R.color.bottom_plus_icon));
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setTextSize(70);
        textPaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
        textPaint.setColor(getResources().getColor(R.color.white));
//        if (isSelected){
//
//        } else {
//            textPaint.setColor(getResources().getColor(R.color.bottom_plus_icon));
//        }
        invalidate();
    }
}
