package comp208.week7.drawdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    /*The drawing app utilizes the DrawView class to create a customizable drawing canvas.
    The MainActivity sets up color, stroke width, and style buttons to control drawing properties.
    Touch events are used to draw on the canvas,
    with functionality to clear the canvas and change drawing settings.*/

    /*
    The drawing app consists of a DrawView class that extends View to handle drawing
    operations and a MainActivity class for the app's user interface.
    DrawView uses a Paint object for styling and a Path object to track the drawing path.
    Methods like beginPath and addPointToPath manage the drawing process, while setActualColour,
    setStroke, setStyle, and clear handle color, stroke width, style, and clearing the canvas.
    MainActivity includes buttons for color, stroke width, and style selection,
    with click listeners to update drawing properties. Touch events on DrawView trigger drawing actions,
    providing users with a customizable and interactive drawing experience.
    * */

    DrawView canvas;

//    TextView transparent;
//    TextView r;
//    TextView g;
//    TextView b;

    EditText r;
    EditText g;
    EditText b;
    EditText transparent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        //getting ready the canvas, this is coming from DrawView
        canvas =  findViewById(R.id.canvas);



        /*Below are Style button*/
        Button fillStyle = findViewById(R.id.btnFill);
        Button stroke = findViewById(R.id.btnStroke);

        //clear button
        Button clear = findViewById(R.id.btnClear);



        /*based on the specific style pressed, it triggers the canvas which is
         * derived from the drawView*/
        fillStyle.setOnClickListener(view -> canvas.setStyle("fill"));
        stroke.setOnClickListener(view -> canvas.setStyle("stroke"));

        //clear the canvas by setting beginPath and addPointToPath to 0, 0
        clear.setOnClickListener(view -> canvas.clear());



        /*Based on onTouch method of the View.OnTouchListener interface*/
        @SuppressLint("ClickableViewAccessibility") View.OnTouchListener touchListener =
                (view, event) -> {
                    int action = event.getActionMasked();

                    // Switch statement to handle different types of touch actions
                    switch (action)
                    {
                        // When the user touches the screen
                        case MotionEvent.ACTION_DOWN:
                            // Start a new path at the touch coordinates
                            canvas.beginPath(event.getX(), event.getY());
                            break;
                        // When the user lifts their finger or moves it on the screen
                        case MotionEvent.ACTION_UP:
                        case MotionEvent.ACTION_MOVE:
                            // Add a point to the current path at the touch coordinates
                            canvas.addPointToPath(event.getX(),event.getY());
                            break;
                    }
                    // Return true to indicate that the touch event has been consumed
                    return true;
                };

        // Set the touch listener on the canvas
        canvas.setOnTouchListener(touchListener);

    }
    public void onColorButtonClick(View view) {
        int color = Color.BLACK; // Default color
        if (view.getId() == R.id.btnRed) {
            color = Color.RED;
        } else if (view.getId() == R.id.btnYellow) {
            color = Color.YELLOW;
        } else if (view.getId() == R.id.btnGreen) {
            color = Color.GREEN;
        } else if (view.getId() == R.id.btnCyan) {
            color = Color.CYAN;
        } else if (view.getId() == R.id.btnBlue) {
            color = Color.BLUE;
        } else if (view.getId() == R.id.btnPink) {
            color = Color.MAGENTA;
        } else if (view.getId() == R.id.btnBlack) {
            color = Color.BLACK;
        } else if (view.getId() == R.id.btnWhite) {
            color = Color.WHITE;
        }
        canvas.setActualColour(color);
    }

    public void setWidthClick(View view) {
        int width = 2; // Default color
        if (view.getId() == R.id.btnBrush) {
            width = 80;
        } else if (view.getId() == R.id.btnCrayon) {
            width = 30;
        } else if (view.getId() == R.id.btnPencil) {
            width = 2;
        }
        canvas.setStroke(width);
    }

    public void setStyleClick(View view) {
        float[] dash = {80, 10};
        float[] dot = {5, 7};
        float[] style = null; // Default style

        if (view.getId() == R.id.btnDash) {
            style = dash;
        } else if (view.getId() == R.id.btnDot) {
            style = dot;
        }

        if (style != null) {
            DashPathEffect dashPath = new DashPathEffect(style, 0);
            canvas.setLineStyle(dashPath);
        }
    }


    public void setCustomColour(View view) {

         transparent = findViewById(R.id.inputT);
         r = findViewById(R.id.inputR);
         g = findViewById(R.id.inputG);
         b = findViewById(R.id.inputB);

        transparent.getText();
        r.getText();
        g.getText();
        b.getText();
        Log.i("Color", "Color is: " + transparent.getText() + r.getText() + g.getText() + b.getText());

        int color = Color.argb(Integer.parseInt(transparent.getText().toString()), Integer.parseInt(r.getText().toString()), Integer.parseInt(g.getText().toString()), Integer.parseInt(b.getText().toString()));
        canvas.setActualColour(color);

    }
}