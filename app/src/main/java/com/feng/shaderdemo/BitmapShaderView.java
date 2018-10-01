package com.feng.shaderdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author Feng Zhaohao
 * Created on 2018/9/29
 */
public class BitmapShaderView extends View {

    private Paint mPaint;

    public BitmapShaderView(Context context) {
        super(context);
        init();
    }

    public BitmapShaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BitmapShaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.picture);
        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        //第一个参数是Bitmap，第二、第三个参数分别是x轴和y轴的TileMode（可以理解为显示模式）
        //TileMode有三种，CLAMP（图片超过边界则复制边缘颜色）、REPEAT（无限重复）、MIRROR（镜像对称）

        mPaint.setShader(bitmapShader);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setTextSize(200);
        mPaint.setStyle(Paint.Style.FILL);

        canvas.drawText("演示文字", 150, 300, mPaint);
    }
}
