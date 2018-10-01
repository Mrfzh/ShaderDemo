package com.feng.shaderdemo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author Feng Zhaohao
 * Created on 2018/10/1
 */
public class LinearGradientView extends View {

    private Paint mPaint;
    private Paint mPaintTwo;

    public LinearGradientView(Context context) {
        super(context);
        init();
    }

    public LinearGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LinearGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaintTwo = new Paint();

        LinearGradient linearGradient = new LinearGradient(50, 50, 500, 50, Color.RED, Color.BLUE, Shader.TileMode.MIRROR);
        //x0,y0为开始坐标，x1,y1为结束坐标，第五、六个参数分别是开始颜色和结束颜色，最后一个参数是显示模式。
        mPaint.setShader(linearGradient);

        int [] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};
        //float [] positions = {0.0f, 0.4f, 0.6f, 1.0f};
        LinearGradient linearGradientTwo = new LinearGradient(50, 50, 1000, 50, colors, null, Shader.TileMode.CLAMP);
        //前四个参数同上，第五个参数是颜色集合，表示梯度中有多少个颜色（至少要有两个，不然报错）
        //第六个参数是颜色分布集合（元素个数要和颜色个数对应，不然报错），为空则均匀分布，最后一个参数同样是显示模式
        mPaintTwo.setShader(linearGradientTwo);

    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setStyle(Paint.Style.FILL);
        mPaintTwo.setStyle(Paint.Style.FILL);

        canvas.drawRect(new RectF(50, 0, 950, 100), mPaint);
        canvas.drawRect(new RectF(50, 150, 1000, 250), mPaintTwo);
    }
}
