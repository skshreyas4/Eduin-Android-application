package com.swish.eduin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.os.Bundle;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Screen4 extends Activity implements AdapterView.OnItemSelectedListener {
    private Spinner spinner1, spinner2, spinner3;
    List<FilterClass> list;
    DBHelper db;
    private static final String[] location={"Location","North","South"};
    private static final String[] syllabus={"Syllabus","State","Cbse","Icse"};
    private static final String[] category={"Category","Nursery","Primary","Highschool"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen4);

        spinner1 = findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Screen4.this,
                android.R.layout.simple_spinner_item, location);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(Screen4.this);

        spinner2 = findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(Screen4.this,
                android.R.layout.simple_spinner_item, syllabus);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter1);
        spinner2.setOnItemSelectedListener(Screen4.this);

        spinner3 = findViewById(R.id.spinner3);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(Screen4.this,
               android.R.layout.simple_spinner_item, category);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);
        spinner3.setOnItemSelectedListener(Screen4.this);

    }

    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        switch (position) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    public void accept(View view) {
        String location = spinner1.getSelectedItem().toString();
        String syallabus = spinner2.getSelectedItem().toString();
        String category = spinner3.getSelectedItem().toString();
        Intent intent1 = new Intent(Screen4.this, Screen41.class);
        intent1.putExtra("spinner1",location);
        intent1.putExtra("spinner2",syallabus);
        intent1.putExtra("spinner3",category);
        startActivity(intent1);
    }

    public void cancel(View view) {
        Intent intent1 = new Intent(Screen4.this, Screen3.class);
        startActivity(intent1);
    }

    }




