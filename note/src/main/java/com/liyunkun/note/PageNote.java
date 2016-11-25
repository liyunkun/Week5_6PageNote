package com.liyunkun.note;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.EditText;

/**
 * Created by liyunkun on 2016/9/24 0024.
 */
public class PageNote extends EditText {
    private int padding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics());
    private Paint linePaint;

    public PageNote(Context context) {
        this(context, null);
    }

    public PageNote(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PageNote(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        linePaint = new Paint();
        linePaint.setAntiAlias(true);
        linePaint.setColor(Color.BLACK);
        linePaint.setStrokeWidth(2);

        setBackgroundResource(R.drawable.background);
        setPadding(padding, 0,padding,0);
        setFocusableInTouchMode(true);
        setTextSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,14,getResources().getDisplayMetrics()));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getMeasuredHeight();
        int width = getMeasuredWidth();
        int lineHeight = getLineHeight();
        int countLine = height / lineHeight;
        for (int i = 0; i < countLine; i++) {
            canvas.drawLine(padding, lineHeight * (i + 1), width - padding, lineHeight * (i + 1), linePaint);
        }
        int lineCount = getLineCount();
        int count = countLine - lineCount;
        if(count < 0){
            for (int i = countLine; i < lineCount; i++) {
                canvas.drawLine(padding, lineHeight * (i + 1), width - padding, lineHeight * (i + 1), linePaint);
            }
        }
    }
}
