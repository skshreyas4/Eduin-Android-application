package com.example.shreyassk.basicanim;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView image;
   // TextView text;
    /** Duration of wait **/
    private static int SPLASH_TIME_OUT = 2000;

    /** Called when the activity is first created. */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image=(ImageView)findViewById(R.id.logo);
        image.animate().alpha(0f).setDuration(2000);
        //image.animate().rotation(360).setDuration(2000);
        //image.animate().translationZ(2000).setDuration(2000);
       // text=(TextView)findViewById(R.id.tt1);
        //text.animate().alpha(0f).setDuration(2000);


        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,Screen2.class);
                startActivity(intent);
                finish();

            }
        }, SPLASH_TIME_OUT);
    }
}
