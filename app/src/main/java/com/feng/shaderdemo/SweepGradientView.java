package com.feng.shaderdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author Feng Zhaohao
 * Created on 2018/9/29
 */
public class SweepGradientView extends View {

    private Paint mPaint;

    public SweepGradientView(Context context) {
        super(context);
        init();
    }

    public SweepGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SweepGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();

        SweepGradient sweepGradient = new SweepGradient(300, 300, Color.RED, Color.BLUE);
        //官方解释：A Shader that draws a sweep gradient around a center point.
        //以View的相对坐标为中心点，绘制一扫描梯度（从一种颜色开始，到另一种颜色结束）作为着色器
        mPaint.setShader(sweepGradient);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setStyle(Paint.Style.FILL);

        //通过画这几个圆对比，发现只有第一个是真正具有完整梯度的，因为着色器的中心就是（300,300）
        canvas.drawCircle(300, 300, 100, mPaint);
        canvas.drawCircle(600, 300, 100, mPaint);
        canvas.drawCircle(500, 500, 100, mPaint);
        canvas.drawCircle(100, 500, 100, mPaint);
    }
}
