package net.greybeardedgeek;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class HelloAndroidActivity extends Activity {

    private TextView txtView;
    private ImageView imgView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ConstrainedDragAndDropView dndView = (ConstrainedDragAndDropView) findViewById(R.id.dndView);

        imgView = (ImageView) findViewById(R.id.draggable1);
        txtView = (TextView) findViewById(R.id.draggable);
        /*
        dndView.setDragHandle(findViewById(R.id.draggable));
        dndView.setDragHandle(findViewById(R.id.draggable1));
        */dndView.setAllowVerticalDrag(true);

        //dndView.addDropTarget(findViewById(R.id.bg));

        dndView.setDropListener(new ConstrainedDragAndDropView.DropListener() {
            @Override
            public void onDrop(int dropIndex, View dropTarget) {
                Log.i("DATA","Dropped on Traget  "+ dropIndex);
            }
        });

        txtView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                dndView.setDragHandle(v);
                return false;
            }
        });

        imgView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                dndView.setDragHandle(v);
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(net.greybeardedgeek.R.menu.main, menu);
        return true;
    }


}

