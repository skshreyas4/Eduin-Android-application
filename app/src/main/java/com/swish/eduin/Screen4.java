package com.swish.eduin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Screen4 extends Activity implements AdapterView.OnItemSelectedListener {
    private Spinner spinner1, spinner2, spinner3;
    private static final String[] location = {"LOCATION", "Hoskerehalli", "Seethacircle", "Channasandra"};
    private static final String[] syllabus = {"SYLLABUS", "state", "cbse", "icse"};
    private static final String[] category = {"CATEGORY", "Nursery", "Primary", "High School"};

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


        SharedPreferences prefs = getSharedPreferences("school", MODE_PRIVATE);
        String restoredText = prefs.getString("text", null);
        if (restoredText != null && restoredText == "school")

        {
            String location = prefs.getString("Schoolname", "location");
            int location1 = prefs.getInt("id", 1);
            String syllabus = prefs.getString("name", "syllabus");
            int syllabus1 = prefs.getInt("id", 2);//"No name defined" is the default value.
            String category = prefs.getString("name", "category");
            int category1 = prefs.getInt("id", 3);
        }

        SharedPreferences prefs1 = getSharedPreferences("vacancy", MODE_PRIVATE);
        String restoredText2 = prefs1.getString("text", null);
        if (restoredText2 != null)

        {
            String location = prefs1.getString("name", "location");
            int location1 = prefs1.getInt("id", 1);
        }

        SharedPreferences prefs2 = getSharedPreferences("institute", MODE_PRIVATE);
        String restoredText3 = prefs1.getString("text", null);
        if (restoredText3 != null && restoredText3 == "Institute")

        {
            String location = prefs2.getString("name", "location");
            int location1 = prefs2.getInt("id", 1);
        }


        ArrayList<SpinnerModle> arrayList = new ArrayList<>();

        for (int i = 0; i < location.length; i++) {
            SpinnerModle spinnerModle = new SpinnerModle();
            spinnerModle.textvalue = location[i];
            spinnerModle.selected = false;
        }

        for (int i = 0; i < syllabus.length; i++) {
            SpinnerModle spinnerModle1 = new SpinnerModle();
            spinnerModle1.textvalue = syllabus[i];
            spinnerModle1.selected = false;
        }

        for (int i = 0; i < category.length; i++) {
            SpinnerModle spinnerModle2 = new SpinnerModle();
            spinnerModle2.textvalue = category[i];
            spinnerModle2.selected = false;
        }
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

    public void Accept(View view) {
        Intent intent1 = new Intent(Screen4.this, Screen3.class);
        startActivity(intent1);
    }

    public void Cancel(View view) {
        Intent intent1 = new Intent(Screen4.this, Screen3.class);
        startActivity(intent1);
    }

    class SpinnerModle {
        String textvalue;
        boolean selected;

    }

    public class MyAdapter extends ArrayAdapter<SpinnerModle> {
        private Context context;
        private ArrayList<SpinnerModle> list;
        private MyAdapter myAdapter;
        private boolean isFromView = false;

        public MyAdapter(@NonNull Context context, int resource, List<SpinnerModle> objects) {
            super(context, resource, objects);
            this.context = context;
            this.list = (ArrayList<SpinnerModle>) objects;
            this.myAdapter = this;
        }

        @Override
        public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            return super.getDropDownView(position, convertView, parent);
        }

        public View getCustomView(final int position, View convertView, ViewGroup parent) {
            final ViewHolder holder;
            if (convertView == null) {
                LayoutInflater layoutInflater = LayoutInflater.from(context);
                convertView = layoutInflater.inflate(R.layout.checkbox, null);
                holder = new ViewHolder();
                holder.textView = (TextView) convertView.findViewById(R.id.tv1);
                holder.checkBox = (CheckBox) convertView.findViewById(R.id.cb1);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.textView.setText(list.get(position).textvalue);
            isFromView = true;
            holder.checkBox.setChecked(list.get(position).selected);
            isFromView = false;

            if ((position == 0)) {
                holder.checkBox.setVisibility(View.INVISIBLE);
            } else {
                holder.checkBox.setVisibility(View.VISIBLE);
            }

            holder.checkBox.setTag(position);
            holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    int getPosition = (Integer) compoundButton.getTag();

                    if (!isFromView) {
                        list.get(position).selected = b;
                    }
                }
            });
            return convertView;
        }

        private class ViewHolder {
            private TextView textView;
            private CheckBox checkBox;
        }
    }

    public void accept(View view){
        Intent i = new Intent(Screen4.this,Screen5.class);
        startActivity(i);
    }
}




