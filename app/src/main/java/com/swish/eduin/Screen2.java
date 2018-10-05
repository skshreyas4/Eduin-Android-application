package com.swish.eduin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class Screen2 extends AppCompatActivity {
    String school;
    SharedPreferences shares;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.screen2);
        TextView tv=(TextView)findViewById(R.id.edit1);
        tv.setText(getIntent().getStringExtra("Username"));
        shares = getSharedPreferences("SHAREDPREF",MODE_PRIVATE);
        editor = shares.edit();
    }

    public void school(View view) {
        Intent intent2 = new Intent(Screen2.this,Screen3.class);
        intent2.putExtra("TYPE","school");
        startActivity(intent2);
        editor.putString("TYPE", "School");
        editor.apply();
    }

    public void job(View view){
        Intent intent3=new Intent(Screen2.this, SearchResult.class);
        startActivity(intent3);
    }

    public void institute(View view){
        Intent intent4=new Intent(Screen2.this,Screen3.class);
        intent4.putExtra("TYPE","Institute");
        startActivity(intent4);
        editor.putString("TYPE", "Institute");
        editor.apply();
    }
}
