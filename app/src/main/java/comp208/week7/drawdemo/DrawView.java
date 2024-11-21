package comp208.week7.drawdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * DrawView is a custom View that allows the user to draw on the screen.
 * It supports different colors, stroke widths, and styles.
 * It also supports dotted and dashed lines through the use of a DashPathEffect.
 */
public class DrawView extends View {

    // Paint object used for drawing
    Paint paint = new Paint();

    // List of paths drawn by the user
    ArrayList<PathX> paths = new ArrayList<>();

    // Current path being drawn
    PathX path;

    // Current color, stroke width, and style
    Paint currentColourPaint;
    int currentStroke = 20;
    Paint.Style currentStyle = Paint.Style.STROKE;

    /**
     * Constructor for DrawView.
     * Initializes the paint object with default color, stroke width, and style.
     */
    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        paint.setColor(Color.BLACK);
        paint.setStyle(currentStyle);
        paint.setStrokeWidth(currentStroke);
        currentColourPaint = paint;
    }

    /**
     * Draws all paths on the canvas.
     * This method is called whenever the view is invalidated.
     */
    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);

        for (PathX path2 : paths) {
            if (path2 != null){
                canvas.drawPath(path2, path2.paint);
            }
        }
    }

    /**
     * Method to start a new drawing path.
     */
    public void beginPath(float x, float y) {
        path = new PathX();
        path.moveTo(x,y);
        invalidate();
    }

    /**
     * Method to add a point to the current drawing path.
     */
    public void addPointToPath(float x, float y) {
        path.lineTo(x, y);
        path.setPaint(paint);
        paths.add(path);
        invalidate();
    }

    /**
     * Method to set the drawing color.
     */
    public void setActualColour(int color){
        paint = new Paint();
        paint.setColor(color);
        paint.setStyle(currentColourPaint.getStyle());
        paint.setStrokeWidth(currentColourPaint.getStrokeWidth());
        currentColourPaint = paint;
    }

    /**
     * Method to set the stroke width.
     */
    public void setStroke(int stroke){
        paint = new Paint();
        paint.setColor(currentColourPaint.getColor());
        paint.setStyle(currentColourPaint.getStyle());
        paint.setStrokeWidth(stroke);
        currentColourPaint = paint;
    }

    /**
     * Method to set the paint style.
     */
    public void setStyle(String style){
        if(style == "fill"){
            currentStyle = Paint.Style.FILL;
        }else if(style == "stroke"){
            currentStyle = Paint.Style.STROKE;
        }
    }

    /**
     * Method to set the line style.
     */
    public void setLineStyle(DashPathEffect dashPathEffect){
        paint = new Paint();
        paint.setColor(currentColourPaint.getColor());
        paint.setStyle(currentColourPaint.getStyle());
        paint.setStrokeWidth(currentColourPaint.getStrokeWidth());
        paint.setPathEffect(dashPathEffect);
        currentColourPaint = paint;
    }

    /**
     * Method to clear the drawing.
     */
    public void clear(){
        paths.clear();
        invalidate();
    }
}