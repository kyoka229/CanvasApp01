package com.example.dojo.canvasapp01;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

public class CanvasView extends View {
    private Paint paint;
    private Path path;

    public CanvasView(Context context){
        super(context);

        paint = new Paint();
        path = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas){
        // キャンバスの幅と高さを調べる
        float sx = canvas.getWidth();
        float sy = canvas.getHeight();

        //背景を塗りつぶす
        canvas.drawColor(Color.GRAY);

        //円を描く
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20);
        canvas.drawCircle(sx/2,sy/2,200,paint);

        //四角を描く
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(200,100,500,500,paint);

        //線を描く
        paint.setColor(Color.YELLOW);
        paint.setStrokeWidth(40);
        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawLine(0,100,sx - 20,sy - 300,paint);

        //三角を描く（パスを使う）
        paint.setColor(Color.MAGENTA);
        paint.setStrokeWidth(20);

        path.moveTo(500,600);
        path.lineTo(700,1200);
        path.lineTo(300,1200);
        path.lineTo(500,600);

        canvas.drawPath(path,paint);

    }

}
