package com.feng.shaderdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author Feng Zhaohao
 * Created on 2018/10/1
 */
public class RadialGradientView extends View {

    private Paint mPaint;

    public RadialGradientView(Context context) {
        super(context);
        init();
    }

    public RadialGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RadialGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();

        int [] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};
        RadialGradient radialGradient = new RadialGradient(500, 500, 400, colors, null, Shader.TileMode.CLAMP);
        //第一、二个参数是中心点的x、y坐标，第三个参数是半径，第四个参数是颜色集合（至少两种颜色）
        //第五个参数是颜色分布（传入null表示均分），第六个参数是显示模式
        //RadialGradient还有一个构造方法，跟上面差不多，就是只能指定两种颜色，这里就不演示了

        mPaint.setShader(radialGradient);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setStyle(Paint.Style.FILL);

        canvas.drawCircle(500, 500, 400, mPaint);
    }
}
